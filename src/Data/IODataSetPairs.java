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
public class IODataSetPairs extends ArrayList {
    public IODataSetPairs(ArrayList<IODataSetPair> dataSetPairs) {
        this.addAll(dataSetPairs);
    }

    public static IODataSetPairs getTruthTable(BooleanOperator operator) {
        ArrayList<Boolean> values = new ArrayList<>(Arrays.asList(false, true));

        ArrayList<IODataSetPair> dataSetPairs = new ArrayList<>();

        values.forEach((b1) -> {
            ArrayList<Double> inputs = new ArrayList<>();
            ArrayList<Double> outputs = new ArrayList<>();

            for (Boolean b2 : values) {
                inputs.add(BooleanOperator.toDouble(b1));
                inputs.add(BooleanOperator.toDouble(b2));

                outputs.add(BooleanOperator.toDouble(operator.operate(b1, b2)));
            }

            dataSetPairs.add(new IODataSetPair(new DataSet(inputs), new DataSet(outputs)));
        });

        return new IODataSetPairs(dataSetPairs);
    }

}
