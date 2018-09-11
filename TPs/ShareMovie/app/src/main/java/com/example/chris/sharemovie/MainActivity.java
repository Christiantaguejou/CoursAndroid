package com.example.chris.sharemovie;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

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
            Drawable roundedButton = v.getBackground();
            roundedButton.setColorFilter(getResources().getColor(R.color.colorLikeClick), PorterDuff.Mode.SRC_OVER);
        }
    };

}
