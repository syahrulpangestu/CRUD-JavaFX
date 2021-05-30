package sample;

import connectivity.ConnectionClass;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JadwalModel {
    private String jadwal_id;
    private String matkul;
    private String waktu;
    private String gkb;
    private String ruangan;
    private String dosen;

    public JadwalModel(String jadwal_id, String matkul, String waktu, String gkb, String ruangan, String dosen){
        this.jadwal_id = jadwal_id;
        this.matkul = matkul;
        this.waktu=waktu;
        this.gkb=gkb;
        this.ruangan=ruangan;
        this.dosen=dosen;
    }

    public JadwalModel() {
        this.matkul = null;
    }

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getGkb() {
        return gkb;
    }

    public void setGkb(String gkb) {
        this.gkb = gkb;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public void rekapNilai() {
        String hasil = String.format(getMatkul() + "\t\t" + getWaktu() + "\t\t" + getGkb() + "\t\t" + getRuangan() + "\t\t" + getDosen());
        writeData(hasil);
    }

    public void writeData(String hasil) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        try {
            String sql = "INSERT INTO jadwal_matkul (matkul, waktu, ruangan, gkb, dosen)" + " VALUES ('" + getMatkul() + "','" + getWaktu() + "','" + getRuangan() + "','" + getGkb() + "','" + getDosen() + "')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

        File file = new File("test.txt");
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(hasil);
            bw.flush();
            bw.newLine();
            bw.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


}
