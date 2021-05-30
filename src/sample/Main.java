package sample;

import connectivity.ConnectionClass;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {
    TableView<JadwalModel> tableView;
    public GridPane gridPane;
    Scene scene1, scene2;
    private int selectedIndex = -1;
    @Override
    public void start(Stage primaryStage) {

        sceneSatu(primaryStage);

//scene 2
        VBox vbox = sceneDua(primaryStage);

        scene1 = new Scene(gridPane, 500, 600);
        scene2= new Scene(vbox,500,600);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private VBox sceneDua(Stage primaryStage) {
        tableView = new TableView<>();

        ObservableList<JadwalModel> observableList = FXCollections.observableArrayList();

        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        try {
            String sql = "SELECT * FROM jadwal_matkul";
            Statement statement = connection.createStatement();
            ResultSet queryStmt = statement.executeQuery(sql);
            while (queryStmt.next()) {
                observableList.add(new JadwalModel(queryStmt.getString("jadwal_id") ,queryStmt.getString("matkul") ,queryStmt.getString("waktu"), queryStmt.getString("ruangan"), queryStmt.getString("gkb"), queryStmt.getString("dosen")));
                System.out.println(queryStmt.getString("matkul")+","+queryStmt.getString("waktu"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableView.setEditable(true);
        TableColumn<JadwalModel, String> column1 = new TableColumn<>("Matkul");
        column1.setCellValueFactory(new PropertyValueFactory<>("matkul"));

        TableColumn<JadwalModel, String> column2 = new TableColumn<>("Waktu");
        column2.setCellValueFactory(new PropertyValueFactory<>("waktu"));

        TableColumn<JadwalModel, String> column3 = new TableColumn<>("Ruangan");
        column3.setCellValueFactory(new PropertyValueFactory<>("ruangan"));

        TableColumn<JadwalModel, String> column4 = new TableColumn<>("GKB");
        column4.setCellValueFactory(new PropertyValueFactory<>("gkb"));

        TableColumn<JadwalModel, String> column5 = new TableColumn<>("Dosen");
        column5.setCellValueFactory(new PropertyValueFactory<>("dosen"));

        TableColumn<JadwalModel, String> column6 = new TableColumn<>("Delete");
        column6.setCellValueFactory(new PropertyValueFactory<>("matkul"));

        tableView.setOnMouseClicked(event -> selectedIndex = tableView.getSelectionModel().getSelectedIndex());

        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction((ActionEvent e) -> observableList.remove(selectedIndex));

        tableView.setItems(observableList);
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);

        VBox vbox = new VBox(20);
        Button button2= new Button("Back");
        button2.setOnAction(event -> primaryStage.setScene(scene1));
        Button button3= new Button("Refresh");
        button3.setOnAction(event -> tableView.refresh());

        vbox.getChildren().addAll(tableView, button2,button3, deleteBtn);
        return vbox;
    }

    private void sceneSatu(Stage primaryStage) {
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

        Button button1= new Button("Read");
        HBox hBtn2 = new HBox(10);
        hBtn2.setAlignment(Pos.BOTTOM_LEFT);
        hBtn2.getChildren().add(button1);
        gridPane.add(hBtn2,0,6);

        button1.setOnAction(event -> primaryStage.setScene(scene2));

        JadwalController jadwalController = new JadwalController();
        jadwalController.buttonCreate(inputMatkul, inputWaktu, inputGkb, inputRuangan, inputDosen, actiontarget, btn);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
