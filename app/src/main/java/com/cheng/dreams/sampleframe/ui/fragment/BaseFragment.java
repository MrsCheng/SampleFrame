package com.cheng.dreams.sampleframe.ui.fragment;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.cheng.dreams.sampleframe.util.DialogUtil;

public class BaseFragment extends Fragment {
    Toast toast;
    private ProgressDialog mProgressDialog;

    /**
     * Toast 解决多次点击重复Toast的问题
     * @param msg
     */
    protected void showToast(String msg){
        if(toast==null){
            toast = Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT);
        }else{
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 加载中...
     */
    protected void showDialog() {
        showProgressDialog("加载中,请稍后...",true);
    }

    protected void showProgressDialog(String message, boolean cancelable) {
        if (mProgressDialog == null)
            mProgressDialog = DialogUtil.createProgressDialog(getActivity(), message, cancelable);
        if (mProgressDialog.isShowing()) {
            hideDialog();
            return;
        } else {
            mProgressDialog.show();
        }
    }

    protected void hideDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

}
