package com.wangguofeng1923.examples.transforming;

import java.util.Arrays;

import org.junit.Test;

import rx.Observable;
import rx.functions.Func1;

public class Flatmap {
	@Test
	public void flatmap(){
		Observable<String>observable=	Observable.range(0, 20).flatMap(new Func1<Integer, Observable<String>>() {

			@Override
			public Observable<String> call(Integer v) {
			
				return Observable.just("String:"+String.valueOf(v));
			}
		});
		observable.subscribe(System.out::println);
		
		observable.flatMapIterable(new Func1<String, Iterable<Integer>>() {

			@Override
			public Iterable<Integer> call(String str) {
				int index=str.indexOf(":");
				int v=Integer.valueOf(str.substring(index+1));
				return Arrays.asList(v);
			}
		}).subscribe(System.out::println);
		
	}
}
