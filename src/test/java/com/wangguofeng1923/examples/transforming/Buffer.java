package com.wangguofeng1923.examples.transforming;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class Buffer {
	@Test
	public void buffer(){
		Observable<Integer>observable=Observable.range(0, 10);
		observable.buffer(3).subscribe(System.out::println);
		
		observable.buffer(3, 1).subscribe(System.out::println);
		
		Observable.interval(2, TimeUnit.SECONDS).buffer(Observable.create(new OnSubscribe<Integer>() {

			@Override
			public void call(Subscriber<? super Integer> subscriber) {
				new Thread(()->{
					for(int i=0;i<5;i++){
						subscriber.onNext(i);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
					
					subscriber.onCompleted();
					
					
				}).start();

				
			}
		})).toBlocking().subscribe(System.out::println);;
		
	}
}
