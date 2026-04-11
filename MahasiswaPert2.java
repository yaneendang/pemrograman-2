import java.util.Scanner;

public class Mahasiswa {

    private String nim, nama, grade;
    private float uts, uas;
    private double nilaiakhir;

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

    public float getUts() {
        return uts;
    }

    public void setUts(float uts) {
        this.uts = uts;
    }

    public float getUas() {
        return uas;
    }

    public void setUas(float uas) {
        this.uas = uas;
    }

    // hitung nilai akhir
    public double getNilaiAkhir() {
        nilaiakhir = (uts + uas) / 2;
        return nilaiakhir;
    }

    // hitung grade
    public String getGrade() {
        double na = getNilaiAkhir();

        if (na < 50)
            grade = "E";
        else if (na < 60)
            grade = "D";
        else if (na < 70)
            grade = "C";
        else if (na < 80)
            grade = "B";
        else
            grade = "A";

        return grade;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Mahasiswa mhs = new Mahasiswa();

        System.out.println("=== INPUT DATA MAHASISWA ===");

        System.out.print("Masukkan NIM   : ");
        mhs.setNim(input.nextLine());

        System.out.print("Masukkan Nama  : ");
        mhs.setNama(input.nextLine());

        System.out.print("Masukkan Nilai UTS : ");
        mhs.setUts(input.nextFloat());

        System.out.print("Masukkan Nilai UAS : ");
        mhs.setUas(input.nextFloat());

        System.out.println("\n=== HASIL ===");
        System.out.println("NIM   : " + mhs.getNim());
        System.out.println("Nama  : " + mhs.getNama());
        System.out.println("UTS   : " + mhs.getUts());
        System.out.println("UAS   : " + mhs.getUas());
        System.out.println("Nilai Akhir : " + mhs.getNilaiAkhir());
        System.out.println("Grade : " + mhs.getGrade());

        input.close();
    }
}