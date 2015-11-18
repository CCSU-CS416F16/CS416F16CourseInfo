package edu.ccsu.cs416.springschooldirectory;

import java.util.Date;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Chad Williams
 */
@Controller
public class AjaxDirectoryController {
  
    private static final Logger logger = LoggerFactory.getLogger(DirectoryController.class);

  @Autowired
  private DirectoryService directoryService;

  @RequestMapping("/ajaxmatchingstudents")
  public String ajaxMatchingStudents(@RequestParam("passedName") String passedName, Model model) {
    logger.info("ajaxMatchingStudents called: passedName="+passedName);
    model.addAttribute("students", directoryService.findStudentsStartingWith(passedName));
    model.addAttribute("passedName", passedName);
    return "matchingStudents";
  }

  @RequestMapping("/ajaxsearch")
  public ModelAndView helloAjaxTest() {
    return new ModelAndView("ajaxsearch", "message", "AJAX test");
  }

  @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
  public @ResponseBody
  String getTime() {

    Random rand = new Random();
    float r = rand.nextFloat() * 100;
    String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
    System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
    return result;
  }
}
