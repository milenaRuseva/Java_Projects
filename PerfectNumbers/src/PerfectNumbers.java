import java.util.Scanner; 
import javax.swing.JOptionPane; 

public class PerfectNumbers {
    
    public void printPerfectNumbers() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Въведете начало на интервала:"); 
        int start = scan.nextInt();
        
        System.out.println("Въведете край на интервала:");
        int end = scan.nextInt();
        
        System.out.println("Перфектните числа в този интервал са:");
        for(int i = start; i <= end; i++) {
            int sum = 0; 
            for(int j = 1; j < i ;j++) {
                if(i % j == 0) {
                    sum += j;
                }
            }
            if(sum == i) { 
                System.out.println(i + " ");
            }
        } 
        scan.close();
    }
    
    public void sumOfNumbers() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Въведете начало на интервала:"); 
        int start = scan.nextInt();
        
        System.out.println("Въведете край на интервала:");
        int end = scan.nextInt();
        int sum = 0;
        double avg = 0;
        int br = 0;
        
        for(int i = start; i <= end; i++) {
            sum += start;
            start++;
            br++;
        } 
        avg = sum/br;
        
        System.out.println("Сумата от числата в този интервал е: " + sum);
        System.out.println("Средно аритметично на числата в интервала е: " + avg);
        scan.close();
    }
    public static void main(String[] args) { 
        
        String input;
        String title = "Намиране на числа";
        input=JOptionPane.showInputDialog(null,"Въведете число между 0-2:", title, JOptionPane.QUESTION_MESSAGE);
        int num = Integer.parseInt(input); 
         
        switch(num) {
        case 0:
            System.out.println("Избрахте изход от програмата.");
            return;
        case 1: 
            PerfectNumbers pn = new PerfectNumbers();
            pn.printPerfectNumbers();
            break;
        case 2:
            PerfectNumbers sn = new PerfectNumbers();
            sn.sumOfNumbers();
            break;
        default: 
            System.out.println("Въведохте невалиднo числo.");
            break;
        }
        
    }

}
 