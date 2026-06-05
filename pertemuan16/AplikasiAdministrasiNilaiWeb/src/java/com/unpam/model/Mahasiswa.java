package com.unpam.model;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String jenisKelamin;
    private String alamat;

    // Constructor Kosong
    public Mahasiswa() {
    }

    // Constructor Lengkap
    public Mahasiswa(String nim, String nama, String jenisKelamin, String alamat) {
        this.nim = nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
    }

    // Getter dan Setter
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}