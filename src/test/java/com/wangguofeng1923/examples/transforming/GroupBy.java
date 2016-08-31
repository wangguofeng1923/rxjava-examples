package com.wangguofeng1923.examples.transforming;

import org.junit.Test;

import rx.Observable;
import rx.functions.Func1;

public class GroupBy {
	@Test
	public void groupBy(){
		Observable<String>observable=Observable.from(new String[]{"a","b","c","b","a","b"});
		
		observable.groupBy(new Func1<String, String>() {

			@Override
			public String call(String v) {
				
				return v;
			}
		}).subscribe(x->{
			final String key=x.getKey();
			x.count().subscribe(c->{
				System.out.println("key:"+key+",count:"+c);
			});

		});
		
	}

}
