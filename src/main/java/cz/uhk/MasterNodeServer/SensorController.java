package cz.uhk.MasterNodeServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.uhk.MasterNodeServer.entity.Sensor;
import cz.uhk.MasterNodeServer.entity.Value;
import cz.uhk.MasterNodeServer.entity.services.NodeService;
import cz.uhk.MasterNodeServer.entity.services.SensorService;
import cz.uhk.MasterNodeServer.entity.services.ValueService;

@Controller
@RequestMapping("/sensor")
public class SensorController {
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
	public @ResponseBody List<Sensor> home(Locale locale, Model model) {
		List<Sensor> sensors = new ArrayList<Sensor>(sensorService.findAllSensors());
		return sensors;
	}
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home(Model model) {
		List<Value> valueList = valueService.findValueEntries(0, 7);
			model.addAttribute("valueList", valueList);
		return "sensor/sensors";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String def(){
		logger.info("Nothing to do... Redirected to home");
		return "redirect:/";
	}
}
