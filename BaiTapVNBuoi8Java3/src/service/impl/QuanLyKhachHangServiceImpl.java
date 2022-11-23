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
public class QuanLyKhachHangServiceImpl implements QuanLyKhachHangService{

    @Override
    public List<KhachHang> getData() {
        List<KhachHang> list = KhachHangRepository.readDB();
        return list;
    }

    @Override
    public List<KhachHang> sortBy() {
        List<KhachHang> list = KhachHangRepository.sortByName();
        return list;
    }

    

    

}
