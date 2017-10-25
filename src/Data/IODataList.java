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
public class IODataList {

//<editor-fold defaultstate="collapsed" desc="Constructors and Factory Methods">
    public IODataList(DataList<Double> inputs, DataList<Double> outputs){
        this.inputs = inputs;
        this.outputs = outputs;
    }
    
    public static IODataList asDoubles(Double[] inputs, Double[] outputs){
        return new IODataList(DataList.asDoubles(inputs), DataList.asDoubles(outputs));
    }        
//</editor-fold> 
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private final DataList<Double> inputs;
    private final DataList<Double> outputs;
    
    public DataList<Double> getInputs() {
        return inputs;
    }
    
    public DataList<Double> getOutputs() {
        return outputs;
    }
//</editor-fold>

}
