package com.shaud.mvp.views;

import android.app.Activity;

/**
 * User: ShaudXiao
 * Date: 2017-06-15
 * Time: 14:31
 * Company: zx
 * Description:
 * FIXME
 */


public interface MvpBaseView extends MvpView {

    Activity getParentActivity();

    void showToast(String content);
}
