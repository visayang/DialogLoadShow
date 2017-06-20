package com.show.dialogloadshow;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.show.utils.ProgressHUD;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initProgressBar();
    }

    public void click(View view) {
        showProgressBar();
        //子线程耗时操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                //UI线程更新UI
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        stopProgressBar();
                    }
                });
            }
        }).start();
    }

    /*==============进度条==============*/
    private ProgressHUD mProgressHUD;

    private void initProgressBar() {
        if (mProgressHUD == null) {
            mProgressHUD = ProgressHUD.newInstance(this, "正在登录...", false, null);
        }
        mProgressHUD.setMessage("正在登录...");
    }

    public void showProgressBar() {
        if (mProgressHUD != null && mProgressHUD.isShowing())
            return;
//        initProgressBar();
        mProgressHUD.show();
    }

    public void stopProgressBar() {
        if (mProgressHUD != null && mProgressHUD.isShowing()) {
            mProgressHUD.dismiss();
        }
    }
}
