package com.example.demo_intent;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTexFirst, mEditeTextsecond;
    private TextView mTextView;
    private Button mButton;

    public static final int MY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEditTexFirst = (EditText) findViewById(R.id.edit_text_first);
        mEditeTextsecond = (EditText) findViewById(R.id.edit_text_second);
        mTextView = (TextView) findViewById(R.id.text_view);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = mEditTexFirst.getText().toString();
                String lastName = mEditeTextsecond.getText().toString();
                Intent intent = new Intent(MainActivity.this, GreetingActivity.class);
                intent.putExtra("firstName", firstName);
                intent.putExtra("lastName", lastName);
                startActivityForResult(intent, MY_REQUEST_CODE);
            }
        });
    }

    //khi greetingactivity hoan thanh
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            String feedBack = data.getStringExtra("feedback");
            mTextView.setText(feedBack);
        } else {
            mTextView.setText("?");
        }
    }
}
