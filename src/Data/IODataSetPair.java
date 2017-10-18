/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author kwl
 */
public class IODataSetPair implements IODataSetPairIntf {

//<editor-fold defaultstate="collapsed" desc="Constructors and Factory Methods">
    public IODataSetPair(DataSet inputs, DataSet outputs){
        this.inputs = inputs;
        this.outputs = outputs;
    }
    
    public static IODataSetPair getIODataSetPairDouble(Double[] inputs, Double[] outputs){
        return new IODataSetPair(new DataSet(inputs), new DataSet(inputs));
    }        
//</editor-fold> 
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private final DataSet inputs;
    private final DataSet outputs;
    
    @Override
    public DataSet getInputs() {
        return inputs;
    }
    
    @Override
    public DataSet getOutputs() {
        return outputs;
    }
//</editor-fold>

}
