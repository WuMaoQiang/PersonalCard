package personal.com.personalcard;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SpanUtils;
import com.blankj.utilcode.util.StringUtils;

import java.util.List;

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
        ImageView imageView = findViewById(R.id.img);
        TextView textView = findViewById(R.id.tv);



        //获取注册的权限列表
        final List<String> permissions = PermissionUtils.getPermissions();
        LogUtils.i(permissions.get(0));
        //判断是否有权限
        boolean granted = PermissionUtils.isGranted(permissions.get(0).toString());
        LogUtils.i(granted);
        //创建permission 进行申请权限，并设置回调
        PermissionUtils permission = PermissionUtils.permission(permissions.get(0).toString());
        permission.callback(new PermissionUtils.FullCallback() {
            @Override
            public void onGranted(List<String> permissionsGranted) {
                LogUtils.i("onGranted");
            }

            @Override
            public void onDenied(List<String> permissionsDeniedForever, List<String> permissionsDenied) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permissions.get(0).toString())) {//选择不在提示
                    LogUtils.i("denied alal");
                    PermissionUtils.launchAppDetailsSettings();
                } else {
                    LogUtils.i("denied");

                }
            }
        }).request();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        UtilCode.function(this);//工具类测试

        //图片工具类 加文字水印
        Drawable aaa = getResources().getDrawable(R.drawable.aaa);
        Bitmap bitmap = ImageUtils.drawable2Bitmap(aaa);
        Drawable i = getResources().getDrawable(R.drawable.ic_launcher);
        Bitmap bitmap2 = ImageUtils.drawable2Bitmap(i);
        //文字水印
        Bitmap TestWatermark = ImageUtils.addTextWatermark(bitmap, "123", 20, getResources().getColor(R.color.colorAccent), 00.0f, 00.0f);
//        imageView.setImageBitmap(TestWatermark);
        //图片水印
        Bitmap bitmapAddWatermark = ImageUtils.addImageWatermark(bitmap, bitmap2, 1, 11, 120);
//        imageView.setImageBitmap(bitmapAddWatermark);
        //灰度图片
        Bitmap bitmapToGray = ImageUtils.toGray(bitmap2);
//        imageView.setImageBitmap(bitmapToGray);

        //快速模糊
        Bitmap bitmapFastBlur = ImageUtils.fastBlur(bitmap, 0.5f, 1);
        imageView.setImageBitmap(bitmapFastBlur);


    }
}
