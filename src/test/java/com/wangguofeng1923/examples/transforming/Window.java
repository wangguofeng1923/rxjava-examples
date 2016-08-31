package com.wangguofeng1923.examples.transforming;

import org.junit.Test;

import rx.Observable;

public class Window {
@Test
public void window(){
	Observable<Integer>observable=Observable.range(1, 10);
	observable.window(3).subscribe(o->{
		o.subscribe(System.out::println);
	});
	
	
	
}
}
