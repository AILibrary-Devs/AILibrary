/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

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
public class IODataListTest {
    
    public IODataListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("-- IODataList: START");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("-- IODataList: END\n");
    }
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIODataSetPairDouble method, of class IODataList.
     */
    @Test
    public void testAsDoubles() {
        System.out.println("asDoubles");

        Double[] inputs = {0.1, 0.2, 0.3, 0.4};
        Double[] outputs = {0.5, 0.6, 0.7};
        IODataList iolDoubles = IODataList.asDoubles(inputs, outputs);

        assertEquals(inputs.length, inputs.length);

        for (int i = 0; i < iolDoubles.getInputs().size(); i++) {
            assertEquals(iolDoubles.getInputs().get(i), inputs[i]);
        }
        
        assertEquals(outputs.length, outputs.length);

        for (int i = 0; i < iolDoubles.getOutputs().size(); i++) {
            assertEquals(iolDoubles.getOutputs().get(i), outputs[i]);
        }

        Double input = 0.1;
        assertEquals(input, iolDoubles.getInputs().get(0));
    }

    /**
     * Test of getInputs method, of class IODataList.
     */
    @Test
    public void testGetInputs() {
        System.out.println("getInputs");
        Double[] inputs = {0.1, 0.2, 0.3, 0.4};
        Double[] outputs = {0.5, 0.6, 0.7};
        IODataList iolDoubles = IODataList.asDoubles(inputs, outputs);

        assertEquals(inputs.length, inputs.length);

        for (int i = 0; i < iolDoubles.getInputs().size(); i++) {
            assertEquals(iolDoubles.getInputs().get(i), inputs[i]);
        }
    }

    /**
     * Test of getOutputs method, of class IODataList.
     */
    @Test
    public void testGetOutputs() {
        System.out.println("getOutputs");
        Double[] inputs = {0.1, 0.2, 0.3, 0.4};
        Double[] outputs = {0.5, 0.6, 0.7};
        IODataList iolDoubles = IODataList.asDoubles(inputs, outputs);

        assertEquals(outputs.length, outputs.length);

        for (int i = 0; i < iolDoubles.getOutputs().size(); i++) {
            assertEquals(iolDoubles.getOutputs().get(i), outputs[i]);
        }
    }
    
}
