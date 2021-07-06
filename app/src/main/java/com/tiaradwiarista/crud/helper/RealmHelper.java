package com.tiaradwiarista.crud.helper;

import android.content.Context;
import android.widget.Toast;

import com.tiaradwiarista.crud.model.ModelSiswa;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class RealmHelper {

    private Context context;
    private Realm realm;
    private RealmResults<ModelSiswa> realmResults;

    //logt
    private static final String TAG = "RealmHelper";

    public RealmHelper(Context context) {
        this.context = context;
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void inputDataAwal() {
        ModelSiswa siswa = new ModelSiswa();
        siswa.setId(1);
        siswa.setNama("Tiara");
        siswa.setKelas("TIF J");

        realm.beginTransaction();
        realm.copyToRealm(siswa);
        realm.commitTransaction();

        Toast.makeText(context, "Data berhasil ditambah", Toast.LENGTH_LONG).show();
    }

    public ArrayList<ModelSiswa> tampilDataSiswa() {
        ArrayList<ModelSiswa> data = new ArrayList<>();
        realmResults = realm.where(ModelSiswa.class).findAll();
        realmResults.sort("id", Sort.ASCENDING);

        if (realmResults.size() > 0) {

            for (int i = 0; i < realmResults.size(); i++) {
                ModelSiswa siswa = new ModelSiswa();
                siswa.setId(realmResults.get(i).getId());
                siswa.setNama(realmResults.get(i).getNama());
                siswa.setKelas(realmResults.get(i).getKelas());
                data.add(siswa);
            }
        }
        return data;
    }

    public void tambahSiswa(String nama, String kelas) {
        ModelSiswa siswa = new ModelSiswa();
        siswa.setId((int) (System.currentTimeMillis() / 1000));
        siswa.setNama(nama);
        siswa.setKelas(kelas);

        realm.beginTransaction();
        realm.copyToRealm(siswa);
        realm.commitTransaction();

        Toast.makeText(context, "Data berhasil ditambah", Toast.LENGTH_LONG).show();
    }

    public void updateSiswa(int id, String nama, String kelas) {
        realm.beginTransaction();
        ModelSiswa siswa = realm.where(ModelSiswa.class).equalTo("id", id).findFirst();
        siswa.setNama(nama);
        siswa.setKelas(kelas);
        realm.copyToRealm(siswa);
        realm.commitTransaction();

        Toast.makeText(context, "Data berhasil diupdate", Toast.LENGTH_LONG).show();
    }

    public void deleteSiswa(int id) {
        realm.beginTransaction();
        RealmResults<ModelSiswa> siswa = realm.where(ModelSiswa.class).equalTo("id", id).findAll();
        siswa.deleteAllFromRealm();
        realm.commitTransaction();

        Toast.makeText(context, "Data berhasil dihapus", Toast.LENGTH_LONG).show();
    }

}
