package utm.tmps;


public class PaymentService implements Payment {

    public void checkPayment(Client client) {
        System.out.println("Select client from clients where id=" + client.getId());
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        System.out.println("Client " + client.getId() + " is verified");
    }
}
