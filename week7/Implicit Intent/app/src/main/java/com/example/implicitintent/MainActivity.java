package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText = findViewById(R.id.edittext_website);
        mLocationEditText = findViewById(R.id.edittext_location);
        mShareEditText = findViewById(R.id.edittext_sharetext);
    }

    public void shareText(View view) {
        String text = mShareEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(text)
                .startChooser();
    }

    public void openLocation(View view) {
        String location = mLocationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if(intent.resolveActivity((getPackageManager())) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntent", "Can't handle this!");
        }
    }

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if(intent.resolveActivity((getPackageManager())) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntent", "Can't handle this!");
        }
    }
}