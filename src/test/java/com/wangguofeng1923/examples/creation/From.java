package com.wangguofeng1923.examples.creation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;
import rx.Scheduler;
import rx.internal.schedulers.ImmediateScheduler;

public class From {
	@Test
	public  void from(){
		
		String[]array=new String[]{"0"};
		List<String>list=Arrays.asList("1","2");
		FutureTask<String>future=new FutureTask<String>(new Runnable() {
			
			@Override
			public void run() {
				
				
			}
		}, "done");
		
		Executors.newCachedThreadPool().submit(future);
		
		Scheduler scheduler=ImmediateScheduler.INSTANCE;
		Observable<String>observable=Observable.from(array)
		.concatWith(Observable.from(list))
		.concatWith(Observable.from(future))
		.concatWith(Observable.from(future, 10, TimeUnit.SECONDS))
		.concatWith(Observable.from(future, scheduler));
		observable.subscribe(System.out::println);
		

	}
}
