package com.feicui.android.classtest.intent;

import android.app.Activity;
import android.os.Bundle;

import com.feicui.android.classtest.R;

/**
 * @author Neal 2016-09-26
 * @description Intent测试demo
 */

public class IntentTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_test);
    }
}
