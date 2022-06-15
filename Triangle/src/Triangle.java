import java.util.Scanner;

public class Triangle {
     

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Въведете първата страна:"); 
        double a = scan.nextDouble();
        
        System.out.println("Въведете втората страна:");
        double b = scan.nextDouble();
        
        System.out.println("Въведете третата страна:");
        double c = scan.nextDouble();
        
        double hypot = 0;
        double side1 = 0;
        double side2 = 0; 
        
        if(a > b && a > c) {
            hypot = a;
            side1 = b;
            side2 = c;
        }
        else if(b > a && b > c) {
            hypot = b;
            side1 = a;
            side2 = c;
        }
        else if(c > b && c > a) {
            hypot = c;
            side1 = a;
            side2 = b;
        }
        
        if(a > 0 && b > 0 && c > 0 && (a+b>c) && (b+c>a) && (a+c>b)) {
            System.out.println("Съществува триъгълник с тези страни!");
            if(a == b && b == c && a == c){
                System.out.println("Триъгълникът е равностранен.");
            } 
            else if(a == b || b == c || c == a) {
                System.out.println("Триъгълникът е равнобедрен.");
                if((Math.pow(side1, 2) + Math.pow(side2, 2) == Math.pow(hypot,2)) == true) {
                    System.out.println("Правоъгълен триъгълник с хипотенуза: "+ hypot);
                }
            }
            else if(a != b && b != c && a != c) {
                System.out.println("Триъгълникът е разностранен.");
                if((Math.pow(side1, 2) + Math.pow(side2, 2) == Math.pow(hypot,2)) == true) {
                    System.out.println("Правоъгълен триъгълник с хипотенуза: "+ hypot);
                }
            }
            
            
        }
        else {
            System.out.println("Не съществува триъгълник с тези страни!"); 
        }
        scan.close();
    }

}
 
