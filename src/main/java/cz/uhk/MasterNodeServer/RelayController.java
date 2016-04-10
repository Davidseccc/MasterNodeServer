package cz.uhk.MasterNodeServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.uhk.MasterNodeServer.entity.Relay;
import cz.uhk.MasterNodeServer.entity.services.NodeService;
import cz.uhk.MasterNodeServer.entity.services.RelayService;
import cz.uhk.MasterNodeServer.entity.services.ValueService;

@Controller
@RequestMapping("/relay")
public class RelayController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	ValueService valueService;
	@Autowired
	NodeService nodeService;
	@Autowired
	RelayService relayService;

	@RequestMapping(value = "/", params="format=json",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Relay> home(Locale locale, Model model) {
		List<Relay> sensors = new ArrayList<Relay>(relayService.findAllSensors());
		return sensors;
	}
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("relayService");
		List<Relay> valueList = relayService.findAllSensors();
			model.addAttribute("valueList", valueList);
		return "relay";
	}
	
	@RequestMapping(value= "/demo_get", method = RequestMethod.GET)
	public String stat(Locale locale, Model model,@RequestParam(value="name") String name, @RequestParam(value="state") boolean state){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		
		String serverName = "192.168.0.163";
	      int port = Integer.parseInt("9999");
	      String message;
	      if (state){message = "RELAY_ON";}
	      else{message = "RELAY_OFF";}
		 String receivedMessage = setupServer(model,serverName,port, message);
	      model.addAttribute("server", serverName);
	      model.addAttribute("message", receivedMessage);
		
	      model.addAttribute("serverTime", formattedDate );
	      model.addAttribute("name", name );
	      model.addAttribute("state", state );
		return "time";
	}
	
	private String setupServer(Model model, String serverName,int port, String message ) {
		String receivedMessage = null;
	      try
	      {
	         System.out.println("Connecting to " + serverName +
			 " on port " + port);
	         Socket client = new Socket(serverName, port);
	         System.out.println("Just connected to " 
			 + client.getRemoteSocketAddress());
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         //out.writeUTF("Hi, What's the Date Today?"
	         //             + client.getLocalSocketAddress());
	         out.writeUTF(message);
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in =
	                        new DataInputStream(inFromServer);
	         receivedMessage = in.readUTF();
	         System.out.println("Server says " + receivedMessage);
	         

	         client.close();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	      return receivedMessage;
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public String def(){
		logger.info("Nothing to do... Redirected to home");
		return "redirect:/";
	}
}
