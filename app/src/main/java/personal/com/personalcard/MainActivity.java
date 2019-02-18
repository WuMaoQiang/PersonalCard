package personal.com.personalcard;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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


        List<String> permissions = PermissionUtils.getPermissions();
        LogUtils.i(permissions.get(0));
        boolean granted = PermissionUtils.isGranted(permissions.toString());
        LogUtils.i(granted);

        PermissionUtils permission = PermissionUtils.permission(permissions.toString());


        permission.callback(new PermissionUtils.FullCallback() {
            @Override
            public void onGranted(List<String> permissionsGranted) {
                LogUtils.i("onGranted");

            }

            @Override
            public void onDenied(List<String> permissionsDeniedForever, List<String> permissionsDenied) {
                LogUtils.i("denied");
            }
        });
        permission.theme(new PermissionUtils.ThemeCallback() {
            @Override
            public void onActivityCreate(Activity activity) {

            }
        });
        permission.request();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {PermissionUtils.launchAppDetailsSettings();
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
