package com.wangguofeng1923.examples.conditional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;
/*
 * SkipUnitl是根据一个标志Observable来判断的，
 * 当这个标志Observable没有发射数据的时候，
 * 所有源Observable发射的数据都会被跳过；
 * 当标志Observable发射了一个数据，则开始正常地发射数据。
 * @author Administrator
 *
 */
public class SkipUntil {
	@Test
	public void skipUntil(){
		
		Observable<Long> observable = Observable.interval(2,  TimeUnit.SECONDS).take(10);
		observable
		.skipUntil(Observable.interval(5, TimeUnit.SECONDS))
		.toBlocking()
		.subscribe(System.out::println);
		
	}

	
}
