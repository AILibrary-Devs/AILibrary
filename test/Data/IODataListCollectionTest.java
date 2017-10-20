/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

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

//        public IODataListCollection(ArrayList<IODataList> dataSetPairs) {
//        this.addAll(dataSetPairs);
//    }

    
    
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
            actual = (Double)iodl.getInputs().get(i);
            //TODO - figure this damn Double cast issue out!!!
            assertEquals(actual, id[i]);
            
        }
        
        for (int i = 0; i < iodl.getOutputs().size(); i++) {
            actual = (Double)iodl.getOutputs().get(i);
            assertEquals(actual, id[i]);
        }
    }
    
    /**
     * Test of getTruthTable method, of class IODataListCollection.
     */
    @Test
    public void testGetTruthTable() {
        System.out.println("getTruthTable");
        BooleanOperator operator = null;
        IODataListCollection expResult = null;
        IODataListCollection result = IODataListCollection.getTruthTable(operator);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
