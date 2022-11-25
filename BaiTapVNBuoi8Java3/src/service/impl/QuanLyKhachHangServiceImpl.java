/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.KhachHang;
import java.util.List;
import repository.KhachHangRepository;
import service.QuanLyKhachHangService;

/**
 *
 * @author Bânbân
 */
public class QuanLyKhachHangServiceImpl implements QuanLyKhachHangService {

    KhachHangRepository khr = new KhachHangRepository();

    @Override
    public List<KhachHang> getData() {
        return khr.readDB();

    }

    @Override
    public List<KhachHang> sortBy() {
        return khr.sortByName();
    }

    @Override
    public List<KhachHang> Search(List<KhachHang> lists, int max, int min) {

        return khr.getTuoi(min, max);
    }

    @Override
    public String add(KhachHang kh) {
        boolean addKH = khr.add(kh);
        if (addKH) {
            return "Add thành công";
        }
        return "Add thất bại";
    }

    @Override
    public String update(String makh, KhachHang kh,int index) {
        boolean updateKH = khr.update(makh, kh);
        if (updateKH) {
            return "Update thành công";
        }
        return "Update thất bại";
    }

    @Override
    public String delete(List<KhachHang> lists, String makh,int index) {
        boolean deleteKH = khr.delete(makh);
        if (deleteKH) {
            return "Delete thành công";
        }
        return "Delete thất bại";
    }

    

}
