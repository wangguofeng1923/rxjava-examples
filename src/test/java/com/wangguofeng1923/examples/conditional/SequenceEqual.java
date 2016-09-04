package com.wangguofeng1923.examples.conditional;

import org.junit.Test;

import rx.Observable;

public class SequenceEqual {
@Test
public void sequenceEqual(){
	Observable
	.sequenceEqual(Observable.range(1, 5), Observable.range(1, 5))
	.subscribe(System.out::println);
	
	Observable
	.sequenceEqual(Observable.range(1, 6), Observable.range(1, 5))
	.subscribe(System.out::println);

}
}
