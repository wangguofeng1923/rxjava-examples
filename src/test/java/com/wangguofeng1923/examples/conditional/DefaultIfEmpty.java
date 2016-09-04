package com.wangguofeng1923.examples.conditional;

import org.junit.Test;

import rx.Observable;

public class DefaultIfEmpty {

	@Test
	public void defaultIfEmpty(){
		Observable.range(1, 4).defaultIfEmpty(-1).subscribe(System.out::println);
		Observable.empty().defaultIfEmpty(-1).subscribe(System.out::println);
	}
	}