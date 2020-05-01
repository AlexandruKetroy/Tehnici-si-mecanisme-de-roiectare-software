package com.utm.tmps.client;

import com.utm.tmps.concretestrategy.CardPayment;
import com.utm.tmps.concretestrategy.MPAYPayment;
import com.utm.tmps.context.PublicServicePayment;
import com.utm.tmps.strategy.PaymentStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private static Map<Integer, Integer> amountOnPublicServices = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static PublicServicePayment publicServicePayment = new PublicServicePayment();
    private static PaymentStrategy strategy;

    static {
        amountOnPublicServices.put(1, 2200);
        amountOnPublicServices.put(2, 1850);
        amountOnPublicServices.put(3, 1100);
        amountOnPublicServices.put(4, 890);
    }

    public static void main(String[] args) throws IOException {
        while (!publicServicePayment.isClosed()) {
            int amount;

            String continueChoice;
            do {
                System.out.print("Please, select a product:" + "\n" +
                        "1 - Donations in state budget for combating COVID-19" + "\n" +
                        "2 - Consular Services" + "\n" +
                        "3 - ANTA" + "\n" +
                        "4 - Financial Services" + "\n");
                int choice = Integer.parseInt(reader.readLine());
                amount = amountOnPublicServices.get(choice);
                publicServicePayment.setTotalInvoiceAmount(amount);
                System.out.print("Do you wish to continue selecting services? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                        "1 - MPAY" + "\n" +
                        "2 - Credit Card");
                String paymentMethod = reader.readLine();


                if (paymentMethod.equals("1")) {
                    strategy = new MPAYPayment();
                } else {
                    strategy = new CardPayment();
                }

                publicServicePayment.processPayment(strategy);

                System.out.print("Pay " + publicServicePayment.getTotalInvoiceAmount() + " units or choose and another service? P/C: ");
                String proceed = reader.readLine();
                if (proceed.equalsIgnoreCase("P")) {
                    if (strategy.pay(publicServicePayment.getTotalInvoiceAmount())) {
                        System.out.println("Payment has been successful.");
                    } else {
                        System.out.println("FAIL! Please, check your data.");
                    }
                    publicServicePayment.setClosed();
                }
            }
        }
    }
}
