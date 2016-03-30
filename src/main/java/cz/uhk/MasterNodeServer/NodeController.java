package cz.uhk.MasterNodeServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.net.*;
import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.uhk.MasterNodeServer.entity.Node;
import cz.uhk.MasterNodeServer.entity.Sensor;
import cz.uhk.MasterNodeServer.entity.Value;
import cz.uhk.MasterNodeServer.entity.services.NodeService;
import cz.uhk.MasterNodeServer.entity.services.SensorService;
import cz.uhk.MasterNodeServer.entity.services.ValueService;

@Controller
@RequestMapping("/node")
public class NodeController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	ValueService valueService;
	@Autowired
	NodeService nodeService;
	@Autowired
	SensorService sensorService;

	@RequestMapping(value = "/", params="format=json",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Node> home(Locale locale, Model model) {
		List<Node> nodes = new ArrayList<Node>(nodeService.findAllNodes());
		return nodes;
	}
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home(Model model) {
		List<Node> valueList = nodeService.findAllNodes();
			model.addAttribute("valueList", valueList);
		return "value";
	}
	
	@RequestMapping(value = "hi",method = RequestMethod.GET)
	public String home3(Model model) {
		String serverName = "localhost";
	      int port = Integer.parseInt("9999");
		 String receivedMessage = setupServer(model,serverName,port );
	      model.addAttribute("server", serverName);
	      model.addAttribute("message", receivedMessage);

		return "socket/message";
	}

	private String setupServer(Model model, String serverName,int port ) {
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
	         out.writeUTF("Hi, What's the Date Today?");
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
	
	@RequestMapping(method = RequestMethod.GET)
	public String def(){
		logger.info("Nothing to do... Redirected to home");
		return "redirect:/";
	}
}
