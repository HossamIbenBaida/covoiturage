package voiturage.co.com.co_voiturage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DriverRider extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser() ;
                if (user!=null){
                    Log.e("errorr", "user sign in");

                }else {


                    Intent intent = new Intent(DriverRider.this , MainActivity.class);
                    startActivity(intent);

                }
            }
        };

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_rider);

    }

    public void logout(View view) {

        mAuth.signOut();
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

    public void newOffer(View view) {
        Intent intent = new Intent(DriverRider.this , New_offer.class);
        startActivity(intent);

    }

    public void listA(View view) {
        Intent intent = new Intent(DriverRider.this , listeAnnance.class);
        startActivity(intent);
    }
}
