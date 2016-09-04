package com.wangguofeng1923.examples.conditional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;

/*
 * TakeUntil是使用一个标志Observable是否发射数据来判断，
 * 当标志Observable没有发射数据时，正常发射数据，
 * 而一旦标志Observable发射过了数据则后面的数据都会被丢弃。
 */
public class TakeUntil {
@Test
public void takeUntil(){
	
	Observable.interval(1, TimeUnit.SECONDS)
	.takeUntil(Observable.timer(3, TimeUnit.SECONDS))
	.toBlocking().subscribe(System.out::println);;
	
	
}
}
