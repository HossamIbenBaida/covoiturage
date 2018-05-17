package voiturage.co.com.co_voiturage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static voiturage.co.com.co_voiturage.listeAnnance.EXTRA_nbp;
import static voiturage.co.com.co_voiturage.listeAnnance.EXTRA_Date;
import static voiturage.co.com.co_voiturage.listeAnnance.EXTRA_HeurD;
import static voiturage.co.com.co_voiturage.listeAnnance.EXTRA_VilleD;
import static voiturage.co.com.co_voiturage.listeAnnance.EXTRA_villeA;

public class AnnanceDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annance_detail);
        Intent intent = getIntent();
        String villeD = intent.getStringExtra(EXTRA_VilleD);
        String villeA = intent.getStringExtra(EXTRA_villeA);
        String date = intent.getStringExtra(EXTRA_Date);
        String heur = intent.getStringExtra(EXTRA_HeurD);
        String nbpp = intent.getStringExtra(EXTRA_nbp);
        TextView villed = (TextView)findViewById(R.id.villd);
        TextView villa = (TextView)findViewById(R.id.villa);
        TextView dated   = (TextView)findViewById(R.id.datee);
        TextView heurr = (TextView)findViewById(R.id.heurr);
        TextView nbp = (TextView)findViewById(R.id.nbrp);

        villed.setText(villeD);
        villa.setText(villeA);
        dated.setText(date);
        heurr.setText(heur);
        nbp.setText(nbpp);




    }
}
