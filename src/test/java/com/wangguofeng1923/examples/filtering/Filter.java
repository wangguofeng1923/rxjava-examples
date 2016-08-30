package com.wangguofeng1923.examples.filtering;

import org.junit.Test;

import rx.Observable;
import rx.functions.Func1;

public class Filter {
	@Test
	public void filter(){
		Integer[]array=	new Integer[]{5,2,8,5,0,2,9};
		Observable<Integer> observable = Observable.from(array);
		observable.filter(new Func1<Integer, Boolean>() {
			@Override
			public Boolean call(Integer v) {
				return v%2==0;
			}
		}).subscribe(System.out::println);
		
	}
}
