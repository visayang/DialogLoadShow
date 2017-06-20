# DialogLoadShow
加载转圈对话框

![](https://github.com/visayang/DialogLoadShow/raw/master/pic/效果图.png)  


简单配置：

1  drawable-mdpi下的文件，

2 res- layout的xml布局

3 工具类 ProgressHUD

4 图片，完成帧动画用的，可以替换

5 样式 style



简单使用

```
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
```

注意：因为是UI线程，所以如果子线程更新UI，请使用loop或者runOnuiThread 代替。
