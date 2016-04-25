package cz.uhk.MasterNodeServer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.uhk.MasterNodeServer.entity.Value;
import cz.uhk.MasterNodeServer.entity.services.NodeService;
import cz.uhk.MasterNodeServer.entity.services.SensorService;
import cz.uhk.MasterNodeServer.entity.services.ValueService;

@Controller
@RequestMapping("/value")
public class ValueController {
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

	@RequestMapping(value = "/", params="format=json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Value> home() {
		return new ArrayList<Value>(valueService.findValueEntries(0, 7));
	}
	
	@RequestMapping(value = "/sensor/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Value> home2(@RequestParam(value="sensor", defaultValue="ds_01") String sensor) {
		return new ArrayList<Value>(valueService.findValueEntriesbySensor(sensor, 0, 8));
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home2(@RequestParam(value="name", defaultValue="cpu01") String name, Model model) {
		List<Value> valueList = valueService.findValueEntriesbySensor(name, 0, 144);
		model.addAttribute(valueList);
		model.addAttribute("caption", "Posledních 24 hodin");
		model.addAttribute("datasetName", name);
		return "valuePlot";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String def(){
		logger.info("Nothing to do... Redirected to home");
		return "redirect:/";
	}
}
