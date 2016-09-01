package com.wangguofeng1923.examples.combining;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class Switch {
@Test
public void switchOnNext(){
	Observable<Observable<Long>>observable=Observable.create(new OnSubscribe<Observable<Long>>() {

		@Override
		public void call(final Subscriber<? super Observable<Long>> subscriber) {
			new Thread(()->{
				for(int i=0;i<5;i++){
					subscriber.onNext(Observable.interval(3, TimeUnit.SECONDS));
				}
				subscriber.onCompleted();
			}).start();
			
			
		}
	});
	Observable.switchOnNext(Observable.just(Observable.interval(3, TimeUnit.SECONDS),Observable.interval(5,5, TimeUnit.SECONDS)))
	.take(10).toBlocking().subscribe(System.out::println);
}
}
