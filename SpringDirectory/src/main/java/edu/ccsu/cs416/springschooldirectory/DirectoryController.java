package edu.ccsu.cs416.springschooldirectory;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DirectoryController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
    private DirectoryService directoryService;
	
    @RequestMapping(value = "/addclass", method = RequestMethod.GET)
    public String loginPage(Locale locale, Model model) {
    	logger.info("Add class called");
        return "addclass";
    }
    
    @RequestMapping(value = "/classsaved", method = RequestMethod.POST)
    public String login(@Validated SchoolClass passedClass, Model model) {
    	logger.info("SchoolClass saved called");
        model.addAttribute("class", passedClass);
        return "classsaved";
    }
    
    /**
     * List all classes
     * @param model
     * @return
     */
    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public String listClasses(Model model) {
    	logger.info("List classes called");
        model.addAttribute("schoolClasses", directoryService.findAll());
        return "listclasses";
    }
}
