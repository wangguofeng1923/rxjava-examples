package com.wangguofeng1923.examples.conditional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;
import rx.functions.Func1;

/*
 * SkipWhile则是根据一个函数来判断是否跳过数据，
 * 当函数返回值为true的时候则一直跳过源Observable发射的数据；
 * 当函数返回false的时候则开始正常发射数据。
 */
public class SkipWhile {
	@Test
	public void skipWhile(){
		
		Integer[]array=	new Integer[]{4,6,8,5,0,2,9};
		Observable<Integer> observable = Observable.from(array);
		observable.skipUntil(Observable.interval(5, TimeUnit.SECONDS)).toBlocking().subscribe(System.out::println);
		
		observable.skipWhile(new Func1<Integer, Boolean>() {

			@Override
			public Boolean call(Integer v) {
				return v%2==0;
			}
			
		})

		.toBlocking().subscribe(System.out::println);

		
	}
}
