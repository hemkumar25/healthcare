package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername, edEmail, edPassword, edConfirmP;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextRegUsername);
        edEmail = findViewById(R.id.editTextRegEmail);
        edPassword =findViewById(R.id.editTextRegPassword);
        edConfirmP = findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.buttonBookApp);
        tv = findViewById(R.id.textViewExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String ConfirmPassword = edConfirmP.getText().toString();
                Database db = new Database(getApplicationContext(),"healthcare",null,1);

                if( username.length() == 0 || email.length() == 0 || password.length() == 0 || ConfirmPassword.length() == 0){
                    Toast.makeText(getApplicationContext(), "please fill all details", Toast.LENGTH_SHORT).show();
                }else{
                    if(password.compareTo(ConfirmPassword)==0){
                        if(isValid(password)){
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(), "Record inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }else{
                            Toast.makeText(getApplicationContext(), "Password must contain one capital letter , digit, at least 1 special character", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Password didn't match with confirm password", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


    }
    public boolean isValid(String passwordhere){
        int f1=0, f2=0;
        if(passwordhere.length()<8){
            return false;
        }else{
            for(int p=0; p<passwordhere.length();p++){
                if(Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for (int r=0; r<passwordhere.length();r++){
                if(Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
//            for (int s=0; s<passwordhere.length();s++){
//                char c = passwordhere.charAt(s);
//                   int n = Integer.parseInt(c);
//                if(c>=33&&c<46||c==64){
//                    f1=1;
//                }
//            }
            if(f1==1 && f2==1)
                return true;
            return false;
        }
    }
}
