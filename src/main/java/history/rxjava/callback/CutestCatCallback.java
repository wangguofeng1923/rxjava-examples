package history.rxjava.callback;

import history.rxjava.domain.Uri;

public interface CutestCatCallback {
    void onCutestCatSaved(Uri uri);
    void onQueryFailed(Exception e);
}