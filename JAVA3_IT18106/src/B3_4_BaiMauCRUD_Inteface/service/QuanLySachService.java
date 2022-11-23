/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package B3_4_BaiMauCRUD_Inteface.service;

import B3_4_BaiMauCRUD_Inteface.model.Sach;
import java.util.List;


/**
 *
 * @author Bânbân
 */
public interface QuanLySachService {
    List<Sach> getList();
    void add(List<Sach>list, Sach s);
    void xoa(List<Sach> list,int index );
    List<Sach>searchTheoTen(List<Sach> list, String ten);
    void sortByName(List<Sach> list);
}
