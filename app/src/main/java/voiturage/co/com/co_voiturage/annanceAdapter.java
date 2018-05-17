package voiturage.co.com.co_voiturage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static voiturage.co.com.co_voiturage.listeAnnance.EXTRA_VilleD;


public class annanceAdapter extends RecyclerView.Adapter<annanceAdapter.AnnaanceViewHolder>{
    Context mctxt ;
    List<classAnnance> list ;
//    private OnItemClickListener mListener;
    public static final String EXTRA_VilleD = "villed";
    public static final String EXTRA_villeA = "villea";
    public static final String EXTRA_Date = "date";
    public static final String EXTRA_HeurD = "heur";
    public static final String EXTRA_nbp= "nbp";

//    public interface OnItemClickListener {
//        void onItemClick(int position);
//    }

//    public void setmListener(OnItemClickListener mListenerr) {
//        this.mListener = mListenerr;
//    }

    public annanceAdapter(Context mctxt, List<classAnnance> list) {
        this.mctxt = mctxt;
        this.list = list;
    }


    @Override
    public AnnaanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mctxt).inflate(R.layout.individual_row,parent,false);
        AnnaanceViewHolder annanceViewHolder = new AnnaanceViewHolder(view);

        return annanceViewHolder;
    }

    @Override
    public void onBindViewHolder(AnnaanceViewHolder holder, int position) {
        final classAnnance  annance = list.get(position);
        holder.textViewVileD.setText(annance.getVilleDepart());
        holder.textViewDate.setText(annance.getDate());
        holder.textviewhour.setText(annance.getHeur());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("clicked", "onComplete: click ="+ annance.getNbrPlace());

                Intent detailIntent = new Intent(mctxt, AnnanceDetail.class);

              String nbp = String.valueOf(annance.getNbrPlace());
                detailIntent.putExtra(EXTRA_VilleD, annance.getVilleDepart());
                detailIntent.putExtra(EXTRA_villeA, annance.getVilleDarriver());
                detailIntent.putExtra(EXTRA_Date, annance.getDate());
                detailIntent.putExtra(EXTRA_HeurD, annance.getHeur());
                detailIntent.putExtra(EXTRA_nbp , nbp );



                mctxt.startActivity(detailIntent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

  public class AnnaanceViewHolder extends RecyclerView.ViewHolder  {

        ImageView imageView;
        TextView textViewVileD, textViewDate, textviewhour;
        RelativeLayout relativeLayout ;
        public AnnaanceViewHolder(View itemView) {
            super(itemView);
            relativeLayout  =itemView.findViewById(R.id.oneRow);
            imageView = itemView.findViewById(R.id.imageView);
            textViewVileD = itemView.findViewById(R.id.textViewVilleD);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textviewhour = itemView.findViewById(R.id.textViewhour);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mListener != null) {
//                        Log.e("errorr", "onComplete: Failed=lisnner kayn " );
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION) {
//                            mListener.onItemClick(position);
//                            Log.e("errorr", "onComplete: Failed=" );
//
//                        }
//                    }else
//                    {
//
//                        Log.e("errorr", "onComplete: mlistener=null" );
//
//                    }
//                }
//            });
        }



    }

    public void updateListe(List<classAnnance> newlist){
        list = new ArrayList<>();
        list.addAll(newlist);
        notifyDataSetChanged();

    }

}
