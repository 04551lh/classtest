package com.feicui.android.classtest.intent;

import android.content.Intent;

import android.view.View;

import com.feicui.android.classtest.BaseActivity;
import com.feicui.android.classtest.R;


public class EActivity extends BaseActivity {


    @Override
    protected int setContent() {
        return R.layout.activity_e;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

    }

    /**
     * @description 启动ActivityB
     * @param view 被点击的视图
     */
    public void startActivityB(View view) {

        //显示指定要启动的组件
        Intent mIntent = new Intent(this, BActivity.class);
        //设定启动标记,该标记表示,存在跟目标Activity相同taskAffinity的栈,则压入,否则与默认效果相同
        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //启动目标组件
        startActivity(mIntent);
    }
}
