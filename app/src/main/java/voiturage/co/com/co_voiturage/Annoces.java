package voiturage.co.com.co_voiturage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Annoces extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annoces);
        firebaseAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser() ;
                if (user!=null){
                    Log.e("errorr", "user sign in");

                }else {


                    Intent intent = new Intent(Annoces.this , MainActivity.class);
                    startActivity(intent);

                }
            }
        };


    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthListener);
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(firebaseAuthListener != null) {
            mAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(Annoces.this, "log out successful", Toast.LENGTH_SHORT).show();

    }

    public void goF(View view) {

        Intent intent = new Intent(Annoces.this , DriverRider.class);
        startActivity(intent);

    }
}