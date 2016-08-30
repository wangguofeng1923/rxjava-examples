package com.wangguofeng1923.examples.filtering;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;

public class Throttle {
	@Test
	public void throttleWithTimeout() {
		Observable<Long> observable = Observable.interval(2, TimeUnit.SECONDS);
		observable
		.take(10)
		.throttleWithTimeout(3, TimeUnit.SECONDS)
		.toBlocking()
		.subscribe(System.out::println);

	}
	@Test
	public void throttleFirst(){
		Observable<Long> observable = Observable.interval(2, TimeUnit.SECONDS);
		observable.take(10).throttleFirst(5, TimeUnit.SECONDS)
		
		.toBlocking()
		.subscribe(System.out::println);
	}
	@Test
	public void throttleLast(){
		Observable<Long> observable = Observable.interval(2, TimeUnit.SECONDS);
		observable.take(10).throttleLast(5, TimeUnit.SECONDS)
		
		.toBlocking()
		.subscribe(System.out::println);
	}
}
