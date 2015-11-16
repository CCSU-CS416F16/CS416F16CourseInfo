package edu.ccsu.cs416.springschooldirectory;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectoryService {
    private Map<Long,String> schoolClasses;
    
    @Autowired
    private SchoolClassRepository schoolClassRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(DirectoryService.class);
 
    public Iterable<SchoolClass> findAll() {
        logger.info("Retrieving Classes");
        return schoolClassRepository.findAll();
    }
 
    public SchoolClass save(SchoolClass schoolClass){
    	return schoolClassRepository.saveAndFlush(schoolClass);
    }
    
    public void delete(Long id){
    	schoolClassRepository.delete(id);
    }
    
    public SchoolClass findOne(Long id){
    	return schoolClassRepository.findOne(id);
    }
}
