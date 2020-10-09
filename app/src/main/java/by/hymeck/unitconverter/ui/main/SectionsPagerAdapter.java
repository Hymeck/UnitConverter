package by.hymeck.unitconverter.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import by.hymeck.unitconverter.BuildConfig;
import by.hymeck.unitconverter.R;

public class SectionsPagerAdapter extends FragmentPagerAdapter
{

    @StringRes
    private static final int[] TabTitles = new int[]{R.string.tabMassText, R.string.tabDistanceText, R.string.tabTimeText};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm)
    {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;

        boolean isFull = BuildConfig.FLAVOR.equals("full");
        switch (position)
        {
            case 0:
                fragment = isFull?
                        by.hymeck.unitconverter.full.debug.MassFragment.newInstance() :
                        by.hymeck.unitconverter.fragments.MassFragment.newInstance();
                break;
            case 1:
                fragment = isFull?
                        by.hymeck.unitconverter.full.debug.DistanceFragment.newInstance() :
                        by.hymeck.unitconverter.fragments.DistanceFragment.newInstance();
                break;
            case 2:
                fragment = isFull?
                        by.hymeck.unitconverter.full.debug.TimeFragment.newInstance() :
                        by.hymeck.unitconverter.fragments.TimeFragment.newInstance();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }

        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        return mContext.getResources().getString(TabTitles[position]);
    }

    @Override
    public int getCount()
    {
        return TabTitles.length;
    }
}