/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemakademik;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sistemakademik.db.DBHandler;
import sistemakademik.model.MahasiswaProperty;

/**
 * FXML Controller class
 *
 * @author didik
 */
public class FXMLDataViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<MahasiswaProperty> tblMahasiswa;

    @FXML
    private TableColumn<MahasiswaProperty, String> colGender;

    @FXML
    private TableColumn<MahasiswaProperty, String> colNPM;

    @FXML
    private TableColumn<MahasiswaProperty, String> colNama;

    @FXML
    private TableColumn<MahasiswaProperty, String> colProdi;

    @FXML
    private TableColumn<MahasiswaProperty, String> colTglLahir;

    @FXML
    private MenuItem menuAddData;

    @FXML
    private MenuItem menuDeleteData;

    @FXML
    void viewAddDataForm(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }

    @FXML
    void deleteDataMahasiswa(ActionEvent event) {
        MahasiswaProperty mhs = tblMahasiswa.getSelectionModel().getSelectedItem();
        DBHandler dh = new DBHandler("MYSQL");
        dh.deleteMahasiswa(mhs);
        showDataMahasiswa();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showDataMahasiswa();

        tblMahasiswa.getSelectionModel().selectedIndexProperty().addListener(listener -> {
//            JOptionPane.showMessageDialog(null, "Table Diklik!");
            menuDeleteData.setDisable(false);
        });
    }

    public void showDataMahasiswa() {
        DBHandler dh = new DBHandler("MYSQL");
        ObservableList<MahasiswaProperty> data = dh.getMahasiswa();
        colNPM.setCellValueFactory(new PropertyValueFactory<>("npm"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colProdi.setCellValueFactory(new PropertyValueFactory<>("prodi"));
        colTglLahir.setCellValueFactory(new PropertyValueFactory<>("tanggalLahir"));
        tblMahasiswa.setItems(null);
        tblMahasiswa.setItems(data);
    }
}
