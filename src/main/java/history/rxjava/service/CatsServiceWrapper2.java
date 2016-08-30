package history.rxjava.service;

import java.util.Collections;
import java.util.List;

import history.rxjava.callback.AsyncJob;
import history.rxjava.callback.Callback;
import history.rxjava.callback.CatsQueryCallback;
import history.rxjava.callback.CutestCatCallback;
import history.rxjava.callback.StoreCallback;
import history.rxjava.dao.CatDao;
import history.rxjava.dao.CatDaoWrapper;
import history.rxjava.dao.CatDaoWrapper2;
import history.rxjava.domain.Cat;
import history.rxjava.domain.Uri;

public class CatsServiceWrapper2 {
	private CatDaoWrapper2 catDaoWrapper2 = new CatDaoWrapper2();

	public void printCutestCat() {
		
		String query = "";
		final Callback<Uri> cutestCatCallback = new Callback<Uri>() {

			@Override
			public void onResult(Uri result) {
				System.out.println("the cutest cat is:" + result);

			}

			@Override
			public void onError(Exception e) {
				System.out.println("error when get and store the cutest cat.Error:" + e.getMessage());

			}
		};
		AsyncJob<Uri> resultJob=	this.saveTheCutestCat(query);
		resultJob.start(cutestCatCallback);

	}

	public  AsyncJob<Uri>  saveTheCutestCat(final String query) {
		final AsyncJob<List<Cat>> queryJob=catDaoWrapper2.queryCats(query);
		final AsyncJob<Cat>cutedJob=new AsyncJob<Cat>() {

			@Override
			public void start(final Callback<Cat> callback) {
				queryJob.start(new Callback<List<Cat>>() {
					
					@Override
					public void onResult(List<Cat> cats) {
						Cat cutest = findCutest(cats);
						callback.onResult(cutest);
					}
		
					@Override
					public void onError(Exception e) {
						callback.onError(e);
					}
		
				});
				
			}};
		
		
		 AsyncJob<Uri>resultJob=new AsyncJob<Uri>() {
			
			@Override
			public void start(final Callback<Uri> cutestCatCallback) {
				cutedJob.start(new Callback<Cat>() {
					
					@Override
					public void onResult(Cat result) {
						 AsyncJob<Uri>job=	catDaoWrapper2.store(result);
						 job.start(new Callback<Uri>() {
							
							@Override
							public void onResult(Uri result) {
								cutestCatCallback.onResult(result);
								
							}
							
							@Override
							public void onError(Exception e) {
								cutestCatCallback.onError(e);
								
							}
						});
					}
					
					@Override
					public void onError(Exception e) {
						cutestCatCallback.onError(e);
						
					}
				});

	
				
			}
		};
		return resultJob;

	}
	
	

	private Cat findCutest(List<Cat> cats) {
		return Collections.max(cats);
	}
}
