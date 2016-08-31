package com.wangguofeng1923.examples.transforming;

import org.junit.Test;

import rx.Observable;
import rx.functions.Func2;

public class Scan {
	@Test
	public void scan(){
		Observable.range(1, 10).scan(0, new Func2<Integer, Integer, Integer>() {

			@Override
			public Integer call(Integer v1, Integer v2) {
				return v1+v2;
			}
		}).subscribe(System.out::println);
		
		
	}

}
