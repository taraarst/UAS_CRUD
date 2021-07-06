package com.tiaradwiarista.crud.model;

import io.realm.RealmObject;


public class ModelSiswa extends RealmObject {
    private int id;
    private String nama;
    private String kelas;

    public ModelSiswa(int id, String nama, String kelas) {
        this.id = id;
        this.nama = nama;
        this.kelas = kelas;
    }

    public ModelSiswa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
