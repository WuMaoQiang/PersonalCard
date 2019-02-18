package personal.com.personalcard.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import personal.com.personalcard.MainActivity;
import personal.com.personalcard.R;
import personal.com.personalcard.base.BaseFragment;

/**
 * author:  cc
 * TODO
 * date:   On  2019/2/18
 */
public class HomePageFragment extends BaseFragment {

    @BindView(R.id.navigation_layout)
    LinearLayout navigationLayout;
    Unbinder unbinder;

    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_pager;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    @OnClick(R.id.navigation_layout)
    void toggleDrawer() {
        Activity activity = getActivity();
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).toggleDrawer();
        }
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
