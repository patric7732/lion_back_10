package org.example.asyncfuture;

import org.example.asyncfuture.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Future;

@SpringBootApplication
@EnableAsync
public class AsyncApplication implements CommandLineRunner {
    public static void main(String[] args)  {
        SpringApplication.run(AsyncApplication.class,args);
    }

    @Autowired
    private AsyncService asyncService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("async 메소드 호출");

        Future<String> result1 = asyncService.asyncMethod1();
        Future<String> result2 = asyncService.asyncMethod2();

        //비동기 메서드를 호출 한 후에 다른 작업 수행.
        System.out.println("다른 작업 수행!! ");

        //비동기 메서드 결과 기다림
        System.out.println("asyncMethod1 결과"+result1.get());
        System.out.println("asyncMethod2 결과"+result2.get());
    }
}
