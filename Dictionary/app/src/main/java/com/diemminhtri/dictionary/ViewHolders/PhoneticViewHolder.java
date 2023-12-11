package com.diemminhtri.dictionary.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diemminhtri.dictionary.R;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_phonetic;
    public ImageButton imgBtn_audio;
    public PhoneticViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_phonetic = itemView.findViewById(R.id.tv_phonetic);
        imgBtn_audio = itemView.findViewById(R.id.imgBtn_audio);
    }
}
