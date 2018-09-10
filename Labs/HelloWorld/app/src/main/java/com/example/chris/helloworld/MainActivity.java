package com.example.chris.helloworld;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnToast;
    Button btnLog;
    Button btnCustomToast;
    Button btnVibration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLog = findViewById(R.id.btnLog);
        btnLog.setOnClickListener(this);
        btnToast =  findViewById(R.id.btnToast);
        btnToast.setOnClickListener(this);
        btnCustomToast = findViewById(R.id.btnCustomToast);
        btnCustomToast.setOnClickListener(this);
        btnVibration = findViewById(R.id.btnVibration);
        btnVibration.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        System.out.println(view.toString());
        if(view.equals(btnLog)){
            Toast.makeText(this, "Bravo, vous avez un log" , Toast.LENGTH_SHORT).show();
        }
        else if(view.equals(btnToast)){
            Toast.makeText(this, "Coooool", Toast.LENGTH_SHORT).show();
        }
        else if(view.equals(btnCustomToast)){
            displayCustomToast();
        }
        else if(view.equals(btnVibration)){
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
            v.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));

        }
    }

    private void displayCustomToast() {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout_root));
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast");
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
