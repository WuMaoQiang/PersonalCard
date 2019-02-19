package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import personal.com.personalcard.R;
import personal.com.personalcard.fragment.HomeFirstFragment;
import personal.com.personalcard.fragment.HomeSecondFragment;
import personal.com.personalcard.fragment.SecondFragment;
import personal.com.personalcard.fragment.ThirdFragment;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 主界面Fragment模块Adapter
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

  private final String[] TITLES;
  private Fragment[] fragments;

  public HomePagerAdapter(FragmentManager fm, Context context) {
    super(fm);
    TITLES = context.getResources().getStringArray(R.array.sections);
    fragments = new Fragment[TITLES.length];
  }


  @Override
  public Fragment getItem(int position) {
    if (fragments[position] == null) {
      switch (position) {
        case 0:
          fragments[position] = HomeFirstFragment.newInstance();
          break;
        case 1:
          fragments[position] = HomeSecondFragment.newInstance();
          break;
        case 2:
          fragments[position] = HomeFirstFragment.newInstance();
          break;
        case 3:
          fragments[position] = HomeSecondFragment.newInstance();
          break;
        case 4:
          fragments[position] = HomeFirstFragment.newInstance();
          break;
        case 5:
          fragments[position] = HomeSecondFragment.newInstance();
          break;
        default:
          break;
      }
    }
    return fragments[position];
  }


  @Override
  public int getCount() {
    return TITLES.length;
  }


  @Override
  public CharSequence getPageTitle(int position) {
    return TITLES[position];
  }
}
