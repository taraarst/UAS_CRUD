package com.tiaradwiarista.crud.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tiaradwiarista.crud.R;
import com.tiaradwiarista.crud.activities.UpdateDataActivity;
import com.tiaradwiarista.crud.model.ModelSiswa;

import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ModelSiswa> dataSiswa;

    public DataAdapter(Context context, ArrayList<ModelSiswa> dataSiswa) {
        this.context = context;
        this.dataSiswa = dataSiswa;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tdNama, tdKelas;
        public MyViewHolder(View itemView) {
            super(itemView);
            tdNama = itemView.findViewById(R.id.td_list_nama);
            tdKelas = itemView.findViewById(R.id.td_list_kelas);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.list_item_data, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //set data
        holder.tdNama.setText(dataSiswa.get(position).getNama());
        holder.tdKelas.setText(dataSiswa.get(position).getKelas());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(context, UpdateDataActivity.class);
                pindah.putExtra("DATA_ID", dataSiswa.get(position).getId());
                pindah.putExtra("DATA_NAMA", dataSiswa.get(position).getNama());
                pindah.putExtra("DATA_KELAS", dataSiswa.get(position).getKelas());
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSiswa.size();
    }

}
