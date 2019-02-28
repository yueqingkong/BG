package block.guess.main.adapter;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import block.guess.base.BaseFragment;

public class LotteryPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> baseFragmentList = new ArrayList();

    public LotteryPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.baseFragmentList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return baseFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return baseFragmentList == null ? 0 : baseFragmentList.size();
    }
}
