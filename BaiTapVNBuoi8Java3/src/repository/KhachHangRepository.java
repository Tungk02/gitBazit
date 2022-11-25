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

    public  List<KhachHang> readDB() {
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
    public List<KhachHang> getTuoi(int min, int max) {
        
        // B1: Viết câu query
        String query = """
                       SELECT [makh]
                             ,[ten_kh]
                             ,[tuoi]
                             ,[gioiTinh]
                             ,[loai]
                         FROM [dbo].[khachHang]
                       WHERE tuoi >=? and tuoi <=?
                       """;
//        B2: Mo connection
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            //B3: Statement : là 1 interface cho phép gửi các câu lệnh SQL tới Database
            //B4: Tạo resultSet: đại diện cho các tập hợp các record có được sau khi chạy sql
            ps.setObject(1, min);
            ps.setObject(2, max);
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
    public  List<KhachHang> sortByName() {
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
    public boolean add(KhachHang kh){
        int check = 0;
        String query ="""
                      INSERT INTO [dbo].[khachHang]
                                 ([makh]
                                 ,[ten_kh]
                                 ,[tuoi]
                                 ,[gioiTinh]
                                 ,[loai])
                           VALUES
                                 (?,?,?,?,?)
                      """;
        try(Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1,kh.getMakh());
            ps.setObject(2,kh.getTenkh());
            ps.setObject(3,kh.getTuoi());
            ps.setObject(4,kh.isGioiTinh());
            ps.setObject(5,kh.getLoai());
            check = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean update(String makh,KhachHang kh){
        int check = 0;
        String query ="""
                      UPDATE [dbo].[khachHang]
                         SET 
                             [ten_kh] = ?
                            ,[tuoi] = ?
                            ,[gioiTinh] = ?
                            ,[loai] = ?
                       WHERE makh = ?
                      """;
        try(Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(5,makh);
            ps.setObject(1,kh.getTenkh());
            ps.setObject(2,kh.getTuoi());
            ps.setObject(3,kh.isGioiTinh());
            ps.setObject(4,kh.getLoai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean delete(String makh){
        int check = 0;
        String query ="""
                      DELETE FROM [dbo].[khachHang]
                            WHERE makh = ?
                      """;
        try(Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1,makh);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public static void main(String[] args) {
        List<KhachHang> list = new KhachHangRepository().readDB();
        for (KhachHang kh : list) {
            System.out.println(kh.toString());
        }
//        List<KhachHang> lists = new KhachHangRepository().getTuoi(22, 50);
//        for (KhachHang kh : list) {
//            System.out.println(kh.toString());
//        }
//        List<KhachHang> lists = new KhachHangRepository().sortByName();
//        for (KhachHang kh : lists) {
//            System.out.println(kh.toString());
//        }
//          KhachHang kh = new KhachHang("KH07", "Vo Ha tram", 29, false,"VIP");
//           boolean update = new KhachHangRepository().update("KH03", kh);
//          System.out.println(update);
    }
}
