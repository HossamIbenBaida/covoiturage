package voiturage.co.com.co_voiturage;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class New_offer extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText nbrPlace , villeDepart , villeDarriver , Date , heur ,min, addresseDapare ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_offer);
        nbrPlace=(EditText) findViewById(R.id.nbrPlace);
        villeDepart=(EditText)findViewById(R.id.villeD);
        villeDarriver=(EditText)findViewById(R.id.villeA);
        Date =(EditText)findViewById(R.id.date);
        heur=(EditText)findViewById(R.id.heur);
        min=(EditText)findViewById(R.id.min);
        addresseDapare=(EditText)findViewById(R.id.addresse);






    }

    public void sauvgarde(View view) {
      String  heurd = heur.getText().toString()+" "+min.getText().toString() ;
        classAnnance annance = new classAnnance(Integer.parseInt(nbrPlace.getText().toString()) ,villeDepart.getText().toString()
                                                 ,villeDarriver.getText().toString(),
                                                   Date.getText().toString() ,
                                                   heurd,
                                                 addresseDapare.getText().toString() );


        FirebaseDatabase.getInstance().getReference("Offer").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(annance).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){

                    Toast.makeText(New_offer.this, "register successful", Toast.LENGTH_SHORT).show();

                }else{

                    Toast.makeText(New_offer.this, "data addition failed", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
