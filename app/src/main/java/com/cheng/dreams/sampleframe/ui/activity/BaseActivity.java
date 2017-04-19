package com.cheng.dreams.sampleframe.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.cheng.dreams.sampleframe.util.DialogUtil;

public class BaseActivity extends AppCompatActivity {

    Toast toast;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Toast 解决多次点击重复Toast的问题
     * @param msg
     */
    protected void showToast(String msg){
        if(toast==null){
            toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
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
            mProgressDialog = DialogUtil.createProgressDialog(this, message, cancelable);
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
