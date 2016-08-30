package history.rxjava.callback;

import history.rxjava.domain.Uri;

public interface StoreCallback{
        void onCatStored(Uri uri);
        void onStoreFailed(Exception e);
    }