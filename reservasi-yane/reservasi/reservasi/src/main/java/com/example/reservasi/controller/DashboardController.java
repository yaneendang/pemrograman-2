package com.example.reservasi.controller;

import com.example.reservasi.repository.ReservasiRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private ReservasiRepository reservasiRepository;

    @GetMapping("/dashboard")
    public String dashboardPage(HttpSession session, Model model) {
        // Proteksi Halaman: Jika belum login, tendang balik ke halaman login
        if (session.getAttribute("userAdmin") == null) {
            return "redirect:/login";
        }

        // 1. Hitung Total Kamar Terisi
        long totalTerisi = reservasiRepository.count();

        // 2. Hitung Sisa Kuota Kamar (Batas Maksimal 50)
        long sisaKuota = 50 - totalTerisi;
        if (sisaKuota < 0) sisaKuota = 0;

        // 3. Hitung Persentase Okupansi
        double persentaseOkupansi = (totalTerisi / 50.0) * 100;

        // Kirim data ke HTML (Thymeleaf)
        model.addAttribute("totalTerisi", totalTerisi);
        model.addAttribute("sisaKuota", sisaKuota);
        model.addAttribute("persentase", (int) persentaseOkupansi);
        model.addAttribute("username", session.getAttribute("userAdmin"));

        return "dashboard";
    }
}