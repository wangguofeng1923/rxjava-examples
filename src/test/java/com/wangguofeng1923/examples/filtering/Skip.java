package com.wangguofeng1923.examples.filtering;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;
import rx.functions.Func1;

public class Skip {
	@Test
	public void skip(){
		Integer[]array=	new Integer[]{5,6,8,5,0,2,9};
		Observable<Integer> observable = Observable.from(array);
		observable.skip(3).subscribe(System.out::println);
		
		Observable.interval(3, TimeUnit.SECONDS)
		.skip(5, TimeUnit.SECONDS)
		.take(3).toBlocking().subscribe(System.out::println);
//		observable.lastOrDefault(-1,new Func1<Integer, Boolean>() {
//			@Override
//			public Boolean call(Integer v) {
//				return v>10;
//			}
//		}).subscribe(System.out::println);
		
	}
	@Test
	public void skipLast(){
		
		Integer[]array=	new Integer[]{5,6,8,5,0,2,9};
		Observable<Integer> observable = Observable.from(array);
		observable.skipLast(2).subscribe(System.out::println);
		
		Observable.interval(3, TimeUnit.SECONDS).take(5)
		.skipLast(5, TimeUnit.SECONDS)
		.toBlocking().subscribe(System.out::println);

		
	}
	
	
}
