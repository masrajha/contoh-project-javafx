/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemakademik.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author didik
 */
public class MahasiswaProperty {
    private StringProperty npm;
    private StringProperty nama;
    private StringProperty tanggalLahir;
    private StringProperty gender;
    private StringProperty prodi;

    public MahasiswaProperty(String npm, String nama, String tanggalLahir, String gender, String prodi) {
        this.npm = new SimpleStringProperty(npm);
        this.nama = new SimpleStringProperty(nama);
        this.tanggalLahir = new SimpleStringProperty(tanggalLahir);
        this.gender = new SimpleStringProperty(gender);
        this.prodi = new SimpleStringProperty(prodi);
    }
    public MahasiswaProperty(Mahasiswa mhs){
        this.npm = new SimpleStringProperty(mhs.getNpm());
        this.nama = new SimpleStringProperty(mhs.getNama());
        this.tanggalLahir = new SimpleStringProperty(mhs.getTanggalLahir());
        this.gender = new SimpleStringProperty(mhs.getGender());
        this.prodi = new SimpleStringProperty(mhs.getProdi());
    }
    public StringProperty getProdiProperty() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = new SimpleStringProperty(prodi);
    }

    public StringProperty getNpmProperty() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = new SimpleStringProperty(npm);
    }

    public StringProperty getNamaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = new SimpleStringProperty(nama);
    }

    public StringProperty getTanggalLahirProperty() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = new SimpleStringProperty(tanggalLahir);
    }

    public StringProperty getGenderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = new SimpleStringProperty(gender);
    }

    public String getNpm() {
        return npm.get();
    }

    public String getNama() {
        return nama.get();
    }

    public String getTanggalLahir() {
        return tanggalLahir.get();
    }

    public String getGender() {
        return gender.get();
    }

    public String getProdi() {
        return prodi.get();
    }
    
}
