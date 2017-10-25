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
//public class IODataListCollection<IODataList> extends ArrayList<IODataList> {
public class IODataListCollection extends ArrayList {
    
//<editor-fold defaultstate="collapsed" desc="Constructors and Factory Methods">
    public IODataListCollection(ArrayList<IODataList> dataSetPairs) {
        this.addAll(dataSetPairs);
    }
    
    public static IODataListCollection getTruthTableDouble(BooleanOperator operator) {
        ArrayList<Boolean> boolValues = new ArrayList<>(Arrays.asList(false, true));
        
        ArrayList<IODataList> ioDataLists = new ArrayList<>();
        IODataList ioData;
        
        boolValues.forEach((b1) -> {
            ArrayList<Double> inputs = new ArrayList<>();
            ArrayList<Double> outputs = new ArrayList<>();
            
            for (Boolean b2 : boolValues) {
                inputs.add(BooleanOperator.toDouble(b1));
                inputs.add(BooleanOperator.toDouble(b2));
                
                outputs.add(BooleanOperator.toDouble(operator.operate(b1, b2)));
            }
            
            ioDataLists.add(new IODataList(new DataList<Double>(inputs), new DataList<Double>(outputs)));
        });
        
        return new IODataListCollection(ioDataLists);
    }
//</editor-fold>
}
