package com.cheng.dreams.sampleframe.ui.activity;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cheng.dreams.sampleframe.R;

public class BaseBarActivity extends BaseActivity {

    private LinearLayout parentLinearLayout;//把父类activity和子类activity的view都add到这里
    public Toolbar mToolbar;
    public TextView mTitle;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        initContentView(R.layout.toolbar_layout);
        LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
    }

    /**
     * 初始化contentview
     */
    private void initContentView(int layoutResID) {
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        parentLinearLayout = new LinearLayout(this);
        parentLinearLayout.setOrientation(LinearLayout.VERTICAL);
        viewGroup.addView(parentLinearLayout);
        View view= LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
        mToolbar = (Toolbar) view.findViewById(R.id.tool_bar);
        mTitle = (TextView) view.findViewById(R.id.title_tv);
        mToolbar.setTitle("");
        mToolbar.setNavigationIcon(R.mipmap.back_image);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void setBarTitle(String title){
            if(TextUtils.isEmpty(title)){
                mTitle.setText(title);
            }else{
                if(title.length()>=10){
                    mTitle.setText(title.substring(0,9)+"...");
                }else {
                    mTitle.setText(title);
                }
            }
    }

}
