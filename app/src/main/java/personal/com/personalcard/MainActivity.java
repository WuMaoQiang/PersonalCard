package personal.com.personalcard;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;

import java.util.List;

import butterknife.BindView;
import personal.com.personalcard.base.BaseActivity;
import personal.com.personalcard.fragment.HomePageFragment;
import personal.com.personalcard.fragment.SecondFragment;
import personal.com.personalcard.fragment.ThirdFragment;

/**
 * 使用柯基整理的 blankj:utilcode
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.container)
    FrameLayout mContainer;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;


    private Fragment[] fragments;
    private int currentTabIndex;
    private int index;
    private long exitTime;
    private HomePageFragment mHomePageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkPermision();


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        //初始化Fragment
        initFragments();
        //初始化侧滑菜单
        initNavigationView();
    }

    /**
     * 初始化Fragments
     */
    private void initFragments() {
        mHomePageFragment = HomePageFragment.newInstance();
        SecondFragment mFavoritesFragment = SecondFragment.newInstance();
        ThirdFragment thirdFragment = ThirdFragment.newInstance();

        fragments = new Fragment[]{
                mHomePageFragment,
                mFavoritesFragment,
                thirdFragment

        };
        // 添加显示第一个fragment
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, mHomePageFragment)
                .show(mHomePageFragment).commit();
    }

    /**
     * 初始化NavigationView
     */
    private void initNavigationView() {
        View headerView = mNavigationView.getHeaderView(0);
        mNavigationView.setNavigationItemSelectedListener(this);

        TextView mUserName = (TextView) headerView.findViewById(R.id.user_name);
        TextView mUserSign = (TextView) headerView.findViewById(R.id.user_other_info);
        //设置用户名 签名
        mUserName.setText(getResources().getText(R.string.hotbitmapgg));
        mUserSign.setText(getResources().getText(R.string.about_user_head_layout));
    }


    /**
     * DrawerLayout侧滑菜单开关
     */
    public void toggleDrawer() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    /**
     * 切换Fragment的下标
     */
    private void changeFragmentIndex(MenuItem item, int currentIndex) {
        index = currentIndex;
        switchFragment();
        item.setChecked(true);
    }

    /**
     * Fragment切换
     */
    private void switchFragment() {
        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
        trx.hide(fragments[currentTabIndex]);
        if (!fragments[index].isAdded()) {
            trx.add(R.id.container, fragments[index]);
        }
        trx.show(fragments[index]).commit();
        currentTabIndex = index;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.item_home:
                // 主页
                changeFragmentIndex(item, 0);
                return true;

            case R.id.item_favourite:
                // 我的收藏
                changeFragmentIndex(item, 1);
                return true;

            case R.id.item_theme:
                // 主题选择
                changeFragmentIndex(item, 2);

                return true;
        }

        return false;

    }

    /**
     * 监听back键处理DrawerLayout和SearchView
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mDrawerLayout.isDrawerOpen(mDrawerLayout.getChildAt(1))) {
                mDrawerLayout.closeDrawers();
            } else {

                exitApp();
            }
        }
        return true;
    }


    /**
     * 双击退出App
     */
    private void exitApp() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            ToastUtils.showShort("再按一次退出");
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }


    /**
     * 检查权限
     */
    private void checkPermision() {
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
