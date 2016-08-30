package com.wangguofeng1923.examples.creation;

import org.junit.Test;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Observable.OnSubscribe;
import rx.functions.Func1;
import rx.internal.schedulers.ImmediateScheduler;

public class RepeatWhen {
	@Test
	public void repeatWhen(){

		final Observable<Integer> observable=	Observable.range(1, 5);
		observable.repeatWhen(new Func1<Observable<? extends Void>, Observable<?>>() {  
            @Override  
            public Observable<?> call(Observable<? extends Void> observable2) { 

              	Observable<Integer> o= 	Observable.create(new OnSubscribe<Integer>() {

					@Override
					public void call(final Subscriber<? super Integer> observer) {
						new Thread(){
		            		@Override
		            		public void run(){
								try {
									while(true){
							            if (!observer.isUnsubscribed()) {
//							                for (int i = 1; i < 5; i++) {
							                	System.out.println("next:0");
							                    observer.onNext(0);
//							                }
							                //observer.onCompleted();
							            }
							            Thread.sleep(3000);
									}

						        } catch (Exception e) {
						           // observer.onError(e);
						        }
		            		}
		            	}.start();

					}
				});
            
              	return o;

            }  
        }).toBlocking().subscribe(new Observer<Integer>() {  
            @Override  
            public void onCompleted() {  
            	System.out.println("------------->onCompleted");  
            }  
    
            @Override  
            public void onError(Throwable e) {  
            	System.out.println("------------->onError:" + e);  
            }  
    
            @Override  
            public void onNext(Integer integer) {  
            	System.out.println("------------->onNext:" + integer);  
            }  
        });  

	}
}
