package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class JadwalController {
    public void buttonCreate(TextField inputMatkul, TextField inputWaktu, TextField inputGkb, TextField inputRuangan, TextField inputDosen, Text actiontarget, Button btn) {
        btn.setOnAction(new EventHandler<ActionEvent>() {
            final JadwalModel jadwalModel = new JadwalModel();
            final ReadView readView = new ReadView();
            @Override
            public void handle(ActionEvent event) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Berhasil ditambahkan");
                jadwalModel.setMatkul(inputMatkul.getText());
                jadwalModel.setWaktu(inputWaktu.getText());
                jadwalModel.setGkb(inputGkb.getText());
                jadwalModel.setRuangan(inputRuangan.getText());
                jadwalModel.setDosen(inputDosen.getText());
                jadwalModel.rekapNilai();
            }
        });
    }


}
