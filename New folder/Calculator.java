
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.println("Enter no.of.operands:");
        int ab = scan.nextInt();


        System.out.println("Enter Type of operation 1,2,3,4 for add,sub,mul,div  :");
        int s = scan.nextInt();
            if (ab == 2) {
                System.out.print("Enter A:");
                double a = scan.nextInt();
                System.out.print("Enter B:");
                double b = scan.nextInt();
                if (s == 1) {
                    //add.addition(double a,double b);
                    double result = calclogic.addition(a, b);
                    System.out.println("Answer"+result);
                } else if (s == 2) {
                    double result = calclogic.subraction(a, b);
                    System.out.println("Answer"+result);
                } else if (s == 3) {
                    double result = calclogic.multiply(a, b);
                    System.out.println("Answer"+result);
                } else if (s == 4) {
                    double result = calclogic.divide(a, b);
                    System.out.println("Answer"+result);
                }

            } else if (ab == 3) {
                System.out.print("Enter A:");
                double a = scan.nextInt();
                System.out.print("Enter B:");
                double b = scan.nextInt();
                System.out.print("Enter C:");
                double c = scan.nextInt();
                if (s == 1) {
                    double result = calclogic.addition(a, b, c);
                    System.out.println("Answer"+result);


                } else if (s == 2) {
                    double result = calclogic.subraction(a, b, c);
                    System.out.println("Answer"+result);

                } else if (s == 3) {
                    double result = calclogic.multiply(a, b, c);
                    System.out.println("Answer"+result);
                } else if (s == 4) {
                    double result = calclogic.divide(a, b, c);
                    System.out.println("Answer"+result);
                }
            }


    }


}



