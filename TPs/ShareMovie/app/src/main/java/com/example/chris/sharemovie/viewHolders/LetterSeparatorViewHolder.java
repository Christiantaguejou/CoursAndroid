package com.example.chris.sharemovie.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chris.sharemovie.R;
import com.example.chris.sharemovie.models.LetterSeparartor;

public class LetterSeparatorViewHolder extends BaseViewHolder {

    private TextView letterTextView;

    public LetterSeparatorViewHolder(@NonNull View itemView) {
        super(itemView);
        this.letterTextView = itemView.findViewById(R.id.letter_separator_TextView);
    }

    @Override
    public void layoutForObject(Object object) {
        super.layoutForObject(object);
        LetterSeparartor letterSeparartor = (LetterSeparartor) object;

        if(letterSeparartor.getLetter() != null) {
            if(letterTextView != null){
                letterTextView.setText(letterSeparartor.getLetter().toString());
            }
        }
    }
}
