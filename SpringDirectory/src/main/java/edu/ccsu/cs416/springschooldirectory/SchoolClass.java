package edu.ccsu.cs416.springschooldirectory;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * The persistent class for the CLASS database table.
 *
 * @author Chad Williams
 */
@Entity
public class SchoolClass extends AbstractPersistable<Long>{

  private static final long serialVersionUID = 1L;
  private String roomnumber;
  private String teachername;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="assignedClass")
	private Set<Student> students;
  
  public SchoolClass() {
  }

  public String getRoomnumber() {
    return this.roomnumber;
  }

  public void setRoomnumber(String roomnumber) {
    this.roomnumber = roomnumber;
  }

  public String getTeachername() {
    return this.teachername;
  }

  public void setTeachername(String teachername) {
    this.teachername = teachername;
  }

	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
//		student.setAssignedClass(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
//		student.setAssignedClass(null);

		return student;
	}
  @Override
  public String toString() {
    return String.format(
            "SchoolClass[id=%d, teachername='%s', roomnumber='%s']",
            getId(), teachername, roomnumber);
  }
}
