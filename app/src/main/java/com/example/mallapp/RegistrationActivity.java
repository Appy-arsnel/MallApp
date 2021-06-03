package com.example.mallapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegistrationActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText mobileno;

    private EditText password;
    private Button btnRegister;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        changeStatusBarColor();
        name = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);
        mobileno = findViewById(R.id.editTextMobile);
        password = findViewById(R.id.editTextPassword);
        btnRegister = findViewById(R.id.cirRegisterButton);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rname = name.getText().toString();
                String remail = email.getText().toString();
                String rmobileno = mobileno.getText().toString();
                String rpas = password.getText().toString();
                user users = new user(rname, remail, rmobileno, rpas);
                reff = FirebaseDatabase.getInstance().getReference("Users");

                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                if (validate(remail, rpas)) {
                    firebaseAuth.createUserWithEmailAndPassword(remail, rpas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                if (user == null) {
                                    // No session user
                                    return;
                                }
                                String userId = user.getUid();
                                users.setName(rname);
                                users.setEmail(remail);
                                users.setMobileno(rmobileno);
                                users.setPassword(rpas);


                                reff.child(userId).setValue(users);

                                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                                Toast.makeText(RegistrationActivity.this, "Account created", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }

        });
    }


    private boolean validate(String email, String password) {
        if (email.isEmpty() || password.length() < 8) {
            Toast.makeText(this, "Please enter all details and Password should be of 8 characters or more", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }
}