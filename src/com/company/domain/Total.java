package com.company.domain;

import com.company.customTypes.Money;

public class Total implements Observer {

    private ObservableData observableData;
    private Money finalTotal = new Money();

    public Total(){
    }

    public void setObservableData(ObservableData observerData) {
        this.observableData = observerData;
    }

    @Override
    public void notify(Money total) {
        finalTotal = finalTotal.add(total);
        printTotal(finalTotal);
    }

    public void printTotal(Money total){
        System.out.println("\n Total Amount: " + "\"" + total.toString() + "\"" );
    }

    public void removeObserver(){
        observableData.detachObserver(this);
    }
}
