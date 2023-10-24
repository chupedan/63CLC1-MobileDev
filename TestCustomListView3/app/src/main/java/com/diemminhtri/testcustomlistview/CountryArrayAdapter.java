package com.diemminhtri.testcustomlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryArrayAdapter extends BaseAdapter {
    List<Country> lstDataSrc;
    LayoutInflater inflater;
    Context context;

    public CountryArrayAdapter(List<Country> lstDataSrc,  Context context) {
        this.lstDataSrc = lstDataSrc;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    class CountryViewHolder {
        ImageView avatar;
        TextView name, population;
    }

    @Override
    public int getCount() {
        return lstDataSrc.size();
    }

    @Override
    public Object getItem(int i) {
        return lstDataSrc.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CountryViewHolder itemViewHolder;
        if (view == null) {
            // xml --> java
            view = inflater.inflate(R.layout.country_item_layout, null);

            // java --> xml
            itemViewHolder = new CountryViewHolder();
            itemViewHolder.avatar = view.findViewById(R.id.imageViewFlag);
            itemViewHolder.name = view.findViewById(R.id.textViewCountryName);
            itemViewHolder.population = view.findViewById(R.id.textViewPopulation);

            view.setTag(itemViewHolder);
        } else {
            itemViewHolder = (CountryViewHolder)view.getTag();
        }

        // set
        Country countryItem = lstDataSrc.get(i);
        itemViewHolder.name.setText(countryItem.getName());
        itemViewHolder.population.setText("Population: " + countryItem.getPopulation());

        int flagId = getImg(countryItem.getAvatar());

        itemViewHolder.avatar.setImageResource(flagId);
        return view;
    }
    public int getImg(String resName) {
        String packageName = context.getPackageName();
        int imgId = context.getResources().getIdentifier(resName, "mipmap", packageName);
        return imgId;
    }
}
