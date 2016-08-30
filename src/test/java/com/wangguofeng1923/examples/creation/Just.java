package com.wangguofeng1923.examples.creation;

import org.junit.Test;

import rx.Observable;

public class Just {
	@Test
	public   void just(){
		//build Observable object with one to 10 objects
		Observable<String>observable=Observable.just("0")
		.concatWith(Observable.just("0","1"))
		.concatWith(Observable.just("0","1","2"))
		.concatWith(Observable.just("0","1","2","3"))
		.concatWith(Observable.just("0","1","2","3","4"))
		.concatWith(Observable.just("0","1","2","3","4","5"))
		.concatWith(Observable.just("0","1","2","3","4","5","6"))
		.concatWith(Observable.just("0","1","2","3","4","5","6","7"))
		.concatWith(Observable.just("0","1","2","3","4","5","6","7","8"))
		.concatWith(Observable.just("0","1","2","3","4","5","6","7","8","9"));
		observable.subscribe(System.out::println);
	}
}
