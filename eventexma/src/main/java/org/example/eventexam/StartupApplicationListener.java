package org.example.eventexam;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("애플리케이션 시작!!");
        //컨텍스트가 로딩될때 할일이 있다면,  이렇게 구현해 두면..   스프링부트가 알아서 실행시켜줌.
    }
}
