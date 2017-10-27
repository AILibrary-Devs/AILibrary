/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.IODataListCollection;
import data.IODataList;
import common.BooleanOperator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kwl
 */
public class IODataListCollectionTest {

    public IODataListCollectionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("-- IODataListCollection: START");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("-- IODataListCollection: END\n");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of Constructor(IODataList), of class IODataListCollection.
     */
    @Test
    public void testConstructor() {
        System.out.println("Constructor - IODataList parameter");

        Double[] id = {0.11, 0.22, 0.33};
        Double[] od = {0.99, 0.88, 0.77, 0.66};

        IODataList iodl = IODataList.asDoubles(id, od);
        Double actual;

        for (int i = 0; i < iodl.getInputs().size(); i++) {
            actual = (Double) iodl.getInputs().get(i);
            //TODO - figure this damn Double cast issue out!!!
            assertEquals(actual, id[i]);

        }

        for (int i = 0; i < iodl.getOutputs().size(); i++) {
            actual = (Double) iodl.getOutputs().get(i);
            assertEquals(actual, od[i]);
        }
    }

    /**
     * Test of getTruthTable method, of class IODataListCollection.
     */
    @Test
    public void testGetTruthTable() {
        BooleanOperator operator = null;
        IODataListCollection iodlc = null;
        IODataList iodl;
        Double input1, input2, output;

        // ---- AND -----------
        System.out.println("getTruthTable.AND");
        operator = BooleanOperator.AND;
        iodlc = IODataListCollection.getTruthTableDouble(operator);

        for (Object o : iodlc) {
            iodl = (IODataList) o;

            input1 = iodl.getInputs().get(0);
            input2 = iodl.getInputs().get(1);
            
            output = iodl.getOutputs().get(0);

            if ((input1 == BooleanOperator.FALSE_DOUBLE_DEFAULT) || (input2 == BooleanOperator.FALSE_DOUBLE_DEFAULT)) {
                assertEquals(BooleanOperator.FALSE_DOUBLE_DEFAULT, output);
            } else {
                assertEquals(BooleanOperator.TRUE_DOUBLE_DEFAULT, output);
            }
        }

        // ---- OR -----------
        System.out.println("getTruthTable.OR");
        operator = BooleanOperator.OR;
        iodlc = IODataListCollection.getTruthTableDouble(operator);

        for (Object o : iodlc) {
            iodl = (IODataList) o;

            input1 = iodl.getInputs().get(0);
            input2 = iodl.getInputs().get(1);
            
            output = iodl.getOutputs().get(0);

            if ((input1 == BooleanOperator.TRUE_DOUBLE_DEFAULT) || (input2 == BooleanOperator.TRUE_DOUBLE_DEFAULT)) {
                assertEquals(BooleanOperator.TRUE_DOUBLE_DEFAULT, output);
            } else {
                assertEquals(BooleanOperator.FALSE_DOUBLE_DEFAULT, output);
            }
        }

        // ---- OR -----------
        System.out.println("getTruthTable.XOR");
        operator = BooleanOperator.XOR;
        iodlc = IODataListCollection.getTruthTableDouble(operator);

        for (Object o : iodlc) {
            iodl = (IODataList) o;

            input1 = iodl.getInputs().get(0);
            input2 = iodl.getInputs().get(1);
            
            output = iodl.getOutputs().get(0);

            if (input1 == input2) {
                assertEquals(BooleanOperator.FALSE_DOUBLE_DEFAULT, output);
            } else {
                assertEquals(BooleanOperator.TRUE_DOUBLE_DEFAULT, output);
            }
        }
    }

}
