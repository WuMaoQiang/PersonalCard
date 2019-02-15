package personal.com.personalcard;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;

import com.blankj.utilcode.util.CrashUtils;
import com.blankj.utilcode.util.DeviceUtils;

import personal.com.personalcard.base.BaseActivity;
import personal.com.personalcard.utils.UtilCode;

/**
 * 使用柯基整理的 blankj:utilcode
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UtilCode.function(this);
        DeviceUtils.reboot2Recovery();
    }
}
