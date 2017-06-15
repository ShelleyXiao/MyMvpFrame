package com.shaud.mvp.presenters;

import com.shaud.mvp.views.MvpView;

import java.lang.ref.WeakReference;

/**
 * User: ShaudXiao
 * Date: 2017-06-15
 * Time: 14:33
 * Company: zx
 * Description:
 * FIXME
 */


public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private WeakReference<V> viewRef;



    public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<V>(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
