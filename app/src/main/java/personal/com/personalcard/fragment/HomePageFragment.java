package personal.com.personalcard.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;

import adapter.HomePagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import personal.com.personalcard.MainActivity;
import personal.com.personalcard.R;
import personal.com.personalcard.base.BaseFragment;
import personal.com.personalcard.widget.CircleImageView;
import personal.com.personalcard.widget.NoScrollViewPager;

/**
 * author:  cc
 * TODO
 * date:   On  2019/2/18
 */
public class HomePageFragment extends BaseFragment {

    @BindView(R.id.toolbar_user_avatar)
    CircleImageView mCircleImageView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabs;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_pager;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        initToolBar();
        initViewPager();
    }
    private void initToolBar() {
        mToolbar.setTitle("");
        ((MainActivity) getActivity()).setSupportActionBar(mToolbar);
        mCircleImageView.setImageResource(R.drawable.ic_hotbitmapgg_avatar);
    }

    private void initViewPager() {
        HomePagerAdapter mHomeAdapter = new HomePagerAdapter(getChildFragmentManager(), getApplicationContext());
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(mHomeAdapter);
        mSlidingTabs.setViewPager(mViewPager);
        mViewPager.setCurrentItem(1);
    }
    @OnClick(R.id.navigation_layout)
    void toggleDrawer() {
        Activity activity = getActivity();
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).toggleDrawer();
        }
    }



}
