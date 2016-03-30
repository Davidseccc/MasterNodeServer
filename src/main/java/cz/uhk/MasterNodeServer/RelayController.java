package cz.uhk.MasterNodeServer;

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
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("name", name );
		model.addAttribute("state", state );
		return "time";
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public String def(){
		logger.info("Nothing to do... Redirected to home");
		return "redirect:/";
	}
}
