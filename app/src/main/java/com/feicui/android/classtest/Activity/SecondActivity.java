package com.feicui.android.classtest.Activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.feicui.android.classtest.BaseActivity;
import com.feicui.android.classtest.R;

/**
 * Created by Administrator on 2016/9/26.
 */
public class SecondActivity extends BaseActivity {

    //显示的数据
    TextView tv_data;

    //标记
    public static final String TAG = "SecondActivity";
    @Override
    protected int setContent() {
        return R.layout.activity_second;
    }

    @Override
    protected void initView() {
        tv_data =(TextView) findViewById(R.id.tv_data);

        parseIntent();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_UP){
            if(keyCode == KeyEvent.KEYCODE_BACK){
                Intent mIntent = new Intent();
                switch (tv_data.getText().toString()){
                    case "Login":
                        mIntent.putExtra(TAG,"登录成功");
                        setResult(Activity.RESULT_OK,mIntent);
                        break;
                    case "Regist":
                        mIntent.putExtra(TAG,"注册成功");
                        setResult(Activity.RESULT_OK,mIntent);
                        break;
                    case "Other":
                        mIntent.putExtra(TAG,"位置操作");
                        setResult(Activity.RESULT_CANCELED,mIntent);
                }
                finish();
            }
        }
        return false;
    }

    public void exit(View view){
        Intent mIntent = new Intent();
        switch (tv_data.getText().toString()){
            case "Login":
                mIntent.putExtra(TAG,"登录成功");
                setResult(Activity.RESULT_OK,mIntent);
                break;
            case "Regist":
                mIntent.putExtra(TAG,"注册成功");
                setResult(Activity.RESULT_OK,mIntent);
                break;
            case "Other":
                mIntent.putExtra(TAG,"位置操作");
                setResult(Activity.RESULT_CANCELED,mIntent);
        }
        finish();
    }

    public void parseIntent(){
        Intent intent = getIntent();
        String operation = intent.getStringExtra(FirstActivity.TAG);
        switch (operation){
            case "Login":
                tv_data.setText("Login");
                break;
            case "Regist":
                tv_data.setText("Regist");
                break;
            case "Other":
                tv_data.setText("Other");
                break;
        }
    }
}
