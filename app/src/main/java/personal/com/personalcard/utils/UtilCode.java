package personal.com.personalcard.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.Signature;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.LogUtils;

import java.util.List;

import personal.com.personalcard.R;

import static personal.com.personalcard.utils.Constant.TAG;

/**
 * author:  cc
 * TODO 用来测试com.blankj:utilcode 里面具体的工具类的使用，只是用来测试 ，项目中没用到
 * date:   On  2019/2/15
 */
public class UtilCode {


    public static void function(Activity activity) {
        //====================> 1. ActivityUtils
        /**
         * 判断Activity是否存在
         */
        boolean mainActivity = ActivityUtils.isActivityExists("personal.com.personalcard", "personal.com.personalcard.MainActivity");
//        LogUtils.i( mainActivity);

        /**
         *  获取 Activity 栈链表
         */
        List<Activity> activityList = ActivityUtils.getActivityList();
        for (Activity a : activityList) {
//            LogUtils.i( a.getLocalClassName());
        }

        //====================> 1.  AppUtils
        /**
         *判断app是否安装
         */
        boolean appInstalled = AppUtils.isAppInstalled("com.qudong.test");
//        LogUtils.i( appInstalled);
        /**
         * 卸载 App  可以成功卸载
         */
//        AppUtils.uninstallApp("com.qudong.test");
        /**
         * 判断 App 是否有 root 权限
         */
        boolean appRoot = AppUtils.isAppRoot();
//        LogUtils.i( appRoot);
        /**
         * 不需要root权限 可以打开手机内有的app
         */
        // AppUtils.launchApp("com.qudong.test");
        /**
         * 获取app签名的SHA1值
         */
        String appSignatureSHA1 = AppUtils.getAppSignatureSHA1();
//        LogUtils.i(appSignatureSHA1);
        /**
         * 获取app的信息
         */
        final AppUtils.AppInfo appInfo = AppUtils.getAppInfo();
//        LogUtils.i(appInfo.getPackagePath());
        List<AppUtils.AppInfo> appsInfo = AppUtils.getAppsInfo();
        for (AppUtils.AppInfo appInfo1:appsInfo){
//            String name = appInfo1.getName();
        }
        //====================> 1.   BarUtils 状态栏相关
        BarUtils.setStatusBarColor(activity,  activity.getResources().getColor(R.color.colorAccent));

//        UtilCode.function(this);//工具类测试
//        //图片工具类 加文字水印
//        Drawable aaa = getResources().getDrawable(R.drawable.aaa);
//        Bitmap bitmap = ImageUtils.drawable2Bitmap(aaa);
//        Drawable i = getResources().getDrawable(R.drawable.ic_launcher);
//        Bitmap bitmap2 = ImageUtils.drawable2Bitmap(i);
//        //文字水印
//        Bitmap TestWatermark = ImageUtils.addTextWatermark(bitmap, "123", 20, getResources().getColor(R.color.colorAccent), 00.0f, 00.0f);
////        imageView.setImageBitmap(TestWatermark);
//        //图片水印
//        Bitmap bitmapAddWatermark = ImageUtils.addImageWatermark(bitmap, bitmap2, 1, 11, 120);
////        imageView.setImageBitmap(bitmapAddWatermark);
//        //灰度图片
//        Bitmap bitmapToGray = ImageUtils.toGray(bitmap2);
////        imageView.setImageBitmap(bitmapToGray);
//
//        //快速模糊
//        Bitmap bitmapFastBlur = ImageUtils.fastBlur(bitmap, 0.5f, 1);
//        imageView.setImageBitmap(bitmapFastBlur);
    }

}
