package com.company.domain;
import java.util.ArrayList;
import java.util.List;
import com.company.customTypes.Money;

public class NotifcationPool implements ObservableData {
    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void attachObserver(Observer observer){
        observerList.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void manageableDataChanged( Money total) {
        for( Observer observer : observerList){
            observer.notify(total);
        }
    }
}
