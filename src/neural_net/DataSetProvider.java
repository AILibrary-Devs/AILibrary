/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import java.util.ArrayList;

/**
 *
 * @author kwl
 */
public class DataSetProvider {

    public DataSetProvider(double[] data){
        this.data = data;
    }

//<editor-fold defaultstate="collapsed" desc="Properties">
    private double[] data;
    private ArrayList<Double> other;
    
    private Double[] test(){
        return other.toArray(new Double[other.size()]);
    }
    
    /**
     * @return the data
     */
    public double[] getData() {
        return data;
    }
    
    /**
     * @param data the data to set
     */
    public void setData(double[] data) {
        this.data = data;
    }
//</editor-fold>
    
}
