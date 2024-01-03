package com.diemminhtri.dictionary;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    TextInputEditText edtEmail, edtPass;
    Button btnReg;
    ProgressBar progressBar;
    TextView loginNow;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Kiểm tra xem người dùng đã đăng nhập chưa và cập nhật giao diện người dùng tương ứng.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null){
            // Nếu người dùng đã đăng nhập, hiển thị thông báo đăng nhập thành công.
            Toast.makeText(Register.this, "Login successful.", Toast.LENGTH_SHORT).show();

            // Chuyển hướng người dùng đến màn hình từ chính
            Intent intent = new Intent(getApplicationContext(), MainDictionary.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtEmail = findViewById(R.id.email);
        edtPass = findViewById(R.id.password);
        btnReg = findViewById(R.id.btn_register);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        loginNow = findViewById(R.id.loginNow);

        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email, pass;
                email = String.valueOf(edtEmail.getText());
                pass = String.valueOf(edtPass.getText());

                // nếu bỏ trống ô email và mật khẩu thì sẽ báo lỗi
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Register.this,"Please enter email!!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(Register.this,"Please enter password!!", Toast.LENGTH_LONG).show();
                    return;
                }

                // tạo tài khoản bằng email và mật khẩu
                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // Ẩn thanh tiến trình sau khi quá trình đăng ký hoàn thành
                                progressBar.setVisibility(View.GONE);

                                if (task.isSuccessful()) {
                                    // Nếu quá trình đăng ký thành công
                                    Toast.makeText(Register.this, "Account created", Toast.LENGTH_SHORT).show();

                                    // Chuyển hướng người dùng đến màn hình đăng nhập
                                    Intent intent = new Intent(getApplicationContext(), Login.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // Nếu quá trình đăng ký thất bại, thông báo cho người dùng
                                    Toast.makeText(Register.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    }
}