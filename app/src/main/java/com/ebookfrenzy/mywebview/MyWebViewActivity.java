package com.ebookfrenzy.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.net.URL;
import android.net.Uri;
import android.content.Intent;
import android.webkit.WebView;

public class MyWebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view);

        handleIntent();
    }

    private void handleIntent() {
      Intent intent = getIntent(); // getting the intent from com.ebookfrenzy.ImplicitIntent.ImplicitIntentActivity.java

      Uri data = intent.getData(); // getting the data from said intent

      URL url = null; // initializes the URL object as null

      try {
          url = new URL(data.getScheme(), // returns scheme
                  data.getHost(), // returns hostname
                  data.getPath()); // returns path
      } catch (Exception e) {
          e.printStackTrace(); // prints the stack trace of the exception
      }

      WebView webView = findViewById(R.id.webView1); // obtains a reference to the WebView in the UI
      webView.loadUrl(url.toString()); // loads the URL into the WebView and converts the URL into a string simultaneously

    }
}
