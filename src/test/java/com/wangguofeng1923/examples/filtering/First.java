package com.wangguofeng1923.examples.filtering;

import org.junit.Test;

import rx.Observable;
import rx.functions.Func1;

public class First {
	@Test
	public void first(){
		Integer[]array=	new Integer[]{5,2,8,5,0,2,9};
		Observable<Integer> observable = Observable.from(array);
		observable.first().subscribe(System.out::println);
		observable.first(new Func1<Integer, Boolean>() {
			@Override
			public Boolean call(Integer v) {
				return v%2==0;
			}
		}).subscribe(System.out::println);
		
	}
	@Test
	public void firstOrDefault(){
		Integer[]array=	new Integer[]{5,2,8,5,0,2,9};
		Observable<Integer> observable = Observable.from(array);
		observable.firstOrDefault(-1).subscribe(System.out::println);
		observable.firstOrDefault(-1,new Func1<Integer, Boolean>() {
			@Override
			public Boolean call(Integer v) {
				return v>10;
			}
		}).subscribe(System.out::println);
		
	}
}
