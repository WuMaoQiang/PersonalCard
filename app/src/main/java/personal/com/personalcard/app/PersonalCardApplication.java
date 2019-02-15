package personal.com.personalcard.app;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

import static com.blankj.utilcode.util.CrashUtils.init;

/**
 * author:  cc
 * TODO
 * date:   On  2019/2/15
 */
public class PersonalCardApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(PersonalCardApplication.this);
    }
}
