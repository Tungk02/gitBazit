/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Sach;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public class SachService {
    List<Sach> listS = new ArrayList<>();

    public SachService() {
    }
    public List<Sach> getList(){
        return listS;
    }
    public void add(Sach s){
        listS.add(s);
    }
    public void delete(int index){
        listS.remove(index);
    }
}
