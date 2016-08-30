package history.rxjava.service;

import java.util.Collections;
import java.util.List;

import history.rxjava.callback.Callback;
import history.rxjava.callback.CatsQueryCallback;
import history.rxjava.callback.CutestCatCallback;
import history.rxjava.callback.StoreCallback;
import history.rxjava.dao.CatDao;
import history.rxjava.dao.CatDaoWrapper;
import history.rxjava.domain.Cat;
import history.rxjava.domain.Uri;

public class CatsServiceWrapper {
	private CatDaoWrapper catDaoWrapper = new CatDaoWrapper();

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
		this.saveTheCutestCat(query, cutestCatCallback);

	}

	public void saveTheCutestCat(String query, final Callback<Uri> cutestCatCallback) {

		final Callback<Uri> storeCallback = new Callback<Uri>() {

			@Override
			public void onResult(Uri result) {
				cutestCatCallback.onResult(result);

			}

			@Override
			public void onError(Exception e) {
				cutestCatCallback.onError(e);

			}
		};
		Callback<List<Cat>> catsQueryCallback = new Callback<List<Cat>>() {

			@Override
			public void onResult(List<Cat> cats) {
				Cat cutest = findCutest(cats);
				catDaoWrapper.store(cutest, storeCallback);
			}

			@Override
			public void onError(Exception e) {
				cutestCatCallback.onError(e);
			}

		};
		catDaoWrapper.queryCats(query, catsQueryCallback);

	}

	private Cat findCutest(List<Cat> cats) {
		return Collections.max(cats);
	}
}
