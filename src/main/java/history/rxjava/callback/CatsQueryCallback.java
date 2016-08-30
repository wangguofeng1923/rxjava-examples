package history.rxjava.callback;

import java.util.List;

import history.rxjava.domain.Cat;

public interface CatsQueryCallback {
    public void onCatListReceived(List<Cat> cats);

    public void onQueryFailed(Exception e);
}