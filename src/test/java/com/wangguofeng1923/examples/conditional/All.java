package com.wangguofeng1923.examples.conditional;

import org.junit.Test;

import rx.Observable;

public class All {
	@Test
	public void all(){
		Observable.range(1,5).all(x->{return x<6;}).subscribe(System.out::println);
		Observable.range(1, 6).all(x->{return x<6;}).subscribe(System.out::println);
	}

}
