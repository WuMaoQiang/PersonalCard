package personal.com.personalcard.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
    private FragmentActivity activity;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(getLayoutId(), container, false);
        activity = getSupportActivity();
        return parentView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = ButterKnife.bind(this, view);
        initViews(savedInstanceState);

    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (FragmentActivity) activity;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        this.activity = null;
    }
    public FragmentActivity getSupportActivity() {
        return super.getActivity();
    }
    public Context getApplicationContext() {
        return this.activity == null ? (getActivity() == null ?
                null : getActivity().getApplicationContext()) : this.activity.getApplicationContext();
    }
    public android.app.ActionBar getSupportActionBar() {
        return getSupportActivity().getActionBar();
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
