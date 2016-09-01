package com.wangguofeng1923.examples.combining;

import java.util.Arrays;

import org.junit.Test;

import rx.Observable;

public class StartWith {
@Test
public void startWith(){
	Observable.range(0, 3).startWith(100).subscribe(System.out::println);
	System.out.println("======================");
	Observable.range(0, 3).startWith(Observable.range(10, 3)).subscribe(System.out::println);
	System.out.println("======================");
	Observable.range(0, 3).startWith(Arrays.asList(10,20)) .subscribe(System.out::println);
}
}
