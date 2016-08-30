package com.wangguofeng1923.examples.filtering;

import org.junit.Test;

import rx.Observable;
import rx.functions.Func1;

public class Last {
	@Test
	public void last(){
		Integer[]array=	new Integer[]{5,6,8,5,0,2,9};
		Observable<Integer> observable = Observable.from(array);
		observable.last().subscribe(System.out::println);
		observable.last(new Func1<Integer, Boolean>() {
			@Override
			public Boolean call(Integer v) {
				return v%2==0;
			}
		}).subscribe(System.out::println);
		
	}
	@Test
	public void firstOrDefault(){
		Integer[]array=	new Integer[]{5,6,8,5,0,2,9};
		Observable<Integer> observable = Observable.from(array);
		observable.lastOrDefault(-1).subscribe(System.out::println);
		observable.lastOrDefault(-1,new Func1<Integer, Boolean>() {
			@Override
			public Boolean call(Integer v) {
				return v>10;
			}
		}).subscribe(System.out::println);
		
	}
}
