package personal.com.personalcard.fragment;

import android.os.Bundle;

import personal.com.personalcard.R;
import personal.com.personalcard.base.BaseFragment;

/**
 * author:  cc
 * TODO
 * date:   On  2019/2/19
 */
public class HomeFirstFragment extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.home_first;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }
    public static HomeFirstFragment  newInstance(){

       return new HomeFirstFragment();
    }
}
