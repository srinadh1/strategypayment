package strategypayment;

import java.util.ArrayList;

public class CreditCard implements PaymentInterface {
int cc;String password;int amount;int oldbalance;int ccc;
ArrayList<CreditCard> list=new ArrayList<CreditCard>();
CreditCard(){
	
}
	public CreditCard(int cc,String pwd,int amt){
		this.cc=cc;
		this.password=pwd;
		this.amount=amt;
}
	public void processPayment() {
		
		list=paymentDAO.selectCreditCard();
		for(int i=0;i<list.size();i++) {
			if((list.get(i).getCc()==cc)&&(list.get(i).getPassword().equals(password))) {
				if(list.get(i).getAmount()>amount) {
				System.out.println("The payment is successfully processed using credit card");
				oldbalance=list.get(i).getAmount();
				ccc=list.get(i).getCc();
				paymentDAO.updateCCbalance(amount,oldbalance,ccc);
			}
				else {
					System.out.println("Either the given credentials are wrong or there is no sufficient balance in your account.");
				}
		}
		}
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
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