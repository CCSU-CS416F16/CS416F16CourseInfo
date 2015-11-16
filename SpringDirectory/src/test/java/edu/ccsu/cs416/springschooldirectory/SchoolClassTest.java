package edu.ccsu.cs416.springschooldirectory;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:servlet-context.xml" })
public class SchoolClassTest {

	@Autowired
	DirectoryService directoryService;

	@Test
	public void CreateTest() {
		SchoolClass sc = new SchoolClass();
		sc.setRoomnumber("WD14");
		sc.setTeachername("Sauerbrunn");
		directoryService.save(sc);
		long id = sc.getId();
		sc = null;
		SchoolClass sc2 = directoryService.findOne(id);
		Assert.assertEquals("Sauerbrunn", sc2.getTeachername());
		sc2 = null;
	}
	
	public DirectoryService getDirectoryService(){
		return directoryService;
	}
	
	public void setDirectoryService(DirectoryService directoryService){
		this.directoryService = directoryService;
	}
}
