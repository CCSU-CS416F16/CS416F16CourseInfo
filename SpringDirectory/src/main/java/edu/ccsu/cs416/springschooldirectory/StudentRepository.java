package edu.ccsu.cs416.springschooldirectory;

import java.util.List;
import javax.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@NamedQuery(name = "Person.findByAssignedClassId", query = "SELECT s FROM Student s WHERE s.assignedClass.id")
public interface StudentRepository extends JpaRepository<Student, Long>{
  public List<Student> findByAssignedClassId(Long assignedClassId);
}
