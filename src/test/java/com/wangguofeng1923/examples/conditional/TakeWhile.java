package com.wangguofeng1923.examples.conditional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;

/*
 *TakeWhile则是根据一个函数来判断是否发射数据，
 *当函数返回值为true的时候正常发射数据；
 *当函数返回false的时候丢弃所有后面的数据。
 */
public class TakeWhile {
@Test
public void takeWhile(){
	
	Observable.interval(1, TimeUnit.SECONDS).takeWhile(aLong -> aLong < 5)
	.toBlocking()
	.subscribe(System.out::println);;
	
}
}
