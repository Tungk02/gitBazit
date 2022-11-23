/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B8_BaiMauCRUD_1Bang.repository;

import B8_BaiMauCRUD_1Bang.domainmodel.Category;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Bânbân
 */
public class CategoryRepository {

    //CRUD:
    // R: READ <=> Select
    public List<Category> getAll() {
        //B1: Viet cau query
        String query = """
                      SELECT [id]
                           ,[category_code]
                           ,[category_name]
                      FROM [dbo].[category]
                      """;
        //B2:Mở connection 
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            // B3: Statement : là 1 interface cho phép
            //gửi các câu lệnh SQL tới Database
            //B4: Tạo resultSet: đại diện cho các tập hợp các 
            // record (bản ghi) có được sau khi chạy sql
            ResultSet rs = ps.executeQuery();
            //B5: Tạo kiểu trả về
            List<Category> lists = new ArrayList<>();
            //B6: Đọc data từ result set
            while (rs.next()) {
                Category category = new Category(rs.getLong(1), rs.getString(2), rs.getString(3));
                lists.add(category);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Category getOne(Long id) {
        //B1: Viet cau query
        String query = """
                      SELECT [id]
                           ,[category_code]
                           ,[category_name]
                      FROM [dbo].[category]
                      WHERE id = ?
                      """;
        //B2:Mở connection 
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            // B3: Statement : là 1 interface cho phép
            //gửi các câu lệnh SQL tới Database
            //B4: Tạo resultSet: đại diện cho các tập hợp các 
            // record (bản ghi) có được sau khi chạy sql
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            //B5: Tạo kiểu trả về
            //B6: Đọc data từ result set
            if (rs.next()) {
                Category category = new Category(rs.getLong(1), rs.getString(2), rs.getString(3));
                return category;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        List<Category> lists = new CategoryRepository().getAll();
        for (Category c : lists) {
            System.out.println(c.toString());
        }
    }
}
