package com.wangguofeng1923.examples.creation;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;

public class RetryWhen {

	@Test
	public void retryWhen(){
//		Observable<Long>observable=Observable.defer(new Func0<Observable<Long>>() {
//
//			@Override
//			public Observable<Long> call() {
//				long v= (int)(Math.random()*10);
//				if(v>1){
//					throw new RuntimeException();
//				}
//				return Observable.just(v);
//			}
//		})
//		.retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
//
//			@Override
//			public Observable<?> call(Observable<? extends Throwable> errors) {
////				return Observable.just(null);
//				return errors.flatMap(new Func1<Throwable, Observable<?>>() {
//		              @Override public Observable<?> call(Throwable error) {
//
//		                // For IOExceptions, we  retry
//		                if (error instanceof RuntimeException) {
//		                  return Observable.just(null);
//		                }
//
//		                // For anything else, don't retry
//		                return Observable.error(error);
//		              }
//		            });
//			}
//
//			
//
//			
//		});
//		
//		return observable;
		Observable<Long> observable=Observable.create((Subscriber<? super Long> s) -> {
			 System.out.println("ss");
           s.onError(new RuntimeException("always fails"));
       })
		.retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {

			@Override
			public Observable<?> call(Observable<? extends Throwable> errors) {
				return errors.zipWith(Observable.range(1, 3), (n, i) -> i).flatMap(i -> {
	                System.out.println("delay retry by " + i + " second(s)");
	                return Observable.timer(i, TimeUnit.SECONDS);
	            });
			}

			

			
		});
		observable.subscribe(System.out::println);
		
	}
	
}
