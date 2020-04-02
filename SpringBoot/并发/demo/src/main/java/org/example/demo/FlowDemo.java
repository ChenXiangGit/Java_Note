package org.example.demo;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @ClassName: FlowDemo
 * @Description:
 * @Author: Chen
 * @Date: 2020/4/2 17:34
 * @Version: 1.0
 */

//Java 9
public class FlowDemo {

    public static void main(String[] args) throws InterruptedException {

        try(SubmissionPublisher publisher = new SubmissionPublisher<String>()){


            publisher.subscribe(new Flow.Subscriber<String>() {
                private Flow.Subscription subscription;
                @Override
                public void onSubscribe(Flow.Subscription subscription) {
                    this.subscription = subscription;
                    echo("onSubscribe:");
                    this.subscription.request(Long.MAX_VALUE);
                }

                @Override
                public void onNext(String item) {
                    if ("out".equals(item)){
//                        subscription.cancel();
//                        return;
                    }else if ("ex".equalsIgnoreCase(item)){
                        throw new RuntimeException("an exception");
                    }
                    echo("onNext:"+item);
                }

                @Override
                public void onError(Throwable throwable) {
                    echo("onSubscribe:"+throwable);
                }

                @Override
                public void onComplete() {
                    echo("onComplete:");
                }
            });

            publisher.submit("Hello world");
            publisher.submit("2019");
            publisher.submit("ex");
            publisher.submit("out");
            publisher.submit("see you!");
        }
        Thread.sleep(1000);
    }

    private static void echo(Object Object){
        System.out.printf("[线程：%s] - %s \n",Thread.currentThread().getName(),Object);
    }


}