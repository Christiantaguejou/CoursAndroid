package com.example.chris.sharemovie.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chris.sharemovie.R;
import com.example.chris.sharemovie.models.LetterSeparartor;

public class LetterSeparatorViewHolder extends RecyclerView.ViewHolder {

    private TextView letterTextView;

    public LetterSeparatorViewHolder(@NonNull View itemView) {
        super(itemView);
        this.letterTextView = itemView.findViewById(R.id.letter_separator_TextView);
    }

    public void layoutForLetter (LetterSeparartor letterSeparartor) {
        if(letterSeparartor.getLetter() != null) {
            if(letterTextView != null){
                letterTextView.setText(letterSeparartor.getLetter().toString());
            }
        }
    }
}
