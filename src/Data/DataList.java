/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author kwl
 * @param <E> type of the elements to be stored in the DataList
 */
public class DataList<E> extends ArrayList<E> {

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public DataList(){}
    
    public DataList(ArrayList<E> items){
        addAll(items);
    }
    
    public static DataList asDoubles(Double[] items){
        DataList<Double> dl = new DataList<>();
        dl.addAll(Arrays.asList(items));
        return dl;
    }   
//</editor-fold>
    
}
