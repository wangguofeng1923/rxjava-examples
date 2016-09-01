package com.wangguofeng1923.examples.combining;


import org.junit.Test;

import rx.Observable;
import rx.functions.Func1;

public class Concat {
	@Test
	public void concat(){
		Observable.concat(Observable.range(0, 3),Observable.just(10)).subscribe(System.out::println);
		
		System.out.println("======================");
		
		Observable.range(0, 3).concatMap(new Func1<Integer, Observable<String>>() {

			@Override
			public Observable<String> call(Integer v) {
				
				return Observable.just("Str:"+String.valueOf(v));
			}
		}).subscribe(System.out::println);
		System.out.println("======================");
		
	}
}
