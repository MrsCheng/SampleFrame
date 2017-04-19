package com.cheng.dreams.sampleframe.ui.activity;

import android.os.Bundle;
import com.cheng.dreams.sampleframe.R;

public class MainActivity extends BaseBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBarTitle("哈哈哈哈哈");
    }
}
