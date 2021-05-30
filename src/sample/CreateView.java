package sample;

import connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateView {
    public GridPane gridPane;

    public CreateView() {
        int i = 0;
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text judul = new Text("Masukan Jadwal");
        judul.setFont(Font.font("Tahoma", FontWeight.BLACK, 12));
        gridPane.add(judul,0,0,2, 1);

        Label labelMatkul = new Label("Masukan Matkul");
        gridPane.add(labelMatkul, 0, 1);
        TextField inputMatkul = new TextField();
        gridPane.add(inputMatkul, 1, 1);

        Label labelWaktu = new Label("Masukan Waktu");
        gridPane.add(labelWaktu, 0, 2);
        TextField inputWaktu = new TextField();
        gridPane.add(inputWaktu, 1, 2);

        Label labelGkb = new Label("Masukan GKB");
        gridPane.add(labelGkb, 0, 3);
        TextField inputGkb = new TextField();
        gridPane.add(inputGkb, 1, 3);

        Label labelRuangan = new Label("Masukan Ruangan");
        gridPane.add(labelRuangan, 0, 4);
        TextField inputRuangan = new TextField();
        gridPane.add(inputRuangan, 1, 4);

        Label labelDosen = new Label("Masukan Dosen");
        gridPane.add(labelDosen, 0, 5);
        TextField inputDosen = new TextField();
        gridPane.add(inputDosen, 1, 5);

        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 6);

        Button btn = new Button("submit");
        HBox hBtn = new HBox(10);
        hBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hBtn.getChildren().add(btn);
        gridPane.add(hBtn,1,6);

        Button btn1 = new Button("read");
        HBox hBtn1 = new HBox(10);
        hBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hBtn1.getChildren().add(btn1);
        gridPane.add(hBtn1,1,7);

        JadwalController jadwalController = new JadwalController();
        jadwalController.buttonCreate(inputMatkul, inputWaktu, inputGkb, inputRuangan, inputDosen, actiontarget, btn);
//        jadwalController.buttonRead(btn1, gridPane);
    }


    public Parent asParent() {
        return gridPane;
    }
}
