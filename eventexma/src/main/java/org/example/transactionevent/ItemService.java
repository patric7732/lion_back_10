package org.example.transactionevent;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void registerItem(String name, int price){
        //아이템 저장
        Item item = new Item(name,price);
        itemRepository.save(item);
        //이벤트 등록!!
//        ItemRegistrationEvent itemRegistrationEvent = new ItemRegistrationEvent(this,name,price);
//        applicationEventPublisher.publishEvent(itemRegistrationEvent);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                ItemRegistrationEvent itemRegistrationEvent = new ItemRegistrationEvent(this,name,price);
                applicationEventPublisher.publishEvent(itemRegistrationEvent);
            }
        });

        if(1==1){
            throw new RuntimeException("강제예외발생!!");
        }
    }
}
