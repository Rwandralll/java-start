package croissant.source.entryPoint;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import croissant.source.service.UserService;

@Controller
@RequestMapping("/")
public class Identification {
	
	private static final Logger logger = Logger.getLogger(Identification.class);
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getAllUser(ModelMap model) {
		logger.info("getAllUser");
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return userService.getAllUser().toString();
	}

}
