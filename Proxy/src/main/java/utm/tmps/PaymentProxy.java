package utm.tmps;

import java.util.ArrayList;
import java.util.List;

public class PaymentProxy implements Payment{
    private Payment payment = new PaymentService();
    private static List<Client> vipClients;
    static {
        vipClients = new ArrayList<Client>();
        vipClients.add(new Client(1,"Maxim","Maximov",22));
        vipClients.add(new Client(2,"Oleg","Olegov",23));
        vipClients.add(new Client(3,"Andrei","Andreev",31));
        vipClients.add(new Client(4,"Ivan","Ivanov",23));
    }

    public void checkPayment(Client client) throws Exception {
        if(vipClients.contains(client))
            System.out.println("Successful payment");
        payment.checkPayment(client);
    }
}
