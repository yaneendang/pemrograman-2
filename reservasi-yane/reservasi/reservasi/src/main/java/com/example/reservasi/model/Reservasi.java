package com.example.reservasi.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_reservasi")
public class Reservasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_tamu", nullable = false)
    private String namaTamu;

    @Column(name = "tipe_kamar", nullable = false)
    private String tipeKamar;

    @Column(name = "tanggal_checkin", nullable = false)
    private LocalDate tanggalCheckIn;

    @Column(name = "tanggal_checkout", nullable = false)
    private LocalDate tanggalCheckOut;

    // Constructor Kosong (Wajib untuk JPA)
    public Reservasi() {}

    // Constructor dengan Parameter
    public Reservasi(String namaTamu, String tipeKamar, LocalDate tanggalCheckIn, LocalDate tanggalCheckOut) {
        this.namaTamu = namaTamu;
        this.tipeKamar = tipeKamar;
        this.tanggalCheckIn = tanggalCheckIn;
        this.tanggalCheckOut = tanggalCheckOut;
    }

    // Getter dan Setter (Prinsip Enkapsulasi OOP)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNamaTamu() { return namaTamu; }
    public void setNamaTamu(String namaTamu) { this.namaTamu = namaTamu; }

    public String getTipeKamar() { return tipeKamar; }
    public void setTipeKamar(String tipeKamar) { this.tipeKamar = tipeKamar; }

    public LocalDate getTanggalCheckIn() { return tanggalCheckIn; }
    public void setTanggalCheckIn(LocalDate tanggalCheckIn) { this.tanggalCheckIn = tanggalCheckIn; }

    public LocalDate getTanggalCheckOut() { return tanggalCheckOut; }
    public void setTanggalCheckOut(LocalDate tanggalCheckOut) { this.tanggalCheckOut = tanggalCheckOut; }
}