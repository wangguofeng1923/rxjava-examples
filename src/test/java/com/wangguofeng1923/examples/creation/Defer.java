package com.wangguofeng1923.examples.creation;

import org.junit.Test;

import rx.Observable;

public class Defer {
	@Test
	public void defer() {
		Observable<Long>deferObservable=Observable.defer(()-> {
				return Observable.just(System.currentTimeMillis());
		});
		Observable<Long>justObservable=Observable.just(System.currentTimeMillis());
		deferObservable.subscribe(System.out::println);
		deferObservable.subscribe(System.out::println);
		System.out.println("========================");
		justObservable.subscribe(System.out::println);
		justObservable.subscribe(System.out::println);
		
		
		
	}
}
