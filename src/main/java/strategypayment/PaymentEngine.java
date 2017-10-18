package strategypayment;

public class PaymentEngine {

	PaymentInterface pif;
	PaymentEngine(PaymentInterface pif){
		this.pif=pif;
	}
	public void processNecessaryPayment() {
		pif.processPayment();
	}
}
