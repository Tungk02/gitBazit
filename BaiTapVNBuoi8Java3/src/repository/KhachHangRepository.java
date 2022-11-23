/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.KhachHang;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Bânbân
 */
public class KhachHangRepository {

    public static List<KhachHang> readDB() {
        // B1: Viết câu query
        String query = """
                       SELECT [makh]
                             ,[ten_kh]
                             ,[tuoi]
                             ,[gioiTinh]
                             ,[loai]
                         FROM [dbo].[khachHang]
                       """;
//        B2: Mo connection
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            //B3: Statement : là 1 interface cho phép gửi các câu lệnh SQL tới Database
            //B4: Tạo resultSet: đại diện cho các tập hợp các record có được sau khi chạy sql
            ResultSet rs = ps.executeQuery();
            //B5: Tạo kiểu trả về
            List<KhachHang> list = new ArrayList<>();
            //B6: Đọc data từ result set
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4), rs.getString(5));
                list.add(khachHang);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public KhachHang getTuoi() {
        int tuoi = 0;
        // B1: Viết câu query
        String query = """
                       SELECT [makh]
                             ,[ten_kh]
                             ,[tuoi]
                             ,[gioiTinh]
                             ,[loai]
                         FROM [dbo].[khachHang]
                       WHERE tuoi >=18 and tuoi <=50
                       """;
//        B2: Mo connection
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            //B3: Statement : là 1 interface cho phép gửi các câu lệnh SQL tới Database
            //B4: Tạo resultSet: đại diện cho các tập hợp các record có được sau khi chạy sql
            
            ResultSet rs = ps.executeQuery();
            //B5: Tạo kiểu trả về
            
            //B6: Đọc data từ result set
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4), rs.getString(5));
              return khachHang;
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static List<KhachHang> sortByName() {
        // B1: Viết câu query
        String query = """
                       SELECT [makh]
                             ,[ten_kh]
                             ,[tuoi]
                             ,[gioiTinh]
                             ,[loai]
                         FROM [dbo].[khachHang]
                        ORDER BY ten_kh ASC
                       """;
//        B2: Mo connection
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            //B3: Statement : là 1 interface cho phép gửi các câu lệnh SQL tới Database
            //B4: Tạo resultSet: đại diện cho các tập hợp các record có được sau khi chạy sql
            ResultSet rs = ps.executeQuery();
            //B5: Tạo kiểu trả về
            List<KhachHang> list = new ArrayList<>();
            //B6: Đọc data từ result set
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4), rs.getString(5));
                list.add(khachHang);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
        List<KhachHang> list = new KhachHangRepository().readDB();
        for (KhachHang kh : list) {
            System.out.println(kh.toString());
        }
        KhachHang find = new KhachHangRepository().getTuoi();
        find.toString();
//        List<KhachHang> lists = new KhachHangRepository().sortByName();
//        for (KhachHang kh : lists) {
//            System.out.println(kh.toString());
//        }
    }
}
