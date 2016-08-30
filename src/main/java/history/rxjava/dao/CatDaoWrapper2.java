package history.rxjava.dao;

import java.util.List;

import history.rxjava.callback.AsyncJob;
import history.rxjava.callback.Callback;
import history.rxjava.callback.CatsQueryCallback;
import history.rxjava.callback.StoreCallback;
import history.rxjava.domain.Cat;
import history.rxjava.domain.Uri;

public class CatDaoWrapper2 {
	  private CatDao catDao=new CatDao();
	  public AsyncJob<List<Cat>> queryCats(final String query){
		  AsyncJob<List<Cat>>job= new AsyncJob<List<Cat>>(){

			@Override
			public void start(final Callback<List<Cat>> callback) {
				  CatsQueryCallback 	catsQueryCallback=new CatsQueryCallback() {
						
						@Override
						public void onQueryFailed(Exception e) {
							callback.onError(e);
							
						}
						
						@Override
						public void onCatListReceived(List<Cat> cats) {
							callback.onResult(cats);
							
						}
					};
					catDao.queryCats(query, catsQueryCallback);
				
			}};


		return job;
		
	}
	  
//	  public void queryCats(String query, final Callback<List<Cat>> callback){
//			  CatsQueryCallback 	catsQueryCallback=new CatsQueryCallback() {
//					
//					@Override
//					public void onQueryFailed(Exception e) {
//						callback.onError(e);
//						
//					}
//					
//					@Override
//					public void onCatListReceived(List<Cat> cats) {
//						callback.onResult(cats);
//						
//					}
//				};
//				catDao.queryCats(query, catsQueryCallback);
//			
//			
//		}
//	  
	  
	  public AsyncJob<Uri> store(final Cat cat){
		  AsyncJob<Uri>job= new AsyncJob<Uri>(){

			@Override
			public void start(final Callback<Uri> callback) {
				  StoreCallback storeCallback=new StoreCallback() {
						
						@Override
						public void onStoreFailed(Exception e) {
							callback.onError(e);
							
						}
						
						@Override
						public void onCatStored(Uri uri) {
							callback.onResult(uri);
							
						}
					};
						
						catDao.store(cat, storeCallback);
				
			}};
			return job;

			
		}
	  
//	  public void store(Cat cat,  final Callback<Uri> callback){
//		  StoreCallback storeCallback=new StoreCallback() {
//			
//			@Override
//			public void onStoreFailed(Exception e) {
//				callback.onError(e);
//				
//			}
//			
//			@Override
//			public void onCatStored(Uri uri) {
//				callback.onResult(uri);
//				
//			}
//		};
//			
//			this.catDao.store(cat, storeCallback);
//			
//		}
		
		
}
