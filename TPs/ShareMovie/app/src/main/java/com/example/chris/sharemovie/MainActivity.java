package com.example.chris.sharemovie;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout iconLike;
    LinearLayout iconComment;
    LinearLayout commentsList;
    EditText editTextComment;
    ImageView iconSend;
    ImageView iconBack;
    ImageView iconClose;
    TextView backTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconLike = findViewById(R.id.btnLike);
        iconLike.setOnClickListener(onClickLike);

        iconComment = findViewById(R.id.btnComment);
        iconComment.setOnClickListener(onClickComment);

        iconSend = findViewById(R.id.iconSend);
        iconSend.setOnClickListener(onClickSend);

        editTextComment = findViewById(R.id.editTextComment);

        commentsList = findViewById(R.id.commentList);

        iconBack = findViewById(R.id.iconBack);
        iconBack.setOnClickListener(onClickClose);

        backTitle = findViewById(R.id.backTitle);
        backTitle.setOnClickListener(onClickClose);

        iconClose = findViewById(R.id.iconClose);
        iconClose.setOnClickListener(onClickClose);

    }

    View.OnClickListener onClickLike = new View.OnClickListener(){
        public void onClick(View v){
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
        }
    };

    View.OnClickListener onClickSend = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        TextView defaultComment = findViewById(R.id.defaultComment);

        if(!editTextComment.getText().toString().isEmpty()) {
            commentsList.removeView(defaultComment);

            LinearLayout.LayoutParams paramsTextView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            paramsTextView.setMargins(30,10,10,10);

            TextView newComment = new TextView(MainActivity.this.getApplicationContext());
            newComment.setText(editTextComment.getText().toString());
            newComment.setLayoutParams(paramsTextView);
            newComment.setTextAppearance(R.style.commentStyle);

            View separator = new View(MainActivity.this.getApplicationContext(), null, R.style.separator);
            LinearLayout.LayoutParams paramsView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,1);
            separator.setLayoutParams(paramsView);

            commentsList.addView(newComment);
            commentsList.addView(separator);
            editTextComment.getText().clear();
            editTextComment.clearFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editTextComment.getWindowToken(), 0);
        }
        }
    };

    View.OnClickListener onClickClose = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MainActivity.this.finish();
        }
    };
}
