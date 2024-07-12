package org.example.eventexam2;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
//3. 이벤트 등록
@Component
@RequiredArgsConstructor
public class CustomEventPublisher {

    //post-commnet 예제였다면 이 클래스가 CommentService 였을거예요^^
    private final ApplicationEventPublisher applicationEventPublisher;

    //댓글등록 하는 메서드겠죠?
    public void publisherEvent(final String message){
        System.out.println("댓글등록!!");
        // 댓글 등록 하는 일을 하고.


        System.out.println("publisherEvent Thread Name ::"+Thread.currentThread().getName());
        CustomEvent customEvent = new CustomEvent(this, message);
        applicationEventPublisher.publishEvent(customEvent);


        System.out.println("publisherEvent()-- 댓글입력 종료!!");
    }
}
