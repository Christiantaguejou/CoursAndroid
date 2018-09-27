package com.example.chris.sharemovie;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chris.sharemovie.adapters.CommentsAdapter;
import com.example.chris.sharemovie.models.Comment;
import com.example.chris.sharemovie.models.Movie;
import com.example.chris.sharemovie.models.MoviesManager;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout iconLike;
    private LinearLayout iconComment;
    private LinearLayout commentsList;
    private EditText editTextComment;
    private ImageView iconSend;
    private LinearLayout iconBack;
    private ImageView iconClose;
    private TextView backTitle;
    private ScrollView scrollBar;
    private RecyclerView recyclerView;
    private List<Comment> comments;
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.comments = new ArrayList<>();
        this.initId();
        this.initActivity();
        
    }

    protected void initActivity() {
        Intent intent = getIntent();
        movie = MoviesManager.getInstance().getMovieById(intent.getIntExtra("movie",0));

        ImageView moviePicture = findViewById(R.id.moviePicture);
        moviePicture.setImageDrawable(getResources().getDrawable(movie.getImage()));

        TextView movieTitle = findViewById(R.id.movieTitle);
        movieTitle.setText(movie.getTitle());

        TextView originalTitle = findViewById(R.id.movieOriginalTitle);
        originalTitle.setText(movie.getOriginalTitle());

        TextView movieDescription = findViewById(R.id.movieDescription);
        movieDescription.setText(movie.getDescrpition());

        TextView movieKeyWords = findViewById(R.id.movieKeyWords);
        movieKeyWords.setText(movie.getKeyword());

    }

    protected void initId() {

        //icone
        iconLike = findViewById(R.id.btnLike);
        iconLike.setOnClickListener(onClickLike);

        iconComment = findViewById(R.id.btnComment);
        iconComment.setOnClickListener(onClickComment);

        iconSend = findViewById(R.id.iconSend);
        iconSend.setOnClickListener(onClickSend);

        iconClose = findViewById(R.id.iconClose);
        iconClose.setOnClickListener(onClickListeMovie);

        iconBack = findViewById(R.id.iconBack);
        iconBack.setOnClickListener(onClickClose);

        editTextComment = findViewById(R.id.editTextComment);

        scrollBar = findViewById(R.id.scrollBar);

        //header
        backTitle = findViewById(R.id.backTitle);

        //comments
        commentsList = findViewById(R.id.commentList);
        recyclerView = findViewById(R.id.comment_recycler_view);

        findViewById(R.id.btnShare).setOnClickListener(v -> {
            //TODO share
            MoviesManager.getInstance().setContext(this.getApplicationContext());
            MoviesManager.getInstance().setup();
            Uri imageUri = Uri.parse("android.resource://" + getPackageName()
                            + "/drawable/" + movie.getImage());
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("image/*");
            shareIntent.putExtra(Intent.EXTRA_TEXT, movie.getTitle());
            shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(shareIntent, "Share to :"));
            //Work with messages (my app is Textra) but not with Messenger
        });

    }

    View.OnClickListener onClickLike = v -> {
        LinearLayout linearLayout = (LinearLayout) v;
        TextView textView = (TextView) linearLayout.getChildAt(1);

        if(textView.getCurrentTextColor() == getResources().getColor(R.color.colorText)) {
            textView.setTextColor(getResources().getColor(R.color.colorButton));
            ImageView imageView = (ImageView) linearLayout.getChildAt(0);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_thumb_up_yellow_24dp));

            Drawable roundedButton = v.getBackground();
            roundedButton.setColorFilter(getResources().getColor(R.color.colorLikeClick), PorterDuff.Mode.SRC_OVER);
        }
        else {
            textView.setTextColor(getResources().getColor(R.color.colorText));
            ImageView imageView = (ImageView) linearLayout.getChildAt(0);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_thumb_up_white_24dp));

            Drawable roundedButton = v.getBackground();
            roundedButton.setColorFilter(getResources().getColor(R.color.colorButton), PorterDuff.Mode.SRC_OVER);
        }
    };

    View.OnClickListener onClickComment = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!editTextComment.hasFocus()) {
                editTextComment.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editTextComment, InputMethodManager.SHOW_IMPLICIT);
            }
            else {
                editTextComment.clearFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editTextComment.getWindowToken(), 0);
            }
            scrollBar.fullScroll(View.FOCUS_DOWN);

        }
    };

    View.OnClickListener onClickSend = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(!editTextComment.getText().toString().isEmpty()) {

                LinearLayout.LayoutParams paramsTextView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                paramsTextView.setMargins(30,30,5,30);

                MainActivity.this.refreshComment(editTextComment.getText().toString());
                editTextComment.getText().clear();
                editTextComment.clearFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editTextComment.getWindowToken(), 0);

                scrollBar.fullScroll(View.FOCUS_DOWN);
            }
        }
    };

    public void refreshComment(String comment) {
        if(this.recyclerView.getVisibility() != View.VISIBLE) {
            this.recyclerView.setVisibility(View.VISIBLE);
        }

        TextView defaultComment = findViewById(R.id.defaultComment);
        commentsList.removeView(defaultComment);
        this.comments.add(new Comment(comment));

        CommentsAdapter commentsAdapter = new CommentsAdapter();
        commentsAdapter.setComments(comments);
        this.recyclerView.setAdapter(commentsAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    View.OnClickListener onClickClose = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            MainActivity.this.finish();
            Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener onClickListeMovie = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            MainActivity.this.finish();
            Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
            startActivity(intent);
        }
    };


}
