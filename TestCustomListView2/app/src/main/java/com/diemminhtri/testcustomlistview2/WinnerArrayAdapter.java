package com.diemminhtri.testcustomlistview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class WinnerArrayAdapter extends BaseAdapter {
    private List<Winner> lstDataSrc;
    private LayoutInflater inflater;
    private Context context;

    public WinnerArrayAdapter(List<Winner> lstDataSrc, Context context) {
        this.lstDataSrc = lstDataSrc;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    // view holder
    public class WinnerItemViewHolder {
        ImageView avatar;
        TextView name, prize;
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
    public View getView(int i, View v, ViewGroup viewGroup) {
        WinnerItemViewHolder itemViewHolder;

        if (v == null) {
            // xml -> java
            v = inflater.inflate(R.layout.trung_thuong_item_layout, null);

            // java -> xml
            itemViewHolder = new WinnerItemViewHolder();
            itemViewHolder.avatar = v.findViewById(R.id.imageViewAvatar);
            itemViewHolder.name = v.findViewById(R.id.textViewName);
            itemViewHolder.prize = v.findViewById(R.id.textViewPrize);

            v.setTag(itemViewHolder);
        } else {
            itemViewHolder = (WinnerItemViewHolder)v.getTag();
        }

        Winner winnerItem = lstDataSrc.get(i);
        itemViewHolder.name.setText(winnerItem.getName());
        itemViewHolder.prize.setText("Prize: "  + winnerItem.getPrize() + "$");

        // set img
        int avtId = getImg(winnerItem.getAvatar());
        itemViewHolder.avatar.setImageResource(avtId);
        return v;
    }
    public int getImg(String resName) {
        String pkgName = context.getPackageName();
        int imgId = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        return imgId;
    }
}
