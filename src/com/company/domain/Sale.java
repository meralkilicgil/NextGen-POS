package com.company.domain;

import com.company.customTypes.CurrencyException;
import com.company.customTypes.Money;

import java.util.*;

public class Sale implements Observer{
    private List<SalesLineItem> lineItems = new ArrayList<>();
    private Date date = new Date();
    private boolean isComplete = false;
    private Payment payment;
    private final Tax tax = new Tax();

    private ObservableData observableData;
    public void setObservableData(ObservableData observerData) {
        this.observableData = observerData;
    }

    @Override
    public void notify(Money total) {
        System.out.println(" subtotal.toString()");
    }

    public void removeObserver(){
        observableData.detachObserver(this);
    }

    public Money getBalance() {
        return payment.getAmount().minus(getTotal());
    }

    public void becomeComplete() {
        isComplete = true;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public String makeLineItem(ProductDescription desc, int quantity) throws CurrencyException {
        SalesLineItem sl = new SalesLineItem(desc, quantity);
        String slString=sl.toString();
        if(lineItems.size() == 0){
            observableData.manageableDataChanged(sl.getSubTotal());
        }
        if (lineItems.size() > 0) { //check if there is any product in the list
            Currency firstItemCurrency =  lineItems.get(0).getSubTotal().getCurrency();
            if (firstItemCurrency == desc.getPrice().getCurrency()) {//check to see if currencies are the same
                observableData.manageableDataChanged(sl.getSubTotal());
                lineItems.add(sl);
            } else {
                throw new CurrencyException();
            }
        } else {
            lineItems.add(sl);
        }
        return slString;
    }

    public Money getTotal() {
        Money total = new Money();
        Money subTotal = null;

        for (SalesLineItem lineItem : lineItems) {
            subTotal = lineItem.getSubTotal();
            total = total.add(subTotal);
        }

        //Tax calculation
        tax.setTaxAmount(total);
        total = total.add(tax.getTaxAmount());

        return total;
    }

    public void makePayment(Money cashTendered) {
        payment = new Payment(cashTendered);
    }


    @Override
    public String toString() {
        Money totalWithoutTax = new Money();
        Money subTotal = null;
        String s = "Date: " + date.toString() + "\n";
        Iterator i = lineItems.iterator();
        while (i.hasNext()) {
            SalesLineItem sli = (SalesLineItem) i.next();
            s += sli.toString();
            subTotal = sli.getSubTotal();
            totalWithoutTax = totalWithoutTax.add(subTotal);
        }
        s += "\n";
        s += "Total (without tax): " + totalWithoutTax + "\n";
        s += "Total: " + getTotal() + "\n";
        s += "(Tax Amount:" + tax.getTaxAmount()+ ")\n";

        if(payment!=null){
            s += "Payment: " + payment.toString() + "\n";
            s += "Balance: " + getBalance() + "\n";
        }
        s += "--------------------------------------\n";
        return s;
    }

}
