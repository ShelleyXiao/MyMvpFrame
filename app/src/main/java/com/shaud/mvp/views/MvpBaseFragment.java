package com.shaud.mvp.views;

import android.app.Activity;
import android.os.Bundle;

import com.shaud.mvp.presenters.MvpPresenter;

/**
 * User: ShaudXiao
 * Date: 2017-06-15
 * Time: 14:59
 * Company: zx
 * Description:
 * FIXME
 */


public abstract class MvpBaseFragment<P extends MvpPresenter> extends MvpFragment implements MvpBaseView {

    P presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter is Null");
        }
        presenter.attachView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
        presenter = null;
    }

    @Override
    public Activity getParentActivity() {
        return null;
    }


    protected abstract P createPresenter();
}
