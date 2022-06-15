package hw3;

import java.util.Scanner;

public class Fibonachi { 
	private static long[] numbers;
	
	public static void loopFibonachi(int n) {
		long a = 0, b = 1, c = 0; 
		if(n == 0) {
			System.out.println("Моля въведете число по-голямо от 0");
		}
		else if(n == 1) {
			 System.out.println(n-1);
		 } 
		 else {
		 System.out.println(a);
		 System.out.println(b);
		 for(int i = 1; i < n-1; i++) {  
			 c = a + b;
			 a = b;
			 b = c;
			 System.out.println(c);
		 	} 
		}
	}
	
	public static long recursionFibonachi(int m) { 
		if (m <= 1) {
			return m;
		}
		if (numbers[m] != 0) {
			return numbers[m];
		}
		long numN = recursionFibonachi(m-1) + recursionFibonachi(m-2);
		numbers[m] = numN;
		return numN ;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Колко числа на Фибоначи да ви покажа?");  
		int n = Integer.parseInt(scanner.nextLine());  
		System.out.println("Фибоначи числа изведени чрез цикъл:"); 
		loopFibonachi(n);
		
		System.out.println();
		
		System.out.println("Фибоначи числа изведени чрез рекурсия:");  
		numbers = new long[n+1];
		for(int i = 0; i <= n-1; i++) {
			System.out.println(recursionFibonachi(i));
		} 
        scanner.close();
		 
	}

}
