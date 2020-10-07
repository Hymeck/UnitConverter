package by.hymeck.unitconverter.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import by.hymeck.unitconverter.R;
import by.hymeck.unitconverter.fragments.DistanceFragment;
import by.hymeck.unitconverter.fragments.MassFragment;
import by.hymeck.unitconverter.fragments.TimeFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
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
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fragment = null;

        switch (position)
        {
            case 0:
                fragment = MassFragment.newInstance();
                break;
            case 1:
                fragment = DistanceFragment.newInstance();
                break;
            case 2:
                fragment = TimeFragment.newInstance();
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