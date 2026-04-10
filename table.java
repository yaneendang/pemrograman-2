import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class table extends JFrame {

    private JTable tabel;
    private DefaultTableModel model;

    public table() {
        setTitle("Data Mahasiswa");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultTableModel();
        tabel = new JTable(model);

        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Kelas");
        model.addColumn("Jurusan");

        model.addRow(new Object[]{
            "Lovita Rosiyane Endang",
            "231011403015",
            "06TPLE016",
            "Informatika"
        });
         model.addRow(new Object[]{
            "Lovita Rosiyane Endang",
            "231011403015",
            "06TPLE016",
            "Informatika"
        });
          model.addRow(new Object[]{
            "Lovita Rosiyane Endang",
            "231011403015",
            "06TPLE016",
            "Informatika"
        });

        JScrollPane scroll = new JScrollPane(tabel);
        add(scroll);

        setVisible(true);
    }

    public static void main(String[] args) {
        new table();
    }
}