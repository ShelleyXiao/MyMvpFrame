package com.shaud.mvp.presenters;

import android.support.annotation.UiThread;

import com.shaud.mvp.views.MvpView;

/**
 * User: ShaudXiao
 * Date: 2017-06-15
 * Time: 14:32
 * Company: zx
 * Description:
 * FIXME
 */


public interface MvpPresenter<V extends MvpView> {

    @UiThread
    void attachView(V view);

    @UiThread
    void detachView(boolean retainInstance);

}
