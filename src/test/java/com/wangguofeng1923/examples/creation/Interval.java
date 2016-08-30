package com.wangguofeng1923.examples.creation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;
import rx.internal.schedulers.ImmediateScheduler;

public class Interval {
	@Test
	public void interval(){
		Observable<Long>observable=Observable.interval(3, TimeUnit.SECONDS).take(3)
				.concatWith(Observable.interval(5, 3, TimeUnit.SECONDS).take(3))
				.concatWith(Observable.interval(3, TimeUnit.SECONDS, ImmediateScheduler.INSTANCE).take(3))
				.concatWith(Observable.interval(5, 3, TimeUnit.SECONDS, ImmediateScheduler.INSTANCE).take(3));
		observable.toBlocking().subscribe(System.out::println);
		
		
	}
}
