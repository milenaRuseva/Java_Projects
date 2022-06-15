package hw4;

public class Student extends Person {
	
	private String facNum;
	private String major;
	
	public Student(String name, int age, String facNum, String major) {
		super(name, age); 
		this.facNum = facNum;
		this.major = major;
	}
	
	public String getFacNum() {
		return facNum;
	}
	public void setFacNum(String facNum) {
		this.facNum = facNum;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	 
	@Override
    public String printInfo() {
        return "Name: "+ this.getName() + ", age: "+ this.getAge() + ", Faculty ¹: " + this.getFacNum() + ", Major: " + this.getMajor();
    } 
	
}
