package org.example.completablefuture;

import org.example.completablefuture.service.AsyncService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@EnableAsync
public class CompletableApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompletableApplication.class,args);
    }

    @Bean
    public CommandLineRunner run(AsyncService asyncService){
        return args -> {
            System.out.println("async 메소드 호출");

            CompletableFuture<String> result1 = asyncService.asyncMethod1();
            CompletableFuture<String> result2 = asyncService.asyncMethod2();

            System.out.println("다른작업 수행");

            //비동기 메소드 결과를 조합

            CompletableFuture<Void> combinedFuture =   CompletableFuture.allOf(result1, result2)
                    .thenRun(() ->{

                        System.out.println("asyncMethod1 결과 "+   result1.join());
                        System.out.println("asyncMethod2 결과" + result2.join());

                    });

            //모든 작업이 완료 될때가지 기다림.
            combinedFuture.join();
        };
    }
}
