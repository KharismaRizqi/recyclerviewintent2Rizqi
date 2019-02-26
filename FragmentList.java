package com.devapps.recyclerview_2_kharismarizqi;

import android.content.Context;
import android.content.Intent;
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

public class FragmentList extends Fragment{

    String[] nama = {"Real Madrid","Barcelona", "Mancester United","Mencester City","Paris saint German","Juventus"};
    int[] bentuk = {R.drawable.rm, R.drawable.br, R.drawable.mu, R.drawable.mc, R.drawable.psg, R.drawable.jv};


     RecyclerView rv1;
    LastAdapter listAdapter ;


    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState) {
        View v = inflater.inflate(R.layout.fregment1, container, false);

        listAdapter = new LastAdapter(getActivity(), nama ,bentuk);
        rv1 = v.findViewById(R.id.recycleview);
        rv1.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        rv1.setAdapter(listAdapter);

        return  v;

        // For Adapter
    }

    private class  LastAdapter extends RecyclerView.Adapter<CustomViewHolder> {

        Context context;

        public LastAdapter(FragmentActivity activity, String[] nama, int[] bentuk) {
        }

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
            return new CustomViewHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, final int i) {

            customViewHolder.imglogo.setImageResource(bentuk[i]);
            customViewHolder.txt.setText(nama[i]);
            customViewHolder.imglogo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent w = new Intent(context)
                }
            });

        }

        @Override
        public int getItemCount() {
            return nama.length;
        }
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView imglogo;
        TextView txt;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            imglogo = itemView.findViewById(R.id.itm_img);
            txt = itemView.findViewById(R.id.txt_v);
        }
    }
}
