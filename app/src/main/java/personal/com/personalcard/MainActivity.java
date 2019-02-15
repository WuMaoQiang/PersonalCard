package personal.com.personalcard;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.blankj.utilcode.util.CrashUtils;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.ImageUtils;

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
//ccfenzhi

    }
}
