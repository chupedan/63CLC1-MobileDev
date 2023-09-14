package com.diemminhtri.vidu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButtonSubmit;
    private TextView mTextViewResult;
    private EditText mEditTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addAction();
    }

    private void addAction() {
        mButtonSubmit.setOnClickListener(this);
    }

    private void initView() {
        mButtonSubmit = findViewById(R.id.button_submit); // R là trong res (resource)
        mTextViewResult = findViewById(R.id.textView_result);
        mEditTextInput = findViewById(R.id.edit_input);
    }

    @Override
    public void onClick(View view) {
        String input = mEditTextInput.getText().toString();
        mTextViewResult.setText(getResources().getString(R.string.messagge) + ' ' + input + '!' + getResources().getString(R.string.niceDay));
    }
}