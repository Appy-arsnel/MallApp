package com.example.mallapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.content.Intent;
import android.media.MediaParser;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private Button login;
    private EditText password;
    private LoginButton loginButton;
    private CallbackManager mCallbackManager;
    FirebaseAuth firebaseAuth;
  private Button googlereg;
private FirebaseAuth.AuthStateListener authStateListener;

    private static final String TAG = "FacebookLogin";

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://mall-app-8b01d-default-rtdb.asia-southeast1.firebasedatabase.app/");

    private DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);


        FacebookSdk.sdkInitialize(getApplicationContext());


        firebaseAuth=FirebaseAuth.getInstance();
        loginButton=findViewById(R.id.login_button);
        email= findViewById(R.id.editTextEmail);
        password= findViewById(R.id.editTextPassword);
       // googlereg=findViewById(R.id.);

        login=findViewById(R.id.cirLoginButton);

        reff=firebaseDatabase.getReference();
        normalLogin();
        register();
        facebookLogins();
        //googlesignin();
    }

    /*private void googlesignin() {
        googlereg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(LoginActivity.this,GoogleSignInActivity.class));
            }
        });
    }*/



    private void register() {
        final TextView Register= findViewById(R.id.Registerid);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),RegistrationActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
            }
        });
    }

    private void normalLogin()
    {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String inputemail= email.getText().toString().trim();
                String inputPassword = password.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(inputemail,inputPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Toast.makeText(LoginActivity.this, "Successful Log in", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));

                    }
                });

            }

        });
    }
    private void facebookLogins(){

        loginButton.bringToFront();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "clicked",
                        Toast.LENGTH_SHORT).show();
                mCallbackManager = CallbackManager.Factory.create();
                loginButton.setReadPermissions("email", "public_profile");
                loginButton.registerCallback(mCallbackManager,
                        new FacebookCallback<LoginResult>() {
                            @Override
                            public void onSuccess(LoginResult loginResult) {
                                Log.d(TAG, "onSuccess" + loginResult);
                                handleFacebookAccessToken(loginResult.getAccessToken());
                                Toast.makeText(LoginActivity.this, "Successful Log in", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));

                            }

                            @Override
                            public void onCancel() {
                                Log.d(TAG,"onCancel");
                                Toast.makeText(LoginActivity.this, "Successful ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(FacebookException exception) {
                                Log.d(TAG,"onError"+ exception);
                                Toast.makeText(LoginActivity.this, " Log in", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);


    }




    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed:Same email found",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }
    private void updateUI(FirebaseUser user) {

        String name;
        if (user != null) {
            // Name, email address, and profile photo Url

             name = user.getDisplayName();
            String email = user.getEmail();
            String uid = user.getUid();
            String rmobileno= user.getPhoneNumber();
            user users = new user(name, email, rmobileno);
            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

                reff.child("User").child(uid).setValue(users);


            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.

        }


    }

    @Override
    protected void onStart() {
        super.onStart();
       FirebaseUser  userz=firebaseAuth.getCurrentUser();
        if(userz!=null)
            startActivity(new Intent(LoginActivity.this,MainActivity.class));

    }


}


