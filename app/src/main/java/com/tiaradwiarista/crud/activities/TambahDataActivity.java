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

public class TambahDataActivity extends AppCompatActivity {

    private EditText tdNama;
    private EditText tdKelas;
    private Button btnTambah;
    private RealmHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);
        initView();

        Toolbar tbMW = findViewById(R.id.tbAdd);
        setSupportActionBar(tbMW);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tambah Data");

        helper = new RealmHelper(this);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tdNama.getText().toString().isEmpty() || tdKelas.getText().toString().isEmpty()) {
                    Toast.makeText(TambahDataActivity.this, "Lengkapi Data!", Toast.LENGTH_LONG).show();
                } else {
                    String nama = tdNama.getText().toString();
                    String kelas = tdKelas.getText().toString();
                    helper.tambahSiswa(nama, kelas);
                    Toast.makeText(TambahDataActivity.this, "Data Terkirim", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    private void initView() {
        tdNama = findViewById(R.id.td_nama);
        tdKelas = findViewById(R.id.td_kelas);
        btnTambah = findViewById(R.id.btn_tambah);
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
