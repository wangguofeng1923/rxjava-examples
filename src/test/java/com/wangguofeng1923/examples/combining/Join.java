package com.wangguofeng1923.examples.combining;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;
import rx.functions.Func2;

public class Join {
	@Test
	public void join(){
		Observable.interval(2, TimeUnit.SECONDS).join(
				Observable.interval(2, TimeUnit.SECONDS),
				(x)->{return Observable.interval(2000, TimeUnit.MILLISECONDS);}, 
				(y)->{return Observable.interval(3000, TimeUnit.MILLISECONDS);}, 
				new Func2<Long, Long, Long>() {
					@Override
					public Long call(Long v1, Long v2) {
						System.out.println(v1+":"+v2);
						return v1+v2;
					}
				}
				).take(10).toBlocking().subscribe(System.out::println);
		 
		
	}

}
