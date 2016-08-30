package com.wangguofeng1923.examples.filtering;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;

public class Distinct {
	@Test
	public void distinct(){
		Integer[]array=	new Integer[]{1,1,2,2,3,3,2,2,3,3,3,4,4,4,1,1,2,3};
		Observable<Integer> observable = Observable.from(array);
		observable.distinct().subscribe(System.out::println);
//		observable.distinct(keySelector)//自定义key
		
	}
	@Test
	public void distinctUntilChanged(){
		Integer[]array=	new Integer[]{1,1,2,2,3,3,2,2,3,3,3,4,4,4,1,1,2,3};
		Observable<Integer> observable = Observable.from(array);
		
		observable.distinctUntilChanged().subscribe(System.out::println);
	}
}
