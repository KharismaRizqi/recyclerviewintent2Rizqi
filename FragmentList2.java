package com.devapps.recyclerview_2_kharismarizqi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentList2 extends Fragment {

    String[] pemain = {"Benzema","L.Messi","Ronney","Neymar"};
    String [] topscore = {"450 gol", "650 gol","400 gol","600 gol"};
    String [] team = {"Real Madrid","Barcelona","Mencester United","PSG"};
    String [] harga = {"6000000","6000000","6000000"};
    int [] pict = {R.drawable.bz,R.drawable.ms, R.drawable.rm, R.drawable.ny};

    RecyclerView rv2;
    Last2Adapter list2Adapter;

    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveIntanceState) {

        View view = inflater.inflate(R.layout.fragment3, container, false);

        list2Adapter = new Last2Adapter(getActivity(),pemain,topscore,team,harga,pict);
        rv2 = view.findViewById(R.id.fmg3);
        rv2.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        rv2.setAdapter(list2Adapter);


        return view;
    }

    private class Last2Adapter extends RecyclerView.Adapter<CustomViewHolder> {

        public Last2Adapter(FragmentActivity activity, String[] pemain, String[] topscore, String[] team, String[] harga, int[] pict) {
        }

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list2, viewGroup, false);
            return new CustomViewHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {

            customViewHolder.img2.setImageResource(pict[i]);
            customViewHolder.tx1.setText(topscore[i]);
            customViewHolder.tx2.setText(team[i]);
            customViewHolder.tx4.setText(harga[i]);
            customViewHolder.tx3.setText(pemain[i]);
        }

        @Override
        public int getItemCount() {
            return  pemain.length;
        }
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView img2;
        TextView tx1,tx2,tx3,tx4;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            img2 = itemView.findViewById(R.id.imgimg);
            tx1 = itemView.findViewById(R.id.t1);
            tx2 = itemView.findViewById(R.id.t2);
            tx3 = itemView.findViewById(R.id.t3);
            tx4 = itemView.findViewById(R.id.t4);

        }
    }
}
