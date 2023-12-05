package com.diemminhtri.customlistview;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class CountryPageAdapter extends FragmentStateAdapter {
    List<Country> lstDadaSource;
    public CountryPageAdapter(@NonNull FragmentActivity fragmentActivity, List<Country> dadaSource) {
        super(fragmentActivity);
        lstDadaSource = dadaSource;
    }

    @NonNull
    @Override
    public Fragment createFragment(int i) {
        Country c = lstDadaSource.get(i);
        CountryFragment countryFragment = new CountryFragment(c);
        return countryFragment;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
