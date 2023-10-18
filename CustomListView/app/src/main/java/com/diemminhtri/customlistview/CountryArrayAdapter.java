package com.diemminhtri.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CountryArrayAdapter extends BaseAdapter {
    // Nguồn dữ liệu
    // class attributes
    private List<Country> lstDataSource;
    private LayoutInflater inflater;
    private Context context;

    // constructor


    public CountryArrayAdapter(List<Country> lstDataSource, Context context) {
        this.lstDataSource = lstDataSource;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    // inner class
    class CountryItemViewHolder { // mapping from customize item xml layout
        ImageView flagView;
        TextView countryNameView;
        TextView populationView;
    }

    @Override
    public int getCount() {
        return lstDataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return lstDataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CountryItemViewHolder itemViewHolder;
        if (view == null) {
            // xml item view --> Java item
            view = inflater.inflate(R.layout.country_item_layout, null);
            // get Ref: Java --> XML
            itemViewHolder = new CountryItemViewHolder();
            itemViewHolder.flagView = view.findViewById(R.id.imageViewFlag);
            itemViewHolder.countryNameView = view.findViewById(R.id.textViewCountryName);
            itemViewHolder.populationView = view.findViewById(R.id.textViewPopulation);
            //
            view.setTag(itemViewHolder);
        } else {
            itemViewHolder = (CountryItemViewHolder)view.getTag();
        }
        // Set items' data
        Country countryItem = lstDataSource.get(i);
        itemViewHolder.countryNameView.setText(countryItem.getCountryName());
        itemViewHolder.populationView.setText("Population: " + countryItem.getPopulation());

        // image data, need your own function
        int flagID = getImgIDResName(countryItem.getCountryFlag());
        itemViewHolder.flagView.setImageResource(flagID);

        return view;
    } // end of getView
    // My own function for reading image ID from filename
    public int getImgIDResName(String resName) {
        String packageName = context.getPackageName();
        int imgId = context.getResources().getIdentifier(resName, "mipmap", packageName);
        return imgId;
    }

}
