package personal.com.personalcard.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author:  cc
 * TODO
 * date:   On  2019/2/15
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置布局内容
        setContentView(getLayoutId());
        //初始化黄油刀控件绑定框架 要在setContentView之后
        bind = ButterKnife.bind(this);
        //初始化控件
        initViews(savedInstanceState);

    }

    /**
     * 设置布局layout
     *
     * @return
     */
    public abstract int getLayoutId();
    /**
     * 初始化views
     *
     * @param savedInstanceState
     */
    public abstract void initViews(Bundle savedInstanceState);
    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
