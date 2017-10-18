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
 * @param <T>
 */
public class IODataSetPair<T> implements IODataSetPairIntf {

//<editor-fold defaultstate="collapsed" desc="Constructors and Factory Methods">
    public IODataSetPair(DataSet<T> inputs, DataSet<T> outputs){
        this.inputs = inputs;
        this.outputs = outputs;
    }
    
    public static IODataSetPair<Double> getIODataSetPairDouble(Double[] inputs, Double[] outputs){
        return new IODataSetPair(DataSet.getDataSetDouble(inputs), DataSet.getDataSetDouble(inputs));
    }
        
//</editor-fold> 
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private final DataSet<T> inputs;
    private final DataSet<T> outputs;
    
    @Override
    public int size() {
        return inputs.size();
    }
    
    @Override
    public Iterable getInputs() {
        return inputs;
    }
    
    @Override
    public Iterable getOutputs() {
        return outputs;
    }
//</editor-fold>

}
