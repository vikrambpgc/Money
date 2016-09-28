package ShortPrograms;

import java.util.Scanner;

public class CreditCards
{
        public static void main(String[] args)
        {
                // Declare Variables
                String name;
                String level;
                double currentBalance = 0.0;
                boolean isLate = false;
                String isLateInput; //Take Yes/No into this.
                
                final String PLATINUM_LEVEL = "Platinum";
                final double PLATINUM_INTEREST_RATE = 2;
                final double PLATINUM_LATE_FEE = 0;
                
                final String GOLD_LEVEL = "Gold";
                final double GOLD_INTEREST_RATE = 2.5;
                final double GOLD_LATE_FEE = 0;
                
                final String SILVER_LEVEL = "Silver";
                final double SILVER_INTEREST_RATE = 3;
                final double SILVER_LATE_FEE = 25;
                
                final double MIN_PAYMENT_PERCENT_ON_PRINCIPLE = 3; // Percentage on Principle for minimum payment
                double paymentInterestRate = 0.0; // The customer is finally going to pay this much interest rate
                double paymentLateFee = 0.0; //   The customer is finally going to pay this much late fee
                double totalPayment = 0.0;
                double paymentToPrinciple = 0.0;
                double paymentToInterest = 0.0;
                double percentToPrinciple = 0.0;
                double percentToInterest = 0.0;
               
                // Print name
                System.out.println("Program 3: Credit Cards by Mitchell Rolfes\n");
               
                // Allows to read in from user input
                Scanner keyboard = new Scanner(System.in);
               
                // Prompt user for customer name
                System.out.print("Please enter a customer name: ");
                name = keyboard.nextLine();
               
                // Prompt the user for customer level
                System.out.print("Please enter the customer's member level: ");
                level = keyboard.nextLine();
               
                // Prompt the user for the balance
                System.out.print("Please enter the current balance: ");
                currentBalance = keyboard.nextDouble();
                keyboard.nextLine(); //Need to do this so that scanner moves to next line.
               
                // Prompt the user if the payment was late or not
                System.out.print("Was the payment made late?: ");
                isLateInput = keyboard.nextLine();
                keyboard.close();
                System.out.println();
                
                // Decide if the Payment is Late or not.
                if( isLateInput.equalsIgnoreCase("Yes"))
                {
                        isLate = true;
                }
                else if (isLateInput.equalsIgnoreCase("No"))
                {
                	    isLate = false;
               
                }
                else 
                {
            		System.out.println("Error in entering Late Information input. Please give Yes/No");
                    System.out.println("Programming is terminating...");
                    System.exit(0);
                }
               
               
               
                // Calculate the results
                if(level.equals(PLATINUM_LEVEL))
                {
                       if (false == isLate)
                       {
                    	   paymentInterestRate = PLATINUM_INTEREST_RATE;
                    	   
                    	   paymentToPrinciple = (MIN_PAYMENT_PERCENT_ON_PRINCIPLE * currentBalance) / 100;
                    	   paymentToInterest = (paymentInterestRate * currentBalance) / 100;
                    	   totalPayment = paymentToPrinciple + paymentToInterest;
                    	   percentToPrinciple = (100 * paymentToPrinciple) / totalPayment;
                    	   percentToInterest = 100 - percentToPrinciple;
                       }
                       else 
                       {
                    	   //Late Case. Customer has to pay lower level interest.
                    	   paymentInterestRate = GOLD_INTEREST_RATE;
                    	   paymentLateFee = PLATINUM_LATE_FEE;
                    	   
                    	   paymentToPrinciple = (MIN_PAYMENT_PERCENT_ON_PRINCIPLE * currentBalance) / 100;
                    	   paymentToInterest = (paymentInterestRate * currentBalance) / 100;
                    	   totalPayment = paymentToPrinciple + paymentToInterest + paymentLateFee;
                    	   percentToPrinciple = (100 * paymentToPrinciple) / totalPayment;
                    	   percentToInterest = 100 - percentToPrinciple;
                       }
                }
                else if(level.equals(GOLD_LEVEL))
                {
                	//Late Case. Customer has to pay lower level interest.
                    if (false == isLate)
                    {
                 	   paymentInterestRate = GOLD_INTEREST_RATE;
                	   
                 	   paymentToPrinciple = (MIN_PAYMENT_PERCENT_ON_PRINCIPLE * currentBalance) / 100;
                 	   paymentToInterest = (paymentInterestRate * currentBalance) / 100;
                 	   totalPayment = paymentToPrinciple + paymentToInterest;
                 	   percentToPrinciple = (100 * paymentToPrinciple) / totalPayment;
                 	   percentToInterest = 100 - percentToPrinciple;
                    }
                    else 
                    {
                       //Late Case.
                 	   paymentInterestRate = SILVER_INTEREST_RATE;
                 	   paymentLateFee = GOLD_LATE_FEE;
                 	   
                 	   paymentToPrinciple = (MIN_PAYMENT_PERCENT_ON_PRINCIPLE * currentBalance) / 100;
                 	   paymentToInterest = (paymentInterestRate * currentBalance) / 100;
                 	   //Final minimum payment = minimum payment on principle + interest + Late fee.
                 	   totalPayment = paymentToPrinciple + paymentToInterest + paymentLateFee;
                 	   percentToPrinciple = (100 * paymentToPrinciple) / totalPayment;
                 	   percentToInterest = 100 - percentToPrinciple;
                    }
                }
                else if(level.equals(SILVER_LEVEL))
                {
                    if (false == isLate)
                    {
                 	   paymentInterestRate = SILVER_INTEREST_RATE;
                	   
                 	   paymentToPrinciple = (MIN_PAYMENT_PERCENT_ON_PRINCIPLE * currentBalance) / 100;
                 	   paymentToInterest = (paymentInterestRate * currentBalance) / 100;
                 	   totalPayment = paymentToPrinciple + paymentToInterest;
                 	   percentToPrinciple = (100 * paymentToPrinciple) / totalPayment;
                 	   percentToInterest = 100 - percentToPrinciple;
                    }
                    else 
                    {
                 	   paymentInterestRate = SILVER_INTEREST_RATE;
                 	   paymentLateFee = SILVER_LATE_FEE;
                 	   
                 	   paymentToPrinciple = (MIN_PAYMENT_PERCENT_ON_PRINCIPLE * currentBalance) / 100;
                 	   paymentToInterest = (paymentInterestRate * currentBalance) / 100;
                 	   //Final minimum payment = minimum payment on principle + interest + Late fee.
                 	   totalPayment = paymentToPrinciple + paymentToInterest + paymentLateFee;
                 	   percentToPrinciple = (100 * paymentToPrinciple) / totalPayment;
                 	   percentToInterest = 100 - percentToPrinciple;
                    }
                }
                else
                {
                		System.out.println("Error in Level input");
                        System.out.println("Programming is terminating...");
                        System.exit(0);
                }
               
                // Final total
                System.out.println("Billing information for " + name);
                System.out.println("Customer Level: " + level);
                System.out.printf("Credit Card Balance: $%.2f \n", currentBalance);
                
                if (false == isLate)
                {
                	//An '%' character can be printed using %%
                	System.out.printf("Interest rate: %.1f%% per month\n", paymentInterestRate);
                }
                else
                {
                	System.out.printf("Interest rate for late payment: %.1f%% per month\n", paymentInterestRate);
                	System.out.printf("Late fee: $%.2f \n", paymentLateFee);
                }
                
                //An '%' character can be printed using %%.
                System.out.printf("Required minimum payment: $%.2f \n", totalPayment);
                System.out.printf("Amount going to Principle: $%.2f \n", paymentToPrinciple);
                System.out.printf("Percent to principle: %.1f%% \n", percentToPrinciple);
                System.out.printf("Percent to interest: %.1f%% \n", percentToInterest);
               
        } // End of main
} // End of CreditCards
