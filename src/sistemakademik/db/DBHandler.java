/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemakademik.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sistemakademik.model.Mahasiswa;
import sistemakademik.model.MahasiswaProperty;
/**
 *
 * @author didik
 */
public class DBHandler {
    public final Connection conn;

    public DBHandler(String driver) {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addMahasiswa(Mahasiswa mhs){
        String insertMhs = "INSERT INTO `mahasiswa`(`npm`, `nama`, `tgl_lahir`,`gender`,`prodi`)"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertMhs);
            stmtInsert.setString(1, mhs.getNpm());
            stmtInsert.setString(2, mhs.getNama());
            stmtInsert.setString(3, mhs.getTanggalLahir());
            stmtInsert.setString(4, mhs.getGender());
            stmtInsert.setString(5, mhs.getProdi());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObservableList<MahasiswaProperty> getMahasiswa(){
        ObservableList<MahasiswaProperty> data = FXCollections.observableArrayList();
        
        String sql = "SELECT npm, nama, tgl_lahir, gender, prodi FROM `mahasiswa` ORDER BY npm";
        
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                MahasiswaProperty mhs = new MahasiswaProperty(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                data.add(mhs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    public void deleteMahasiswa(MahasiswaProperty mhs){
        String deleteMhs = "DELETE FROM mahasiswa WHERE `mahasiswa`.`npm` = ?";
        try {
            PreparedStatement stmtDelete = conn.prepareStatement(deleteMhs);
            stmtDelete.setString(1, mhs.getNpm());
            stmtDelete.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
