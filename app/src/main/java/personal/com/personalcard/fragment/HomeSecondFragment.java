package personal.com.personalcard.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
public class HomeSecondFragment extends BaseFragment {

    @BindView(R.id.textView)
    TextView mTextView;

    @Override
    public int getLayoutId() {
        return R.layout.home_first;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mTextView.setText("2");

    }

    public static HomeSecondFragment newInstance() {

        return new HomeSecondFragment();
    }


}
