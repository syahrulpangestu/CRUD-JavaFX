package sample;

import connectivity.ConnectionClass;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadView {
    public void readData(GridPane gridPane){
        int i = 0;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        try {
            String sql ="SELECT * FROM jadwal_matkul";
            Statement statement = connection.createStatement();
            ResultSet queryStmt = statement.executeQuery(sql);
            while (queryStmt.next()){
                Label labelTampil = new Label();
                labelTampil.setText(queryStmt.getString("matkul"));
                gridPane.add(labelTampil,1,8+i);
                i++;

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
