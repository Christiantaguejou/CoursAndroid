package com.example.chris.sharemovie;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout iconLike;
    LinearLayout iconComment;
    EditText editTextComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconLike = findViewById(R.id.btnLike);
        iconLike.setOnClickListener(onClickLike);

        iconComment = findViewById(R.id.btnComment);
        iconComment.setOnClickListener(onClickComment);
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
            System.out.println("FOCUS");
            editTextComment = findViewById(R.id.editTextComment);

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
}
