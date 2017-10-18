/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author kwl
 * @param <T> the Type T of data to be contained in this structure
 */
public class DataSet<T> implements Iterable<T> {

//<editor-fold defaultstate="collapsed" desc="Constructors">
    {
        dataset = new ArrayList<>();
    }
    
    public DataSet(ArrayList<T> data){
        this.dataset.addAll(data);
    };

    public static DataSet getDataSetDouble(Double[] dataArray){
        ArrayList<Double> data = new ArrayList<>();
        data.addAll(Arrays.asList(dataArray));
        return new DataSet(data);
    };
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private final ArrayList<T> dataset;
    
    public int size() {
        return dataset.size();
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Iterable Interface Methods">
    @Override
    public Iterator<T> iterator() {
        return dataset.iterator();
    }
    
    @Override
    public void forEach(Consumer<? super T> action) {
        dataset.forEach(action);
    }
//</editor-fold>
    
}
