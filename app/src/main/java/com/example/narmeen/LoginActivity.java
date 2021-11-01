package com.example.narmeen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnLongClickListener, DialogInterface.OnClickListener {
    private static final String TAG = "FIREBASE";
    private EditText editTextName , editTextPassword,editTextTextEmailAddress;
    private Button buttonLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        //returns a reference to the instance of the project firebase
        getSupportActionBar().hide();
        //findViewById returns reference to the object with the specified id
        editTextName= findViewById(R.id.editTextTextPersonName);
        editTextPassword= findViewById(R.id.editTextTextPassword);
        buttonLogin=findViewById(R.id.buttonLogin);
        //sets the required button to response long click, otherwise it won't
        buttonLogin.setOnLongClickListener(this);

        String name= editTextName.getText().toString();

        SharedPreferences sp = getSharedPreferences("settings",MODE_PRIVATE);
        String email= sp.getString("email","");
        String password= sp.getString("password","");

        if(!email.equals("")&&!password.equals("")){
            editTextName.setText(email);
            editTextPassword.setText(password);
        }
    }

    public void login(View view) {

        Intent intent = new Intent(this,Welcome.class); // this allows us move to another page(welcome)
        if(!editTextName.getText().toString().equals("")&&
                editTextTextEmailAddress.getText().toString().contains("@"))
        {
            SharedPreferences sp = getSharedPreferences("settings",MODE_PRIVATE);
            //open editor for editing
            SharedPreferences.Editor editor= sp.edit();
            //write the wanted settings
            editor.putString("email",editTextName.getText().toString());
            editor.putString("password",editTextPassword.getText().toString());

            //save and close file
            editor.commit();

            intent.putExtra("name", editTextName.getText().toString());
            login(editTextName.getText().toString(),editTextPassword.getText().toString());
            //startActivity(intent);

        }// this method is inherited which is how we are able to implement it
    }

    public void signup(View view) {
        Intent intent = new Intent(this,SignupActivity.class);
        startActivity(intent);
    }
    //clears the email and password input on long click by user
    @Override
    public boolean onLongClick(View view) {
        editTextName.setText("");
        editTextPassword.setText("");
        return true;
    }
    
 public void login (String email,String password){
     mAuth.signInWithEmailAndPassword(email, password)
             .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if (task.isSuccessful()) {
                         // Sign in success, update UI with the signed-in user's information
                         Log.d(TAG, "signInWithEmail:success");
                         FirebaseUser user = mAuth.getCurrentUser();
                         Intent i=new Intent(LoginActivity.this,Welcome.class);
                     } else {
                         // If sign in fails, display a message to the user.
                         Log.w(TAG, "signInWithEmail:failure", task.getException());
                         Toast.makeText(LoginActivity.this, "Authentication failed.",
                                 Toast.LENGTH_SHORT).show();

                     }

                     // ...
                 }
             });
 }
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

    }
    public void onBackPressed(){

    }

}