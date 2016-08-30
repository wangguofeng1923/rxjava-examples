package com.wangguofeng1923.examples.creation;


import org.junit.Test;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class Create {
	@Test
	public void create() {
			Observable<Integer>observable=Observable.create(new OnSubscribe<Integer>() {

				@Override
				public void call(Subscriber<? super Integer> subscriber) {
					if(!subscriber.isUnsubscribed()){
						for(int i=0;i<10;i++){
							subscriber.onNext(i);
						}
						subscriber.onCompleted();
					}else{
						subscriber.onError(new Throwable());
					}
					
				}
			});
			observable.subscribe(System.out::println);
	}
	
}
