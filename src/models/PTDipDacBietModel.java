/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author TNTDT
 */
public class PTDipDacBietModel {
    private int IDHS;
    private int IDPhanQua;
    private int IDDipDacBiet;
    private int soLuong;

    public PTDipDacBietModel(int IDHS, int IDPhanQua, int IDDipDacBiet, int soLuong) {
        this.IDHS = IDHS;
        this.IDPhanQua = IDPhanQua;
        this.IDDipDacBiet = IDDipDacBiet;
        this.soLuong = soLuong;
    }

    public int getIDHS() {
        return IDHS;
    }

    public void setIDHS(int IDHS) {
        this.IDHS = IDHS;
    }

    public int getIDPhanQua() {
        return IDPhanQua;
    }

    public void setIDPhanQua(int IDPhanQua) {
        this.IDPhanQua = IDPhanQua;
    }

    public int getIDDipDacBiet() {
        return IDDipDacBiet;
    }

    public void setIDDipDacBiet(int IDDipDacBiet) {
        this.IDDipDacBiet = IDDipDacBiet;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    
    
}
