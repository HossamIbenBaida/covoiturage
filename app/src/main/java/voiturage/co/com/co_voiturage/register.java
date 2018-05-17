package voiturage.co.com.co_voiturage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText fname , lname , userr , email , pass , tel , addresse ;
    private Button register ;
    private FirebaseAuth.AuthStateListener firebaseAuthListener ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_register);
        register=(Button)findViewById(R.id.sauvgarde) ;
        fname = (EditText)findViewById(R.id.nbrPlace);
        lname=(EditText)findViewById(R.id.villeD);
        userr = (EditText)findViewById(R.id.villeA);
        email=(EditText)findViewById(R.id.email);
        pass = (EditText)findViewById(R.id.password);
        tel=(EditText)findViewById(R.id.tel);
        addresse=(EditText)findViewById(R.id.addresse);

        firebaseAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser() ;
                if (user!=null){
                    Intent intent = new Intent(register.this , Annoces.class);
                    startActivity(intent);
                    finish();
                    return;

                }
            }
        };


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
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
    public void Register() {

        mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(),pass.getText().toString()).addOnCompleteListener(register.this ,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Users user = new Users(fname.getText().toString(),lname.getText().toString(),userr.getText().toString(),email.getText().toString(),tel.getText().toString(),addresse.getText().toString());
                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){

                                Toast.makeText(register.this, "register successful", Toast.LENGTH_SHORT).show();

                            }else{

                                Toast.makeText(register.this, "data addition failed", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                    Toast.makeText(register.this, "register nice", Toast.LENGTH_SHORT).show();

                }
                else {

                    Toast.makeText(register.this, "register failed", Toast.LENGTH_SHORT).show();
                    Log.e("errorr", "onComplete: Failed=" + task.getException().getMessage());
                }
            }
        });


    }
}
