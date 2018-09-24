package com.example.chris.sharemovie.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chris.sharemovie.R;
import com.example.chris.sharemovie.models.Comment;
import com.example.chris.sharemovie.viewHolders.CommentViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter {

    private List<Comment> comments = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_comment, viewGroup, false);
        CommentViewHolder vh = new CommentViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Comment currentComment = comments.get(i);
        if (viewHolder instanceof CommentViewHolder && currentComment != null) {
            CommentViewHolder categoryViewHolder = (CommentViewHolder) viewHolder;
            categoryViewHolder.layoutForObject(currentComment);
        }
    }

    @Override
    public int getItemCount() {
        if(comments != null){
            return comments.size();
        }
        return 0;
    }

    public void setComments(List<Comment> categories) {
        this.comments = categories;
    }
}
