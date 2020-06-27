package com.company.domain;
import com.company.customTypes.Money;


public interface ObservableData {
    void attachObserver(Observer observer);
    void detachObserver(Observer observer);
    void updateTotal( Money total);
}
