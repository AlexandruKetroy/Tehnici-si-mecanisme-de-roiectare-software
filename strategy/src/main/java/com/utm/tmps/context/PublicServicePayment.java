package com.utm.tmps.context;

import com.utm.tmps.strategy.PaymentStrategy;

public class PublicServicePayment {
    private int totalCost = 0;
    private boolean isClosed = false;

    public void processPayment(PaymentStrategy strategy) {
        strategy.collectPaymentDetails();
    }

    public void setTotalInvoiceAmount(int invoiceSum) {
        this.totalCost += invoiceSum;
    }

    public int getTotalInvoiceAmount() {
        return totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
}
