package strategypayment;

public class Rewards implements PaymentInterface{
String gcNum;int PIN;int amount;
Rewards(){
	
}
Rewards(String gc,int pin,int amt){
	this.gcNum=gc;
	this.PIN=pin;
	this.amount=amt;
}
public void processPayment() {
	System.out.println("The payment is processed with Rewards.");
}
}
