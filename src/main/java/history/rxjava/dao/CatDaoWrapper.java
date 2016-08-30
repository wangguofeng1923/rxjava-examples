package history.rxjava.dao;

import java.util.List;

import history.rxjava.callback.Callback;
import history.rxjava.callback.CatsQueryCallback;
import history.rxjava.callback.StoreCallback;
import history.rxjava.domain.Cat;
import history.rxjava.domain.Uri;

public class CatDaoWrapper {
	  private CatDao catDao=new CatDao();
	  
	  public void queryCats(String query, final Callback<List<Cat>> callback){
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
			
			
		}
	  
	  
	  public void store(Cat cat,  final Callback<Uri> callback){
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
			
			this.catDao.store(cat, storeCallback);
			
		}
		
		
}
