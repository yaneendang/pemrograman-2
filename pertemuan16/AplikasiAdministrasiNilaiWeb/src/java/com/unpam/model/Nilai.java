package com.unpam.model;

public class Nilai {
    private int id; // Tambahkan jika tabel nilai Anda menggunakan Auto Increment ID
    private String nim;
    private String kodeMk;
    private int skorNilai;

    // Properti Tambahan untuk mempermudah Join Data di View (Opsional)
    private String namaMahasiswa;
    private String namaMatakuliah;

    // Constructor Kosong
    public Nilai() {
    }

    // Constructor Lengkap
    public Nilai(String nim, String kodeMk, int skorNilai) {
        this.nim = nim;
        this.kodeMk = kodeMk;
        this.skorNilai = skorNilai;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getKodeMk() {
        return kodeMk;
    }

    public void setKodeMk(String kodeMk) {
        this.kodeMk = kodeMk;
    }

    public int getSkorNilai() {
        return skorNilai;
    }

    public void setSkorNilai(int skorNilai) {
        this.skorNilai = skorNilai;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getNamaMatakuliah() {
        return namaMatakuliah;
    }

    public void setNamaMatakuliah(String namaMatakuliah) {
        this.namaMatakuliah = namaMatakuliah;
    }
}