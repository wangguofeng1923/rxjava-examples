package history.rxjava.service;

import java.util.Collections;
import java.util.List;

import history.rxjava.callback.CatsQueryCallback;
import history.rxjava.callback.CutestCatCallback;
import history.rxjava.callback.StoreCallback;
import history.rxjava.dao.CatDao;
import history.rxjava.domain.Cat;
import history.rxjava.domain.Uri;

public class CatsService {
  private CatDao catDao=new CatDao();
  

  
  public Uri saveTheCutestCat(String query){
	 final CutestCatCallback cutestCatCallback=new CutestCatCallback(){

		@Override
		public void onCutestCatSaved(Uri uri) {
			System.out.println("the cutest cat is:"+uri);
			
		}

		@Override
		public void onQueryFailed(Exception e) {
			System.out.println("error when get and store the cutest cat.Error:"+e.getMessage());
			
		}};
		final StoreCallback storeCallback=new StoreCallback() {
			
			@Override
			public void onStoreFailed(Exception e) {
				cutestCatCallback.onQueryFailed(e);
				
			}
			
			@Override
			public void onCatStored(Uri uri) {
				cutestCatCallback.onCutestCatSaved(uri);
				
			}
		};
	  CatsQueryCallback catsQueryCallback=new CatsQueryCallback() {
			
		  @Override
          public void onCatListReceived(List<Cat> cats) {
			  Cat cutest = findCutest(cats);
			  catDao.store(cutest,storeCallback);
			 
          }

          @Override
          public void onQueryFailed(Exception e) {
        	  System.out.println("error when Query cats.Error:"+e.getMessage());
              
          }
		};
	     catDao.queryCats(query,catsQueryCallback);
	    
		  
		  
		  
//      List<Cat> cats = catDao.queryCats(query,null);
//      Cat cutest = findCutest(cats);
//	  Uri savedUri = catDao.store(cutest,null);

      return null;
  }

  private Cat findCutest(List<Cat> cats) {
      return Collections.max(cats);
  }
}
