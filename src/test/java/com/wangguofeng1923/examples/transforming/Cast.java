package com.wangguofeng1923.examples.transforming;

import org.junit.Test;

import rx.Observable;

public class Cast {
@Test
public void cast(){
	Observable<Integer>observable=Observable.range(0, 10);
	observable.cast(Number.class)
	.subscribe(System.out::println);
	
	
}
}
