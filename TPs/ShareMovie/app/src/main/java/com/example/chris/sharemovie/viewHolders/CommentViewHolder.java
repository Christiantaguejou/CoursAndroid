package com.example.chris.sharemovie.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chris.sharemovie.R;
import com.example.chris.sharemovie.models.Comment;

public class CommentViewHolder extends BaseViewHolder{

    private TextView pseudoTextView;
    private TextView commentTextView;

    public CommentViewHolder(@NonNull View itemView) {
        super(itemView);
        this.pseudoTextView = itemView.findViewById(R.id.pseudo);
        this.commentTextView = itemView.findViewById(R.id.textComment);
    }

    @Override
    public void layoutForObject(Object object) {
        super.layoutForObject(object);

        Comment comment = (Comment) object;
        if(comment.getPseudo() != null) {
            if(pseudoTextView != null){
                pseudoTextView.setText(comment.getPseudo());
            }
        }
        if(comment.getComment() != null) {
            if(commentTextView != null){
                commentTextView.setText(comment.getComment());
            }
        }
    }
}
