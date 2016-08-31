package com.wangguofeng1923.examples.transforming;

import org.junit.Test;

import rx.Observable;
import rx.functions.Func1;

public class Map {
	@Test
	public void map() {
		Observable.range(0, 10).map(new Func1<Integer, String>() {

			@Override
			public String call(Integer v) {
				return "str:" + v;
			}
		}).subscribe(System.out::println);

	}
}
