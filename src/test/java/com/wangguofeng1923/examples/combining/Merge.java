package com.wangguofeng1923.examples.combining;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import rx.Observable;

public class Merge {
@Test
public void merge(){
	List<Observable<?>>ite=Arrays.asList(Observable.interval(700, TimeUnit.MILLISECONDS),Observable.interval(1, TimeUnit.SECONDS));
	Observable<?>[]arr=ite.toArray(new Observable<?>[0]);
	Observable.merge(arr).take(10).toBlocking().subscribe(System.out::println);
	
}
@Test
public void mergeWith(){
	Observable.interval(700, TimeUnit.MILLISECONDS).mergeWith(Observable.interval(1, TimeUnit.SECONDS))
	.take(10).toBlocking().subscribe(System.out::println);
}
}
