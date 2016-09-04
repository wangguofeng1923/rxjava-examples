package com.wangguofeng1923.examples.errorhandling;

import org.junit.Test;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class OnExceptionResumeNext {
 @Test
 public void errorResumeNext(){
	 onErrorResumeNextObserver().subscribe(new Subscriber<String>() {
		    @Override
		    public void onCompleted() {
		        System.out.println("onErrorResume-onCompleted\n");
		    }

		    @Override
		    public void onError(Throwable e) {
		    	  System.out.println("onErrorResume-onError:" + e.getMessage());
		    }

		    @Override
		    public void onNext(String s) {
		    	  System.out.println("onErrorResume-onNext:" + s);
		    }
		});
	 
	 
 }
 

	private Observable<String> onErrorResumeNextObserver() {
	    return createObserver().onErrorResumeNext(Observable.just("7", "8", "9"));
	}

	private Observable<String> createObserver() {
	    return Observable.create(new Observable.OnSubscribe<String>() {
	        @Override
	        public void call(Subscriber<? super String> subscriber) {
	            for (int i = 1; i <= 6; i++) {
	                if (i < 3) {
	                    subscriber.onNext("onNext:" + i);
	                } else {
	                    subscriber.onError(new Throwable("Throw error"));
	                }
	            }
	        }
	    });
	}
}
