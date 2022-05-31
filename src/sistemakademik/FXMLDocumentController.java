/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemakademik;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sistemakademik.db.DBHandler;
import sistemakademik.model.Mahasiswa;

/**
 *
 * @author didik
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private Button btnSave;

    @FXML
    private ComboBox<?> cbProdi;

    @FXML
    private DatePicker dpTanggalLahir;

    @FXML
    private ToggleGroup gender;

    @FXML
    private Label label;

    @FXML
    private RadioButton rdLaki;

    @FXML
    private RadioButton rdPerempuan;

    @FXML
    private TextField tfNPM;

    @FXML
    private TextField tfNama;

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
//        label.setText("Hello "+tfNama.getText());
        System.out.println(tfNPM.getText());
        System.out.println(tfNama.getText());
        System.out.println(dpTanggalLahir.getValue().toString());
        String gender="";
        if (rdLaki.isSelected())
           gender=rdLaki.getText();
        if (rdPerempuan.isSelected())
           gender=rdPerempuan.getText();
        
        System.out.println(gender);
        System.out.println(cbProdi.getValue().toString());
//        Mahasiswa(String npm, String nama, String tanggalLahir, String gender, String prodi)
        Mahasiswa mhs = new Mahasiswa(tfNPM.getText(),tfNama.getText(),dpTanggalLahir.getValue().toString(),
            gender,cbProdi.getValue().toString());
        DBHandler dh = new DBHandler("MYSQL");
        dh.addMahasiswa(mhs);
        FXMLDataViewController view = new FXMLDataViewController();
        view.showDataMahasiswa();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        ArrayList <String> list = new ArrayList<String>();
        list.add("D3 Manajemen Informatika");
        list.add("S1 Ilmu Komputer");
        ObservableList items = FXCollections.observableArrayList(list);
        cbProdi.setItems(items);
    }    
    
}
