package com.example.reservasi.controller;

import com.example.reservasi.model.Reservasi;
import com.example.reservasi.service.ReservasiService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservasi")
public class ReservasiController {

    @Autowired
    private ReservasiService service;

    @GetMapping
    public String index(HttpSession session, Model model) {
        
        if (session.getAttribute("userAdmin") == null) {
        return "redirect:/login";
    }
        
        model.addAttribute("daftarReservasi", service.getAllReservasi());
        model.addAttribute("reservasi", new Reservasi());
        return "index";
    }

    @PostMapping("/save")
    public String saveReservasi(@ModelAttribute("reservasi") Reservasi reservasi, Model model) {
        try {
            service.simpanReservasi(reservasi);
            return "redirect:/reservasi?success";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("daftarReservasi", service.getAllReservasi());
            return "index";
        }
    }
}