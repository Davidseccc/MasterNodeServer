package cz.uhk.MasterNodeServer;

import java.text.DateFormat;
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

import cz.uhk.MasterNodeServer.entity.Value;
import cz.uhk.MasterNodeServer.entity.services.ValueService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	ValueService valueService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/", "/dashboard"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);

		List<Value> valueList = valueService.findValueEntries(0, 7);
		
		List<Float> ds_garazList = valueService.findValuebySensor("ds_garaz", 0, 7);
		List<Float> dht_tempList = valueService.findValuebySensor("dht11_01_temp", 0, 7);
		List<Float> cpu01 = valueService.findValuebySensor("cpu01", 0, 7);
		List<Float> cpu02 = valueService.findValuebySensor("cpu02", 0, 7);
		List<Float> cpu03 = valueService.findValuebySensor("cpu03", 0, 7);

		model.addAttribute("serverTime", formattedDate );
	
		model.addAttribute("valueList", valueList);
		model.addAttribute("dsList", ds_garazList);
		model.addAttribute("dhtList", dht_tempList);
		model.addAttribute("cpu01", cpu01);
		model.addAttribute("cpu02", cpu02);
		model.addAttribute("cpu03", cpu03);


		
		return "dashboard/dashboard";
	}
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String dashboard(Locale locale, Model model) {
//		//logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		//String formattedDate = dateFormat.format(date);
//		List<Value> valueList = valueService.findValueEntries(0, 7);
//	
//		//model.addAttribute("serverTime", formattedDate );
//	
//		model.addAttribute("valueList", valueList);
//		
//		return "dashboard";
//	}
	
	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String help(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
	
		model.addAttribute("serverTime", formattedDate );
	
		
		return "home";
	}
	
}
