package hw4; 
 
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.ArrayList;
import java.util.Date;

public class MainClass {

	public static void main(String[] args) throws ParseException {  
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date1 = simpleDateFormat.parse("2018-09-09");
		Date date2 = simpleDateFormat.parse("2018-10-09");
		  
		Student s1 = new Student("Milena", 20, "2001", "STD"); 
		Staff st1 = new Staff("Nikolay", 45, "2345", date1, "worker");
		Faculty f1 = new Faculty("Maria", 35, "001", date2, "fmi");
		
		ArrayList<Person> arr = new ArrayList<Person>();
		
		arr.add(s1); 
		arr.add(st1);
		arr.add(f1);
		
		System.out.println(s1.printInfo()); 
		System.out.println(st1.printInfo());
		System.out.println(f1.printInfo());
	}
}
