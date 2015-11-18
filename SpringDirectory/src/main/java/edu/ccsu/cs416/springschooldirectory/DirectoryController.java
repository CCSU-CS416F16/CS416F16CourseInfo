package edu.ccsu.cs416.springschooldirectory;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DirectoryController {

  private static final Logger logger = LoggerFactory.getLogger(DirectoryController.class);

  @Autowired
  private DirectoryService directoryService;

  @RequestMapping(value = "/addclass", method = RequestMethod.GET)
  public String addClass(Locale locale, Model model) {
    logger.info("Add class called");
    return "addclass";
  }

  @RequestMapping(value = "/classsaved", method = RequestMethod.POST)
  public String login(@Validated SchoolClass passedClass, Model model) {
    logger.info("SchoolClass saved called");
    if (passedClass != null) {
      logger.info("SchoolClass: " + passedClass);
    }
    directoryService.saveClass(passedClass);
    model.addAttribute("class", passedClass);
    return "classsaved";
  }

  /**
   * List all classes
   *
   * @param model
   * @return
   */
  @RequestMapping(value = "/classes", method = RequestMethod.GET)
  public String listClasses(Model model) {
    logger.info("List classes called");
    model.addAttribute("schoolClasses", directoryService.findAllClasses());
    return "listclasses";
  }
  
    @RequestMapping(value = "/students", method = RequestMethod.GET)
  public String listStudents(Model model) {
    logger.info("List students called");
    model.addAttribute("students", directoryService.findAllStudents());
    return "liststudents";
  }
  
      @RequestMapping(value = "/studentsinclass-{classID}", method = RequestMethod.GET)
  public String listStudentsForClass(@PathVariable(value="classID") Long classId, Model model) {
    logger.info("Students in class called");
    SchoolClass schoolClass = directoryService.findClass(classId);
    model.addAttribute("students", directoryService.findStudentForClass(classId));
    model.addAttribute("teacher",schoolClass.getTeachername());
    
    return "liststudentsforclass";
  }
  @RequestMapping(value = "/addstudent", method = RequestMethod.GET)
  public String addStudent(Model model) {
    logger.info("Add student called");
    Iterable<SchoolClass> classes = directoryService.findAllClasses();
    Map<Long,String> classChoices = new HashMap();
    for (SchoolClass c : classes){
      classChoices.put(c.getId(), c.getTeachername());
    }
    model.addAttribute("classChoices",classChoices);
    Student student = new Student();
    model.addAttribute("student",student);
    return "addstudent";
  }

  @RequestMapping(value = "/studentsaved", method = RequestMethod.POST)
  public String saveStudent(@ModelAttribute("student") Student student, Model model) {
    logger.info("Student saved called");
    if (student != null) {
      logger.info("Student: " + student);
    }
    directoryService.saveStudent(student);
    return listStudents(model);
  }

}
