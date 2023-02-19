/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;

/**
 *
 * @author TNTDT
 */
public class DanhHieuModel {

    private int ID;
    private int IDNhanKhau;
    private String hoTen;
    private Date namSinh;
    private String danhHieu;

    public DanhHieuModel(int ID, int IDNhanKhau, String hoTen, Date namSinh, String danhHieu) {
        this.ID = ID;
        this.IDNhanKhau = IDNhanKhau;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.danhHieu = danhHieu;
    }

    public DanhHieuModel(int IDNhanKhau, String hoTen, Date namSinh, String danhHieu) {
        this.IDNhanKhau = IDNhanKhau;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.danhHieu = danhHieu;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDNhanKhau() {
        return IDNhanKhau;
    }

    public void setIDNhanKhau(int IDNhanKhau) {
        this.IDNhanKhau = IDNhanKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public String getDanhHieu() {
        return danhHieu;
    }

    public void setDanhHieu(String danhHieu) {
        this.danhHieu = danhHieu;
    }

  

}
