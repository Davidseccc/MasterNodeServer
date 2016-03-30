package cz.uhk.MasterNodeServer;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/api")
public class APIController {
	
	//private static final Logger logger = LoggerFactory.getLogger(APIController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "api/home";
	}
	
}
