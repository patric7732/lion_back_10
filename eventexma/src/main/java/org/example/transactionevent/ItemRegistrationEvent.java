package org.example.transactionevent;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ItemRegistrationEvent extends ApplicationEvent {
    private final String name;
    private final int price;
    public ItemRegistrationEvent(Object source,String name, int price) {
        super(source);
        this.name = name;
        this.price = price;
    }
}
