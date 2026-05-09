
import java.sql.Connection;
import java.sql.DriverManager;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

public class App {
    public static void main(String[] args) {
        try {
            // 1. Konfigurasi Koneksi ke Database 'basisdata'
            String url = "jdbc:mysql://localhost/basisdata";
            String user = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url, user, password);

            // 2. Alamat file laporan (.jasper)
            // Pastikan file laporan.jasper ada di dalam folder 'laporan'
            String path = "laporan/laporan.jrxml";

            // 3. Mengisi laporan dengan data dari database
            JasperPrint jp = JasperFillManager.fillReport(path, null, conn);

            // 4. Menampilkan laporan
            JasperViewer.viewReport(jp, false);

            System.out.println("Laporan berhasil dijalankan!");

        } catch (Exception e) {
            // Menampilkan pesan error jika ada masalah
            e.printStackTrace();
        }
    }
}