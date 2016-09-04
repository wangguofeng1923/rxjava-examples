package com.wangguofeng1923.examples.conditional;

import org.junit.Test;

import rx.Observable;

public class Contains {
@Test
public void contains(){
	Observable.range(1, 4).contains(5).subscribe(System.out::println);
	Observable.range(1, 4).contains(3).subscribe(System.out::println);
	
}
}
