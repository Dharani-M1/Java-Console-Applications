
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter no.of.operands:");
        int ab = scan.nextInt();
        System.out.println("Enter Type of operation 1,2,3,4 for add,sub,mul,div  :");
        int s = scan.nextInt();


if( s==1 || s==2 || s==3 || s=4 ) {

    if (ab == 2) {
        System.out.print("Enter A:");
        double a = scan.nextInt();
        System.out.print("Enter B:");
        double b = scan.nextInt();
    } else - if (ab == 3) {
        System.out.print("Enter A:");
        double a = scan.nextInt();
        System.out.print("Enter B:");
        double b = scan.nextInt();
        System.out.print("Enter C:");
        double c = scan.nextInt();
    }
    else if (s == 5) {
        System.out.print("Enter A:");
        double a = scan.nextInt();
        System.out.print("Enter B:");
        double b = scan.nextInt();
    }
}

        switch (s) {
            case 1:
                if (ab == 2) {
                    double result = calclogic.addition(a, b);
                    System.out.println("Answer" + result);

                } else if (ab == 3) {

                    double result = calclogic.addition(a, b, c);
                    System.out.println("Answer" + result);

                }
            case 2:
                if (ab == 2) {
                    double result = calclogic.subraction(a, b);
                    System.out.println("Answer" + result);

                } else if (ab == 3) {
                    double result = calclogic.subraction(a, b, c);
                    System.out.println("Answer" + result);
                }

            case 3:
                if (ab == 2) {
                    double result = calclogic.multiply(a, b);
                    System.out.println("Answer" + result);

                } else if (ab == 3) {
                    double result = calclogic.multiply(a, b, c);
                    System.out.println("Answer" + result);

                }
            case 4:
                if (ab == 2) {
                    double result = calclogic.divide(a, b);
                    System.out.println("Answer" + result);

                } else if (ab == 3) {
                    double result = calclogic.divide(a, b, c);
                    System.out.println("Answer" + result);

                }

            case 5:
                if (ab == 2) {
                    double result = calclogic.power(a, b);
                    System.out.println("Answer" + result);

                }
        }
    }
}





















