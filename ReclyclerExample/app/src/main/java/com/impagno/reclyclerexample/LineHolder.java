package com.impagno.reclyclerexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public ImageButton moreButton;
    public ImageButton deleteButton;

    public LineHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.main_line_title);
        moreButton = itemView.findViewById(R.id.main_line_more);
        deleteButton = itemView.findViewById(R.id.main_line_delete);
    }
}
