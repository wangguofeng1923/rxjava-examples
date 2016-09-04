package com.wangguofeng1923.examples.errorhandling;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;

public class OnErrorResume {
	@Test
	public void nnErrorResume(){
		
		onExceptionResumeObserver(false).subscribe(new Subscriber<String>() {
		    @Override
		    public void onCompleted() {
		    	System.out.println("onException-false-onCompleted\n");
		    }

		    @Override
		    public void onError(Throwable e) {
		    	System.out.println("onException-false-onError:" + e.getMessage());
		    }

		    @Override
		    public void onNext(String s) {
		    	System.out.println("onException-false-onNext:" + s);
		    }
		});
		
		onExceptionResumeObserver(true).subscribe(new Subscriber<String>() {
		    @Override
		    public void onCompleted() {
		        System.out.println("onException-true-onCompleted\n");
		    }

		    @Override
		    public void onError(Throwable e) {
		    	 System.out.println("onException-true-onError:" + e.getMessage());
		    }

		    @Override
		    public void onNext(String s) {
		    	 System.out.println("onException-true-onNext:" + s);
		    }
		});
		
	}
	private Observable<String> onExceptionResumeObserver(boolean isException) {
	    return createObserver(isException).onExceptionResumeNext(Observable.just("7", "8", "9"));
	}


	private Observable<String> createObserver(Boolean createExcetion) {
	    return Observable.create(new Observable.OnSubscribe<String>() {
	        @Override
	        public void call(Subscriber<? super String> subscriber) {
	            for (int i = 1; i <= 6; i++) {
	                if (i < 3) {
	                    subscriber.onNext("onNext:" + i);
	                } else if (createExcetion) {
	                    subscriber.onError(new Exception("Exception"));
	                } else {
	                    subscriber.onError(new Throwable("Throw error"));

	                }
	            }
	        }
	    });
	}
}
