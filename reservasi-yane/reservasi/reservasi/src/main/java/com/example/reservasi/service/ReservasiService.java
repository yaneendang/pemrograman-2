package com.example.reservasi.service;

import com.example.reservasi.model.Reservasi;
import com.example.reservasi.repository.ReservasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservasiService {

    @Autowired
    private ReservasiRepository repository;

    public List<Reservasi> getAllReservasi() {
        return repository.findAll();
    }

    public void simpanReservasi(Reservasi reservasi) throws Exception {
        if (reservasi.getTanggalCheckOut().isBefore(reservasi.getTanggalCheckIn())) {
            throw new IllegalArgumentException("Tanggal Check-out tidak boleh sebelum tanggal Check-in!");
        }

        long totalReservasi = repository.count();
        if (totalReservasi >= 50) {
            throw new Exception("Reservasi gagal! Hotel sudah penuh untuk periode ini.");
        }

        repository.save(reservasi);
    }
}