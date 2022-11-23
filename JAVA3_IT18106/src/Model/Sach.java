/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bânbân
 */
public class Sach {
    private String tenSach;
    private String tacGia;
    private int theLoai;
    private int namIn;

    public Sach() {
    }

    public Sach(String tenSach, String tacGia, int theLoai, int namIn) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.namIn = namIn;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(int theLoai) {
        this.theLoai = theLoai;
    }

    public int getNamIn() {
        return namIn;
    }

    public void setNamIn(int namIn) {
        this.namIn = namIn;
    }
    public  String getLoai(){
        if(theLoai == 1){
            return "Truyen ngan";
        }else{
            return "Tieu thuyet";
        }
    }
}
