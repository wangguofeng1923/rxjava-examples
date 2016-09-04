package com.wangguofeng1923.examples.errorhandling;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;

public class OnErrorReturn {

	 @Test
	 public void errorReturn(){
		 onErrorReturnObserver().subscribe(new Subscriber<String>() {
			    @Override
			    public void onCompleted() {
			        System.out.println("onErrorReturn-onCompleted\n");
			    }

			    @Override
			    public void onError(Throwable e) {
			    	  System.out.println("onErrorReturn-onError:" + e.getMessage());
			    }

			    @Override
			    public void onNext(String s) {
			    	  System.out.println("onErrorReturn-onNext:" + s);
			    }
			});
		 
		 
	 }
	 
	 	private Observable<String> onErrorReturnObserver() {
		    return createObserver().onErrorReturn(throwable -> "onErrorReturn");
		}

	

		private Observable<String> createObserver() {
		    return Observable.create(new Observable.OnSubscribe<String>() {
		        @Override
		        public void call(Subscriber<? super String> subscriber) {
		            //for (int i = 1; i <= 6; i++) {
		                //if (i < 3) {
		                    subscriber.onNext("onNext:" + 1);
		                //} else {
		                    subscriber.onError(new Throwable("Throw error"));
		                //}
		            //}
		        }
		    });
		}
}
