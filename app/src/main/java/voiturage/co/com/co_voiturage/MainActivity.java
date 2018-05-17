package voiturage.co.com.co_voiturage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics ;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText email,pass ;
    private Button sign ;
    private FirebaseAnalytics mFirebaseAnalytics = null;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);
        sign =(Button)findViewById(R.id.signin);
        email =(EditText) findViewById(R.id.email);
        pass =(EditText) findViewById(R.id.password);
        firebaseAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser() ;
                if (user!=null){
                    Intent intent = new Intent(MainActivity.this , Annoces.class);
                    startActivity(intent);
                    finish();
                    return;

                }
            }
        };
         sign.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View view) {
             mAuth.signInWithEmailAndPassword(email.getText().toString().trim() , pass.getText().toString().trim()).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()) {
                         Toast.makeText(MainActivity.this, "login successful", Toast.LENGTH_SHORT).show();


                     }else{
                         Toast.makeText(MainActivity.this, "login not successful", Toast.LENGTH_SHORT).show();
                         Log.e("errorr", "onComplete: Failed=" + task.getException().getMessage());

                     }
                 }
             }) ;

             }
         });


    }
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthListener);
    }
    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthListener);
    }


    public void reg(View view) {

        Intent intent = new Intent(MainActivity.this , register.class);
        startActivity(intent);
    }
}
