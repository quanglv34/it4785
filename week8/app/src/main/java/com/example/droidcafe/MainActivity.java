package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView buttonDonut = findViewById(R.id.image_donut);
        buttonDonut.setClickable(true);
        buttonDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDonutOrder(view);
            }
        });

        ImageView buttonFroyo = findViewById(R.id.image_froyo);
        buttonFroyo.setClickable(true);
        buttonFroyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFroyoOrder(view);
            }
        });

        ImageView buttonIcecream = findViewById(R.id.image_icecream);
        buttonIcecream.setClickable(true);
        buttonIcecream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showIceCreamOrder(view);
            }
        });

        FloatingActionButton fab = findViewById(R.id.button_shopping_cart);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        OrderActivity.class);
                startActivity(intent);
            }
        });
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(View view) {
        displayToast(getString(R.string.donut_order_message));
    }

    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamOrder(View view) {
        displayToast(getString(R.string.ice_cream_order_message));
    }

    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        displayToast(getString(R.string.froyo_order_message));
    }
}