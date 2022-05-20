package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        RadioButton buttonSameDay = findViewById(R.id.sameday);
        buttonSameDay.setChecked(true);
        buttonSameDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(view);
            }
        });

        RadioButton buttonNextDay = findViewById(R.id.nextday);
        buttonNextDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(view);
            }
        });

        RadioButton buttonPickUp = findViewById(R.id.pickup);
        buttonPickUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(view);
            }
        });

        SpinnerHandler spinnerHandler = new SpinnerHandler();
        Spinner spinner = findViewById(R.id.phone_type_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(spinnerHandler);
        }

        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_phone_type_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
        // ... End of onCreate code ...
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                // Do nothing.
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    private class SpinnerHandler implements AdapterView.OnItemSelectedListener {
        public SpinnerHandler() {

        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
            ((TextView) adapterView.getChildAt(0)).setTextSize(10);
            String spinnerLabel = adapterView.getItemAtPosition(position).toString();
            displayToast(spinnerLabel);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


}