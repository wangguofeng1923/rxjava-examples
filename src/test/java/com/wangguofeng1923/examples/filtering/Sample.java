package com.wangguofeng1923.examples.filtering;



import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;

public class Sample {
	@Test
	public void sample(){
		Observable<Long>observable=Observable.interval(2, TimeUnit.SECONDS).take(10);
		observable.sample(5, TimeUnit.SECONDS).toBlocking().subscribe(System.out::println);
		
		
	}

}
