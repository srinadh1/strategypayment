package strategypayment;

import java.util.ArrayList;


public class Paypal implements PaymentInterface{
String email;
String password;
int amount;
ArrayList<Paypal> list=new ArrayList<Paypal>();
Paypal(){
	
}
Paypal(String email,String pwd,int amt){
	this.email=email;
	this.password=pwd;
	this.amount=amt;
}
public void processPayment() {
	list=paymentDAO.selectPaypal();
	
	for(int i=0;i<list.size();i++) {
		if((list.get(i).getEmail().equals(email))&&(list.get(i).getPassword().equals(password))) {
			if(list.get(i).getAmount()>amount) {
			System.out.println("The payment is successfully processed using paypal");
		}
			else {
				System.out.println("Either the given credentials are wrong or there is no sufficient balance in your account.");
			}
		}}

}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
}
