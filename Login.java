package com.saurabh.searche;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText logemails,logpasswords;
    Button btn_logins;
    ImageView image1,image2,image3;
    TextInputLayout t1;
    EditText mEmail, mPassword;
    Button mLoginBtn;
    TextView mCreateBtn, forgotTextLink;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    String useerId;
    FirebaseUser user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        //logemails = (EditText)findViewById(R.id.logemail);
        //logpasswords = (EditText)findViewById(R.id.logPassword);
        //btn_logins = (Button)findViewById(R.id.btn_login);
        image1 = (ImageView)findViewById(R.id.logo_Image);
        image2 = (ImageView)findViewById(R.id.logo_Image2);
        image3 = (ImageView)findViewById(R.id.profile);


        mEmail = findViewById(R.id.logemail);
        mPassword= (EditText)findViewById(R.id.logPassword);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.btn_login);
        mCreateBtn = findViewById(R.id.createText);
        forgotTextLink = findViewById(R.id.forgotPassword);

        /*if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }*/


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is Required.");
                    return;
                }

                if (password.length() < 6) {
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // authenticate the user
                //userId = fAuth.getCurrentUser().getUid();
                user = fAuth.getCurrentUser();
                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            if(user.isEmailVerified()){
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();}
                            else Toast.makeText(getApplicationContext(),"Please verify email",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Login.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });

            }
        });

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Hi", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this,Register.class);
                Pair[] pairs =new Pair[5];
                pairs[0] = new Pair<View,String>(image1,"logo_Image");
                pairs[1] = new Pair<View,String>(image2,"logo_Image2");
                pairs[2] = new Pair<View,String>(image3,"profile_Image");
                pairs[3] = new Pair<View,String>(mEmail,"email_Image2");
                //pairs[4] = new Pair<View,String>(mPassword,"password_Image");
                pairs[4] = new Pair<View,String>(mLoginBtn,"btn_Image");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs[4]);
                startActivity(intent,options.toBundle());
                finish();
                //startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

        forgotTextLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText resetMail = new EditText(v.getContext());
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Forgot Password ?");
                passwordResetDialog.setIcon(R.drawable.forgot);
                passwordResetDialog.setMessage("Enter Your Email To Receive Reset Link.");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extract the email and send reset link
                        String mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Login.this, "Reset Link Sent To Your Email.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this, "Error ! Reset Link is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog
                    }
                });

                passwordResetDialog.create().show();

            }
        });


    }

    /*public void onclick(View view) {
        Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Login.this,Register.class);
        Pair[] pairs =new Pair[6];
        pairs[0] = new Pair<View,String>(image1,"logo_Image");
        pairs[1] = new Pair<View,String>(image2,"logo_Image2");
        pairs[2] = new Pair<View,String>(image3,"profile_Image");
        pairs[3] = new Pair<View,String>(mEmail,"email_Image2");
        pairs[4] = new Pair<View,String>(mPassword,"password_Image");
        pairs[5] = new Pair<View,String>(mLoginBtn,"btn_Image");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
        startActivity(intent,options.toBundle());
        finish();
    }*/
}
