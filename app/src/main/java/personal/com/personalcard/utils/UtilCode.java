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
 * TODO
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

    }

}
