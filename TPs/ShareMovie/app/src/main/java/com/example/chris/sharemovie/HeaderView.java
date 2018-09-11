package com.example.chris.sharemovie;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HeaderView extends LinearLayout {

    TextView mainTitleTextView;
    TextView backTitleTextView;
    public HeaderView(Context context) {
        super(context);
        this.initialize(context, null);
    }

    public HeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.initialize(context, attrs);
    }

    public HeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initialize(context, attrs);

    }

    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.initialize(context, attrs);
    }

    private void initialize(Context context, AttributeSet attrs) {
        inflate(context, R.layout.header_view, this);

        this.mainTitleTextView = findViewById(R.id.mainTitle);
        this.backTitleTextView = findViewById(R.id.backTitle);

        if(attrs != null){
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.HeaderView, 0,0);

            String mainTitle = array.getString(R.styleable.HeaderView_mainTitle);
            if(this.mainTitleTextView != null) {
                this.mainTitleTextView.setText(mainTitle);
            }

            String backTitle = array.getString(R.styleable.HeaderView_backTitle);
            if(this.backTitleTextView != null) {
                this.backTitleTextView.setText(backTitle);
            }
        }
    }
}
