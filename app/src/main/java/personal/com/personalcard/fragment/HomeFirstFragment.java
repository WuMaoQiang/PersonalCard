package personal.com.personalcard.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import personal.com.personalcard.R;
import personal.com.personalcard.base.BaseFragment;

/**
 * author:  cc
 * TODO
 * date:   On  2019/2/19
 */
public class HomeFirstFragment extends BaseFragment {

    @BindView(R.id.recycle)
    RecyclerView mRecycle;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public int getLayoutId() {
        return R.layout.home_first_fragment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    public static HomeFirstFragment newInstance() {

        return new HomeFirstFragment();
    }


}
