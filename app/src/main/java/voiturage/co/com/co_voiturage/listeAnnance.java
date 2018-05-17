package voiturage.co.com.co_voiturage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.Query;




import java.util.ArrayList;
import java.util.List;


public class listeAnnance extends AppCompatActivity {
//    ListView list ;

    public static final String EXTRA_VilleD = "villed";
    public static final String EXTRA_villeA = "villea";
    public static final String EXTRA_Date = "date";
    public static final String EXTRA_HeurD = "heur";
    public static final String EXTRA_nbp = "nbp";

    FirebaseDatabase database ;
     DatabaseReference ref ;
    DatabaseReference ref2 ;

    //     ArrayAdapter<classAnnance>adapter;
//     ArrayList<classAnnance>List;
     classAnnance annance ;
    private RecyclerView recyclerView;
    private EditText villeD ;
    private EditText villeA ;
    private EditText Date ;
    private annanceAdapter adapter;
     private ArrayList<classAnnance> annanceList ;
    ImageButton search ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        annance = new classAnnance();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_annance);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        search =(ImageButton)findViewById(R.id.search) ;
        villeD = (EditText) findViewById(R.id.villeDD) ;
        villeA = (EditText) findViewById(R.id.villeA) ;
        Date = (EditText) findViewById(R.id.Date) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        annanceList = new ArrayList<classAnnance>() {
        };
        database=FirebaseDatabase.getInstance();
        ref=database.getReference().child("/Offer");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){

                    for(DataSnapshot annanceSnapshot : dataSnapshot.getChildren()){
                        classAnnance A = annanceSnapshot.getValue(classAnnance.class);
                        annanceList.add(A);

                    }


                    adapter = new annanceAdapter(listeAnnance.this, annanceList);
                    recyclerView.setAdapter(adapter);

                    Log.e("errorr", "onComplete: content=" + adapter.getItemCount());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });






//        List=new ArrayList<>();
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//         for(DataSnapshot ds :dataSnapshot.getChildren()){
//
//             annance = ds.getValue(classAnnance.class);
//             List.add(annance);
//         }
//         list.setAdapter(adapter);
//            }

//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//        adapter=new ArrayAdapter<classAnnance>(getApplicationContext(),R.layout.annance_detail ,R.id.annanceT,List);



    }

//    public void detail(View view) {
//
//        Toast.makeText(listeAnnance.this, "test ok ", Toast.LENGTH_SHORT).show();
//
//
//
//    }

    public void search(View view) {
        String ville =villeD.getText().toString();
        String villea = villeA.getText().toString();
        String date = Date.getText().toString();
        ref2=FirebaseDatabase.getInstance().getReference().child("Offer");
        Query query =  ref2.orderByChild("villeDepart").startAt(ville).endAt(ville+" ");
        Log.e("errorr", "onComplete: content=" + query.toString()+ ville + " "+ villea +" "+date);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){

                    annanceList.clear();
                    for(DataSnapshot annanceSnapshot : dataSnapshot.getChildren()){
                        classAnnance A = annanceSnapshot.getValue(classAnnance.class);
                        annanceList.add(A);

                    }


                    adapter = new annanceAdapter(listeAnnance.this, annanceList);


                    recyclerView.setAdapter(adapter);

                    Log.e("errorr", "onComplete: content=" + adapter.getItemCount());
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


//    private void firebaseUserSearch(String searchText) {
//
//        Toast.makeText(listeAnnance.this, "Started Search", Toast.LENGTH_LONG).show();
//
//        Query firebaseSearchQuery = ref.orderByChild("Offer").startAt(searchText).endAt(searchText + "\uf8ff");
//
//        FirebaseRecyclerAdapter<Users, AnnaanceViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Users, UsersViewHolder>(
//
//                Users.class,
//                R.layout.list_layout,
//                UsersViewHolder.class,
//                firebaseSearchQuery
//
//        ) {
//            @Override
//            protected void populateViewHolder(AnnaanceViewHolder viewHolder, Users model, int position) {
//
//
//                viewHolder.setDetails(getApplicationContext(), model.getName(), model.getStatus(), model.getImage());
//
//            }
//        };
//
//        mResultList.setAdapter(firebaseRecyclerAdapter);
//
//    }
//    class AnnaanceViewHolder extends RecyclerView.ViewHolder{
//        ImageView imageView;
//        TextView textViewVileD, textViewDate, textviewhour;
//        public AnnaanceViewHolder(View itemView) {
//            super(itemView);
//            imageView = itemView.findViewById(R.id.imageView);
//            textViewVileD = itemView.findViewById(R.id.textViewVilleD);
//            textViewDate = itemView.findViewById(R.id.textViewDate);
//            textviewhour = itemView.findViewById(R.id.textViewhour);
//        }
//    }






//    public static class annanceViewHolder extends RecyclerView.ViewHolder{
//
//        View mView;
//        TextView textView_title;
//        public annanceViewHolder(View itemView) {
//            super(itemView);
//            textView_title = (TextView)itemView.findViewById(R.id.Annance);
//
//        }
//        public void setTitle(String title)
//        {
//            textView_title.setText(title+"");
//        }
//    }
}
