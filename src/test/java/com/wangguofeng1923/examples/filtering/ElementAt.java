package com.wangguofeng1923.examples.filtering;

import org.junit.Test;

import rx.Observable;

public class ElementAt {
@Test
public void elementAt(){
	Integer[]array=	new Integer[]{5,2,8,5,0,2,9};
	Observable<Integer> observable = Observable.from(array);
	observable.elementAt(4).subscribe(System.out::println);
	observable.elementAtOrDefault(7,-1).subscribe(System.out::println);
}

@Test
public void elementAtOrDefault(){
	Integer[]array=	new Integer[]{5,2,8,5,0,2,9};
	Observable<Integer> observable = Observable.from(array);
	observable.elementAtOrDefault(7,-1).subscribe(System.out::println);
}
}
