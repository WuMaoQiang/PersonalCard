package personal.com.personalcard.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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
public class SecondFragment extends BaseFragment {
    @BindView(R.id.navigation_second)
    LinearLayout navigationSecond;
    @BindView(R.id.empty_view)
    TextView emptyView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_empty;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }


    @OnClick(R.id.navigation_second)
    void toggleDrawer() {
        Activity activity = getActivity();
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).toggleDrawer();
        }
    }
}
