package com.unpam.view;

public class PesanDialog {
    
    public static String tampilkanAlert(String pesan, String tujuanUrl) {
        return "<script type='text/javascript'>"
                + "alert('" + pesan + "');"
                + "window.location.href='" + tujuanUrl + "';"
                + "</script>";
    }
    
    public static String tampilkanError(String pesan) {
        return "<script type='text/javascript'>"
                + "alert('Gagal: " + pesan + "');"
                + "window.history.back();"
                + "</script>";
    }
}