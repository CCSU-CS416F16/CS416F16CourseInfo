package edu.ccsu.cs416.springschooldirectory;

public enum ClassType {
	 
	  KINDERGARTEN( "Kindergarten"),
	  FIRST("First grade"),
	  SECOND("Second grade"),
	  THIRD("Third grade"),
	  FOURTH("Fourth grade"),
	  FIFTH("Fifth grade");
	 
	  private String description;
	 
	  private ClassType(String description) {
	    this.description = description;
	  }
	 
	  public String getValue() {
	    return name();
	  }
	 
	  public String getDescription() {
	    return description;
	  }
	 
	}
