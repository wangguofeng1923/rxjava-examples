package com.wangguofeng1923.examples.creation;

import org.junit.Test;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Action1;
import rx.internal.schedulers.ImmediateScheduler;

public class Repeat {
	@Test
	public void repeat(){
		Scheduler scheduler=ImmediateScheduler.INSTANCE;
		Observable<String>observable=Observable.just("1","2","3")
				.repeat()
				.repeat(2L)//repeat twice
				.repeat(scheduler)
				.repeat(3L, scheduler);//repeat three times
				
		observable.subscribe(new Action1<String>() {

			@Override
			public void call(String v) {
				System.out.println(v);
				
			}
		});

	}
}
