/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B3_4_BaiMauCRUD_Inteface.service.impl;

import B3_4_BaiMauCRUD_Inteface.model.Sach;
import B3_4_BaiMauCRUD_Inteface.service.QuanLySachService;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Bânbân
 */
public class QuanLySachServiceImpl implements QuanLySachService {

    List<Sach> list = new ArrayList<>();

    @Override
    public List<Sach> getList() {
        return list;
    }

    @Override
    public void add(List<Sach> list, Sach s) {
        list.add(s);
    }

    @Override
    public void xoa(List<Sach> list, int index) {
        list.remove(index);
    }

    @Override
    public List<Sach> searchTheoTen(List<Sach> list, String ten) {
        List<Sach> listSearch = new ArrayList<>();
        //Code
        for (Sach sach : list) {
            if (sach.getTenSach().contains(ten)) {
                // add vào list search
                listSearch.add(sach);
            }
        }
        return listSearch;
    }

    @Override
    public void sortByName(List<Sach> list) {
        // Sort theo lamda
        list.sort((o1, o2) -> {
            return o1.getTenSach().compareTo(o2.getTenSach());
        });
    }

}
