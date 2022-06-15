package hw4;   
import java.util.Date;

public abstract class Employee extends Person {
	
	private String id;
	private Date date; 
	
	public Employee(String name, int age, String id, Date date1) {
		super(name, age);
		this.id = id;
		this.date = date1;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	} 
	
	@Override
    public String printInfo() {
        return "Name: "+ this.getName() + ", age: "+ this.getAge() + ", Id: " + this.getId() + ", Date: " + this.getDate();
    } 
}
