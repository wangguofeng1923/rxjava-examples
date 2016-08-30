package history.rxjava.callback;
public interface Func<T, R> {
    R call(T t);
}