package com.diemminhtri.dictionary;

import android.content.Intent;
import android.media.MediaPlayer;
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

public class Login extends AppCompatActivity {

    TextInputEditText edtEmail, edtPass;
    Button btnLogin;
    ProgressBar progressBar;
    TextView regNow;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();

        // Kiểm tra xem người dùng đã đăng nhập chưa và cập nhật giao diện người dùng tương ứng.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null){
            // Nếu người dùng đã đăng nhập, hiển thị thông báo đăng nhập thành công.
            Toast.makeText(Login.this, "Login successful.", Toast.LENGTH_SHORT).show();

            // Chuyển hướng người dùng đến màn hình từ điển chính.
            Intent intent = new Intent(getApplicationContext(), MainDictionary.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.email);
        edtPass = findViewById(R.id.pass);
        btnLogin = findViewById(R.id.btn_login);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        regNow = findViewById(R.id.regNow);

        regNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playHelloSound();
                progressBar.setVisibility(View.VISIBLE);
                String email, pass;
                email = String.valueOf(edtEmail.getText());
                pass = String.valueOf(edtPass.getText());

                // nếu bỏ trống ô email và mật khẩu thì sẽ báo lỗi
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Login.this,"Please enter email!!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(Login.this,"Please enter password!!", Toast.LENGTH_LONG).show();
                    return;
                }

                // đăng nhập bằng email và mật khẩu
                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // Ẩn thanh tiến trình sau khi quá trình đăng nhập hoàn thành
                                progressBar.setVisibility(View.GONE);

                                if (task.isSuccessful()) {
                                    // Nếu quá trình đăng nhập thành công
                                    Toast.makeText(Login.this, "Login successful.", Toast.LENGTH_SHORT).show();

                                    // Chuyển hướng người dùng đến màn hình chính
                                    Intent intent = new Intent(getApplicationContext(), MainDictionary.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // Nếu quá trình đăng nhập thất bại, hiển thị thông báo cho người dùng.
                                    Toast.makeText(Login.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

    }
    private void playHelloSound() {
        MediaPlayer hello = MediaPlayer.create(Login.this, R.raw.hello);
        if (hello != null) {
            hello.start();
            hello.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    // Giải phóng tài nguyên khi âm thanh hoàn thành
                    mp.release();
                }
            });
        }
    }
}