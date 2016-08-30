package com.wangguofeng1923.examples.filtering;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.functions.Func1;
import rx.Subscriber;


public class Debounce {
	/**
	 * 每间隔timeout(3秒)收集一次数据，如果在这个间隔时间内，]
	 * 没有从observable 发射(emit)新的数据，则这个已经被收集的数据会被订阅者收到
	 * */
	
	@Test
	public void debounce_timeout_2(){
		Observable.create(new OnSubscribe<Long>() {
			final Random random=new Random();
 
			@Override
			public void call(Subscriber<? super Long> subscriber) {
				
				new Thread(()->{
					for(int i=0;i<20;i++){
						long randomInt=random.nextInt(3)+2;
						long sleepTime=randomInt*1000;

			
						subscriber.onNext((long)i);
						System.out.println("sleep time:"+randomInt+",emmit value:"+i);
						try {
							
							Thread.sleep(sleepTime);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						
					}
					subscriber.onCompleted();
				}).start();
				
			}
		})
		.take(20)
		.debounce(3, TimeUnit.SECONDS).toBlocking()
		.subscribe(System.out::println);
		
	}
	@Test
	public void debounce_func(){
		Observable.range(0, 10)
		.debounce(new Func1<Integer, Observable<Integer>>() {

			@Override
			public Observable<Integer> call(Integer v) {
				return Observable.create(new OnSubscribe<Integer>() {

					@Override
					public void call(Subscriber<? super Integer> subscriber) {
						if(v%2==0){
							subscriber.onNext(v);
							subscriber.onCompleted();
						}
						
					}
				});
			}
		})
		.toBlocking()
		.subscribe(System.out::println);
		
		
	}
	
}
