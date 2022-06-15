package hw4;

import java.util.Date; 
 
public class Faculty extends Employee {
	
	private String position;  

	public Faculty(String name, int age, String id, Date date1, String position) {
		super(name, age, id, date1);
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public String printInfo() {
        return "Name: "+ this.getName() + ", age: "+ this.getAge() + ", Id: " + this.getId() + ", Date: " + this.getDate() + ", Position: "+ this.getPosition();
    }
}
