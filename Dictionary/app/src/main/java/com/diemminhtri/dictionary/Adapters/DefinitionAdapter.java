package com.diemminhtri.dictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diemminhtri.dictionary.Modules.Definitions;
import com.diemminhtri.dictionary.R;
import com.diemminhtri.dictionary.ViewHolders.DefinitionViewHolder;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {
    private Context context;
    private List<Definitions> definitionsList;

    public DefinitionAdapter(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.definitions_list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int i) {
        holder.tv_definition.setText("Definition: " + definitionsList.get(i).getDefinition());
        holder.tv_example.setText("Example: " + definitionsList.get(i).getExample());
        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(definitionsList.get(i).getSynonyms());
        antonyms.append(definitionsList.get(i).getAntonyms());

        holder.tv_synonyms.setText(synonyms);
        holder.tv_antonyms.setText(antonyms);

        holder.tv_synonyms.setSelected(true);
        holder.tv_antonyms.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }
}
