package org.example.transactionevent;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {

    @Transactional
    public void registerItem(String name, int price){

    }
}
