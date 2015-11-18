package edu.ccsu.cs416.springschooldirectory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectoryService {

  @Autowired
  private SchoolClassRepository schoolClassRepository;
  @Autowired
  private StudentRepository studentRepository;

  private static final Logger logger = LoggerFactory.getLogger(DirectoryService.class);

  public Iterable<SchoolClass> findAllClasses() {
    logger.info("Retrieving Classes");
    return schoolClassRepository.findAll();
  }

  public Iterable<Student> findAllStudents() {
    logger.info("Retrieving Students");
    return studentRepository.findAll();
  }

  public SchoolClass saveClass(SchoolClass schoolClass) {
    return schoolClassRepository.saveAndFlush(schoolClass);
  }

  public Student saveStudent(Student student) {
    SchoolClass schoolClass = findClass(student.getNewAssignedClassId());
    student.setAssignedClass(schoolClass);
    student.setNewAssignedClassId(null);
    return studentRepository.saveAndFlush(student);
  }

  public void deleteClass(Long id) {
    schoolClassRepository.delete(id);
  }

  public void deleteStudent(Long id) {
    studentRepository.delete(id);
  }

  public SchoolClass findClass(Long id) {
    return schoolClassRepository.findOne(id);
  }

  public Student findStudent(Long id) {
    return studentRepository.findOne(id);
  }

  public List<Student> findStudentForClass(Long id) {
    return studentRepository.findByAssignedClassId(id);
  }
}
