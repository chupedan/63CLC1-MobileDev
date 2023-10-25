package com.diemminhtri.a63131545_thigiuaky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlayerArrayAdapter extends BaseAdapter {
    private List<Player> lstDataSrc;
    private LayoutInflater inflater;
    private Context context;

    // constructor

    public PlayerArrayAdapter(List<Player> lstDataSrc, Context context) {
        this.lstDataSrc = lstDataSrc;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    // inner class
    public class PlayerItemViewHolder {
        ImageView avatar;
        TextView playerName;
        TextView playerScores;
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
        PlayerItemViewHolder itemViewHolder;

        if (view == null) {
            // xml item view --> Java item
            view = inflater.inflate(R.layout.player_item_layout, null);

            // Java --> xml item
            itemViewHolder = new PlayerItemViewHolder();
            itemViewHolder.avatar = view.findViewById(R.id.imageViewAvatar);
            itemViewHolder.playerName = view.findViewById(R.id.textViewNamePlayer);
            itemViewHolder.playerScores = view.findViewById(R.id.textViewScores);

            view.setTag(itemViewHolder);
        } else {
            itemViewHolder = (PlayerItemViewHolder)view.getTag();
        }

        //

        Player playerItem = lstDataSrc.get(i);
        itemViewHolder.playerName.setText(playerItem.getPlayerName());
        itemViewHolder.playerScores.setText("Scores: " + playerItem.getPlayerScores());

        // set img
        int avtId = getImg(playerItem.getPlayerAvatar());
        itemViewHolder.avatar.setImageResource(avtId);
        return view;
    }
    public int getImg(String resName) {
        String packageName = context.getPackageName();
        int imgId = context.getResources().getIdentifier(resName, "mipmap", packageName);
        return imgId;
    }
}

