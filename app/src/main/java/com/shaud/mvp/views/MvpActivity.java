package com.shaud.mvp.views;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.shaud.mvp.presenters.MvpPresenter;

/**
 * User: ShaudXiao
 * Date: 2017-06-15
 * Time: 14:41
 * Company: zx
 * Description:
 * FIXME
 */


public abstract class MvpActivity <P extends MvpPresenter> extends AppCompatActivity implements MvpBaseView{
    P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if(null == presenter) {
            throw new NullPointerException("Presenter is Null");
        }
        presenter.attachView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("UsbMain", "MvpActivity.onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("UsbMain", "MvpActivity.onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("UsbMain", "MvpActivity.onResume()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("UsbMain", "MvpActivity.onDestroy()");
        presenter.detachView(false);
    }


    @Override
    public Activity getParentActivity(){
        return this;
    }


    abstract P createPresenter();
}
