/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.KhachHang;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public interface QuanLyKhachHangService {
    List<KhachHang> getData();
    List<KhachHang> Search (List<KhachHang> lists,int max, int min);
    List<KhachHang> sortBy();
    String add(KhachHang kh);
    String update(String makh,KhachHang kh,int index);
    String delete( List<KhachHang> lists, String makh,int index);
}
