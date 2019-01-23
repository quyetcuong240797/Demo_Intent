package com.example.demo_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {
    private String mFirstName;
    private String mLastName;
    private TextView mTextView;
    private Button mButtonBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initData();
        mButtonBack = (Button) findViewById(R.id.button_back);
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void finish() {
        Intent data = new Intent();
        data.putExtra("feedback", "I'm" + " " + mFirstName + " " + "Hi!");
        this.setResult(Activity.RESULT_OK, data);
        super.finish();
    }


    private void initData() {
        final Intent intent = this.getIntent();
        mFirstName = intent.getStringExtra("firstName");
        mLastName = intent.getStringExtra("lastName");
        String greeting = "Hello" + " " + mFirstName + " " + mLastName;
        mTextView = (TextView) findViewById(R.id.text_view_receive_result);
        mTextView.setText(greeting);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
