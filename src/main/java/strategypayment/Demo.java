package strategypayment;

import java.util.Scanner;


public class Demo {

	public static void main(String[] args) {
		int sc;
		Scanner scr=new Scanner(System.in);
		System.out.println("Enter 1 to pay with credit card:");
		System.out.println("Enter 2 to pay with paypal:");
		System.out.println("Enter 3 to pay with rewards:");
		sc=scr.nextInt();
		
		switch(sc) {
		case 1:
			PaymentEngine engine=new PaymentEngine(new CreditCard(1234,"4321",1000));
			engine.processNecessaryPayment();
			break;
		case 2:
			PaymentEngine engine1=new PaymentEngine(new Paypal("srinadhreddy26@gmail.com","Srinadh1000",400));
			engine1.processNecessaryPayment();
			break;
		case 3:
			PaymentEngine engine2=new PaymentEngine(new Rewards("guess",9898,500));
			engine2.processNecessaryPayment();
			break;
		default:
			System.out.println("Please enter the correct value.");
	}
	}
	
}
