package com.wangguofeng1923.examples.combining;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;
import rx.functions.FuncN;

public class CombineLatest {
	@Test
	public void combineLatest(){
		
		Observable.combineLatest(Arrays.asList(Observable.interval(2, TimeUnit.SECONDS),Observable.interval(1, TimeUnit.SECONDS)), new FuncN<Long>() {

			@Override
			public Long call(Object... args) {

				Long v0=(Long)args[0];
				Long v1=(Long)args[1];
				System.out.println(v0+":"+v1);
				return v0+v1;
			}
		}).take(10).toBlocking().subscribe(System.out::println);
		
		
		
	}
}
