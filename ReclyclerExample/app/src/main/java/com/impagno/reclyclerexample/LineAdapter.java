package com.impagno.reclyclerexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.impagno.reclyclerexample.model.Produto;
import java.util.List;
import java.util.Locale;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {
    private List<Produto> produtos;

    public LineAdapter(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public LineHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new LineHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_line_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LineHolder lineHolder, int i) {
        lineHolder.title.setText(String.format(Locale.getDefault(), "%s: %d",
                produtos.get(i).getNome(), produtos.get(i).getQtde()));
    }

    @Override
    public int getItemCount() {
        return this.produtos != null ? produtos.size() : 0;
    }
}
