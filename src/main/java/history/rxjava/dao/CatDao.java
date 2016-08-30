package history.rxjava.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import history.rxjava.callback.CatsQueryCallback;
import history.rxjava.callback.StoreCallback;
import history.rxjava.domain.Cat;
import history.rxjava.domain.Uri;

public class CatDao {
   
	public void queryCats(String query, CatsQueryCallback catsQueryCallback){
		List<Cat> cats=Collections.emptyList();
		try{
			cats=new ArrayList<>();//query from db
			catsQueryCallback.onCatListReceived(cats);
		}catch(Exception e){
			catsQueryCallback.onQueryFailed(e);
		}
		
		
	}
	public void store(Cat cat,StoreCallback storeCallback){
		Uri uri=new Uri(cat);
		try{
			System.out.println(uri);//store data into db
			storeCallback.onCatStored(uri);
		}catch(Exception e){
			storeCallback.onStoreFailed(e);
		}
	
    }
}
