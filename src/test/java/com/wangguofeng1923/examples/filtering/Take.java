package com.wangguofeng1923.examples.filtering;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;

public class Take {
	@Test
	public void take_count(){
		
		Observable<Integer> observable = Observable.range(0, 10);
		observable.take(10).subscribe(System.out::println);
	
	}

		@Test
		public void take_time(){
			
			Observable<Long> observable = Observable.interval(2, TimeUnit.SECONDS);
			observable.take(5, TimeUnit.SECONDS).toBlocking().subscribe(System.out::println);
		
		}
		@Test
		public void take_buffer(){
			
			Observable<Integer> observable = Observable.range(0, 10);
			observable.takeLastBuffer(3).subscribe(System.out::println);
		
		}

}
