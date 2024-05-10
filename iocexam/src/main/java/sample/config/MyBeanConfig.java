package sample.config;

import org.springframework.context.annotation.Bean;
import sample.bean.MyBean;

public class MyBeanConfig {
//    <bean id="myBean" class="sample.bean.MyBean"/>
    @Bean
    public MyBean myBean(){
        return new MyBean();
    }

    @Bean
    public MyBean myBean2(){
        return new MyBean();
    }
}
