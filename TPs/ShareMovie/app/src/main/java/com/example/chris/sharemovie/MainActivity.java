package com.example.chris.sharemovie;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout iconLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconLike = findViewById(R.id.btnLike);
        iconLike.setOnClickListener(onClickLike);
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

}
