package utm.tmps;

public class Main {
    public static void main(String []args) {
        Payment payment = new PaymentProxy();
        try {
            payment.checkPayment(new Client(5,"Sandu","Chetroi",22));
            payment.checkPayment(new Client(1,"Maxim","Maximov",22));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
