package com.example.biometricauthenticationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    private Executor executor;
    private Button button;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView3);
        textView = findViewById(R.id.textViews);
        button = findViewById(R.id.logout);
        executor = ContextCompat.getMainExecutor(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("serverSettings").child("message").setValue("No");
                moveTaskToBack(true);
                finishAndRemoveTask();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {

            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                databaseReference.child("serverSettings").child("message").setValue("No");
                textView.setText("?????? ??????????????????");
                imageView.setImageResource(R.drawable.lock);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                databaseReference.child("serverSettings").child("message").setValue("Ok");
                textView.setText("????????????!");
                imageView.setImageResource(R.drawable.unlock);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                databaseReference.child("serverSettings").child("message").setValue("No");
                textView.setText("????????????");
                imageView.setImageResource(R.drawable.lock);
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Programmer World Authentication")
                .setNegativeButtonText("Cancel/ Use Password")
                .setConfirmationRequired(false)
                .build();
    }

    public void buttonAuthenticate(View view){
        BiometricManager biometricManager = BiometricManager.from(this);
        roblox msg = new roblox();
        if (biometricManager.canAuthenticate() != BiometricManager.BIOMETRIC_SUCCESS){
            textView.setText("???????????? ?????? ???????????????");
            return;
        }
        biometricPrompt.authenticate(promptInfo);
    }
}