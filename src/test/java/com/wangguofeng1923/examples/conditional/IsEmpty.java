package com.wangguofeng1923.examples.conditional;

import org.junit.Test;

import rx.Observable;

public class IsEmpty {
@Test
public void isEmpty(){
	Observable.range(1, 4).isEmpty().subscribe(System.out::println);
	Observable.empty().isEmpty().subscribe(System.out::println);
}
}
