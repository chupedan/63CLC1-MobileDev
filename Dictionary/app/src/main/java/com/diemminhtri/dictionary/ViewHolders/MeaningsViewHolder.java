package com.diemminhtri.dictionary.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diemminhtri.dictionary.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {
    TextView tv_partOfSpeech;
    RecyclerView recycler_definitions;
    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_partOfSpeech = itemView.findViewById(R.id.tv_partOfSpeech);
        recycler_definitions = itemView.findViewById(R.id.recycler_definitions);
    }
}
