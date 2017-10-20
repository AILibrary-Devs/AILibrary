/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import common.BooleanOperator;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author kwl
 */
public class IODataListCollection extends ArrayList {
    
//<editor-fold defaultstate="collapsed" desc="Constructors and Factory Methods">
    public IODataListCollection(ArrayList<IODataList> dataSetPairs) {
        this.addAll(dataSetPairs);
    }
    
    public static IODataListCollection getTruthTable(BooleanOperator operator) {
        ArrayList<Boolean> boolValues = new ArrayList<>(Arrays.asList(false, true));
        
        ArrayList<IODataList> ioData = new ArrayList<>();
        
        boolValues.forEach((b1) -> {
            ArrayList<Double> inputs = new ArrayList<>();
            ArrayList<Double> outputs = new ArrayList<>();
            
            for (Boolean b2 : boolValues) {
                inputs.add(BooleanOperator.toDouble(b1));
                inputs.add(BooleanOperator.toDouble(b2));
                
                outputs.add(BooleanOperator.toDouble(operator.operate(b1, b2)));
            }
            
            ioData.add(new IODataList(new DataList(inputs), new DataList(outputs)));
        });
        
        return new IODataListCollection(ioData);
    }
//</editor-fold>
}
