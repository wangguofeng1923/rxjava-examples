package com.wangguofeng1923.examples.conditional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;

public class Amb {
@Test
public void amb(){
	
	 Observable<Integer> delay3 = Observable.just(1, 2, 3).delay(3000, TimeUnit.MILLISECONDS);
	    Observable<Integer> delay2 = Observable.just(4, 5, 6).delay(1000, TimeUnit.MILLISECONDS);
	    Observable<Integer> delay1 = Observable.just(7, 8, 9).delay(2000, TimeUnit.MILLISECONDS);
	    Observable.amb(delay1, delay2, delay3).toBlocking().subscribe(System.out::println);
	
}
}
