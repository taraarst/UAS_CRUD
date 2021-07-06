package com.tiaradwiarista.crud.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.tiaradwiarista.crud.R;
import com.tiaradwiarista.crud.helper.RealmHelper;


public class UpdateDataActivity extends AppCompatActivity {

    private EditText tdNama;
    private EditText tdKelas;
    private Button btnUpdate, btnHapus;
    private RealmHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        Toolbar tbMW = findViewById(R.id.tbUpdate);
        setSupportActionBar(tbMW);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Update Data");

        final int id = getIntent().getIntExtra("DATA_ID", 0);
        String nama = getIntent().getStringExtra("DATA_NAMA");
        String kelas = getIntent().getStringExtra("DATA_KELAS");

        initView();

        tdNama.setText(nama);
        tdKelas.setText(kelas);

        helper = new RealmHelper(this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = tdNama.getText().toString();
                String kelas = tdKelas.getText().toString();
                helper.updateSiswa(id, nama, kelas);
                Toast.makeText(UpdateDataActivity.this, "Update Data Berhasil", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.deleteSiswa(id);
                Toast.makeText(UpdateDataActivity.this, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void initView() {
        tdNama = findViewById(R.id.td_nama);
        tdKelas = findViewById(R.id.td_kelas);
        btnUpdate = findViewById(R.id.btn_update);
        btnHapus = findViewById(R.id.btn_hapus);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
