package com.wangguofeng1923.examples.creation;

import org.junit.Test;

import rx.Observable;
import rx.Scheduler;
import rx.internal.schedulers.ImmediateScheduler;

public class Range {
	@Test
	public void range() {
		Scheduler scheduler = ImmediateScheduler.INSTANCE;

		Observable<Integer> observable = Observable.range(4, 3)
				.concatWith(Observable.range(2, 4, scheduler));
		observable.subscribe(System.out::println);

	}

	
}
