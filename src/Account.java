import java.util.Calendar;
import java.util.Scanner;

public class Account {

    private double bmi;
    private String customerName;
    private String customerPassword;
    private double weight;
    // Scanner in = new Scanner(System.in);


public double getBmi() {
        return bmi;
    }

public String getCustomerName() {
    return customerName;
}

public String getCustomerPassword() {
    return customerPassword;
}

public Account(double bmi, String customerName, String customerPassword) {
    this.bmi = bmi;
    this.customerName = customerName;
    this.customerPassword = customerPassword;
}

void BMIcalculator(){
    double height = 0.0;
    double heightM = 0.0;		
    double weight = 0.0;		
    double bmi = 0.0;
    Scanner scan = new Scanner(System.in);

    while(true) {
        // Scanner scan = new Scanner(System.in);
        try {
    // put the height
    System.out.print("Please enter your height (cm) >");
    height = scan.nextDouble();
    // this.height = height;
    
    // put the weight 
    System.out.print("Please enter your weight (kg) >");
    weight = scan.nextDouble();
    this.weight = weight;

    // Input value check
    if(height <= 0.0 || weight <= 0.0) {
        System.out.println("***Re-enter the number more than 0***");
        System.out.println();
        continue;
    }

    // Screen output of weight and height
    System.out.println( "\nYour height is " + height + "cm and your weight is " + weight + "kg");

    // conversion　cm --> m
    heightM = height * 0.01;

    // BMI
    bmi = weight / (heightM * heightM);
    this.bmi = bmi;

    // Screen output of　BMI
    System.out.println( "\nYour BMI is " + String.format("%.2f", bmi) + ".");

    // output of　message
    if(bmi >= 25.0) {
        // BMI > 25.0
        System.out.println("You are overweight...");
    } else if(bmi < 18.5) {
        // BMI < 18.5
        System.out.println("You are underweight...");
    } else {
        System.out.println("You have optimal weight.");
    }

    
    // exit message
    System.out.println();
    System.out.println( "Exit");
    
    break;
    


    } catch (Exception e) {
        System.out.println("Invalid option. Please try again");
        break;
    
}
// scan.close();
}
// scan.close();
}

void Reset(){
    System.out.println("Are you sure you want to reset today's data? Type [yes/no]");
    Scanner scan = new Scanner(System.in);
    String answer = scan.next();
    if (answer.equals("yes")) {
    System.out.println("Today's data is reset successfully.\n");
    System.out.println( "Exit");
    
    setWeight(0);
    setBmi(0);

} else if (answer.equals("no\n")) {
    System.out.println( "Exit");
}else{
    System.out.println("Invalid typing. Please try again\n");
    System.out.println( "Exit");
}
// scan.close();
}




void showMenu(){
    char option;
    try (Scanner input = new Scanner(System.in)) {

        do{

            System.out.println(
                "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=\n"+
                "Select an option from the menu\n"+
                "A: Register\n"+
                "B: Reference\n"+
                "C: Reset\n"+
                "D: Quit\n"+
                "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
            );
            option = input.next().charAt(0); // [a]sdasdads sgasgagsasf

            	
                // Scanner scan = new Scanner(System.in);

                Calendar cl = Calendar.getInstance();
                int month = cl.get(Calendar.MONTH) + 1;
                String today = cl.get(Calendar.YEAR) + " / " + month + " / " + cl.get(Calendar.DATE);
                

                

            switch (Character.toLowerCase(option)) {

                case 'a':
                System.out.println("-------------------------------");
                System.out.println("Register today's data");
                System.out.println("-------------------------------");
                System.out.println(today);
                BMIcalculator();
                    break;

                case 'b':
                System.out.println("-------------------------------");
                System.out.println("Reference");
                System.out.println("-------------------------------");

                System.out.println(today);
                System.out.println("Weight:"+ this.weight + "kg");
                System.out.println("BMI:"+ String.format("%.2f", this.bmi)); 
                System.out.println();
                System.out.println( "Exit");
                    break;

                case 'c':
                Reset();
                    break;

                case 'd':            
                    break;

                default:
                System.out.println("Invalid option. Please try again");
                    break;
            }

        }while(Character.toLowerCase(option) != 'd');

        System.out.println("Thank you! Keep your health. See you again....");
        System.exit(0);


    }
    
}



public void setBmi(double bmi) {
    this.bmi = bmi;
}
public void setWeight(double weight) {
    this.weight = weight;
}


}



