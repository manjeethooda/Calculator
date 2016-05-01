package manjeet_hooda.calculator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
/**
 * Created by manjeet on 24/4/16.
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private fragment_simple mFragment_simple;
    private fragment_scientific mFragment_scientific;
    private int mNumOfTabs;
    private MainActivity mainActivity;

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    public MyPagerAdapter(FragmentManager fm, int NumOfTabs, MainActivity mainActivity) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.mainActivity = mainActivity;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if(mFragment_simple == null) {
                    mFragment_simple = new fragment_simple();
                }
                mFragment_simple.setupListener(mainActivity);
                return mFragment_simple;
            case 1:
                if (mFragment_scientific == null) {
                    mFragment_scientific = new fragment_scientific();
                }
                mFragment_scientific.setupListener(mainActivity);
                return mFragment_scientific;
            default:
                return null;
        }
    }
}