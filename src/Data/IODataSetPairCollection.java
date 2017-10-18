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
 */
public class IODataSetPairCollection implements Iterable<IODataSetPair> {

//<editor-fold defaultstate="collapsed" desc="Constructors and Factory Methods">
    {
        dataSetPairs = new ArrayList<>();
    }

    public IODataSetPairCollection(ArrayList<IODataSetPair> dataSetPairs) {
        this.dataSetPairs = dataSetPairs;
    }

    public static IODataSetPairCollection getIODataSetPairCollectionTruthTable(TruthTableType type) {
        return getIODataSetPairCollectionTruthTable(type, 0.9, 0.1);
    }

    public static IODataSetPairCollection getIODataSetPairCollectionTruthTable(TruthTableType type, Double trueValue, Double falseValue) {
        ArrayList<Boolean> values = new ArrayList<>(Arrays.asList(false, true));

        ArrayList<IODataSetPair> dataSetPairs = new ArrayList<>();

        values.forEach((b1) -> {
            ArrayList<Double> inputs = new ArrayList<>();
            ArrayList<Double> outputs = new ArrayList<>();

//            values.forEach(action);for (Boolean b2 : values) {
            for (Boolean b2 : values) {
                inputs.add(translate(b1));
                inputs.add(translate(b2));

                outputs.add(translate(type.getValue(b1, b2)));
            }

            dataSetPairs.add(new IODataSetPair(new DataSet(inputs), new DataSet(outputs)));
        });

        return new IODataSetPairCollection(dataSetPairs);
    }

    private static final Double TRUE_DOUBLE = 0.9;
    private static final Double FALSE_DOUBLE = 0.1;

    private static Double translate(Boolean value) {
        return value ? TRUE_DOUBLE : FALSE_DOUBLE;
    }
    
//    public static IODataSetPairCollection getIODataDouble(Double[][] inputs, Double[][] outputs) {
//        ArrayList<IODataSetPair> dataSetPairs = new ArrayList<>();
//
//        return new IODataSetPairCollection(null);
//    }
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Properties">
    ArrayList<IODataSetPair> dataSetPairs;

    public int size() {
        return dataSetPairs.size();
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Iterable Methods">
    @Override
    public Iterator<IODataSetPair> iterator() {
        return dataSetPairs.iterator();
    }
    
    @Override
    public void forEach(Consumer<? super IODataSetPair> action) {
        dataSetPairs.forEach(action);
    }
//</editor-fold>
}
