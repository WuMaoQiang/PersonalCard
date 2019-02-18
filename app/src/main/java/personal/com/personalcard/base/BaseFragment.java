package personal.com.personalcard.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author:  cc
 * TODO
 * date:   On  2019/2/18
 */
public abstract class BaseFragment extends Fragment {
    private View parentView;
    private Unbinder bind;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(getLayoutId(), container, false);

        return parentView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = ButterKnife.bind(this, view);
        initViews(savedInstanceState);

    }


    /**
     * 设置布局layout
     *
     * @return
     */
    public abstract int getLayoutId();
    public abstract void initViews(Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
