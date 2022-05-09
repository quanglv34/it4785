package com.example.it4785.week1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.it4785.R;

public class MainActivity extends AppCompatActivity {

    final String MYTAG = "quanglv";
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_02);
        mShowCount = (TextView) findViewById(R.id.show_count);

        Button btnToast = new Button(this);
        btnToast = findViewById(R.id.btn_toast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast newToast = Toast.makeText(MainActivity.this, R.string.btn_toast, Toast.LENGTH_LONG);
                newToast.show();

                Log.d(MYTAG, "User touch btn_toast button");
            }
        });

        Button btnCount = new Button(this);
        btnCount = findViewById(R.id.btn_count);
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countUp();
            }
        });
    }

    public void countUp() {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}