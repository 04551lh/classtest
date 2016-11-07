package com.feicui.android.classtest.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

import com.feicui.android.classtest.BaseActivity;
import com.feicui.android.classtest.R;

/**
 * Created by Administrator on 2016/9/26.
 * @description
 */
public class FirstActivity extends BaseActivity{

    //显示数据
    TextView tv_data;

    //请求码
    private final int REQUEST_CODE_LOGIN = 0;
    private final int REQUEST_CODE_REGIST = 1;
    private final int REQUEST_CODE_OTHER = 2;
    private final int REQUEST_CODE_READ = 3;


    //Intent的Key

    public static final String TAG = "SecondActivity";
    @Override
    protected int setContent() {
        return R.layout.activity_first;
    }

    @Override
    protected void initView() {
        tv_data = (TextView) findViewById(R.id.tv_data);
    }

    @Override
    protected void setListener() {

    }

    public void loignActvity(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(TAG,"Login");
        startActivityForResult(intent,REQUEST_CODE_LOGIN);
    }
    public void registActvity(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(TAG,"Regist");
        startActivityForResult(intent,REQUEST_CODE_REGIST);
    }

    public void otherActvity(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(TAG,"Other");
        startActivityForResult(intent,REQUEST_CODE_OTHER);
    }

    public void pickContent(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent,REQUEST_CODE_READ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode){
            case Activity.RESULT_OK:
                switch (requestCode){
                    case REQUEST_CODE_LOGIN:
                        tv_data.setText(data.getStringExtra(SecondActivity.TAG));
                        break;
                    case REQUEST_CODE_REGIST:
                        tv_data.setText(data.getStringExtra(SecondActivity.TAG));
                        break;
                    case REQUEST_CODE_READ:
                        Cursor cursor = getContentResolver().query(data.getData(),
                                new String[]{ContactsContract.Contacts.DISPLAY_NAME},
                                null,
                                null,
                                null);
                        if(cursor.moveToFirst()){
                            int columnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                            String name = cursor.getString(columnIndex);
                            tv_data.setText(name);
                        }
                }
                break;
            case Activity.RESULT_CANCELED:
            case REQUEST_CODE_OTHER:
                tv_data.setText(data.getStringExtra(SecondActivity.TAG));
                break;
        }
    }
}
