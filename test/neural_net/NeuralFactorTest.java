/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kwl
 */
public class NeuralFactorTest {
    
    public NeuralFactorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("-- NeuralFactorTest: START");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("-- Constructor: END");
    }
    
    /**
     * Test of getWeight method, of class NeuralFactor.
     */
    @Test
    public void testGetWeight() {
        System.out.println("---- getWeight");
        double expResult = 3.0;
        NeuralFactor instance = new NeuralFactor(expResult);
        
        double result = instance.getWeight();
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of setWeight method, of class NeuralFactor.
     */
    @Test
    public void testSetWeight() {
        System.out.println("---- getWeight");
        double expResult = 2.2;
        NeuralFactor instance = new NeuralFactor(expResult);
        
        double result = instance.getWeight();
        assertEquals(expResult, result, 0.00001);
        
        expResult = 1.5;
        instance.setWeight(expResult);
        result = instance.getWeight();
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of getDelta method, of class NeuralFactor.
     */
    @Test
    public void testGetDelta() {
        System.out.println("---- getDelta");

        NeuralFactor instance = new NeuralFactor(1.5);
        
        double expResult = NeuralFactor.DEFAULT_DELTA;
        double result = instance.getDelta();
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of setDelta method, of class NeuralFactor.
     */
    @Test
    public void testSetDelta() {
        System.out.println("---- setDelta");
        NeuralFactor instance = new NeuralFactor(1.5);
        
        double expResult = NeuralFactor.DEFAULT_DELTA;
        double result = instance.getDelta();
        assertEquals(expResult, result, 0.00001);
        
        expResult = 0.8;
        instance.setDelta(expResult);
        result = instance.getDelta();
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of addDelta method, of class NeuralFactor.
     */
    @Test
    public void testAddDelta() {
        System.out.println("---- addDelta");
        NeuralFactor instance = new NeuralFactor(1.5);
                
        double expResult = 0.7;
        instance.setDelta(expResult);
        double result = instance.getDelta();
        assertEquals(expResult, result, 0.00001);
        
        expResult = 0.9;
        instance.addDelta(0.2);
        result = instance.getDelta();
        assertEquals(expResult, result, 0.00001);

        expResult = 0.5;
        instance.addDelta(-0.4);
        result = instance.getDelta();
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of getLastDelta method, of class NeuralFactor.
     */
    @Test
    public void testGetLastDelta() {
        System.out.println("---- testGetLastDelta");
        NeuralFactor instance = new NeuralFactor(1.5);
                
        double expResult = 1.1;
        double result;
        
        instance.setDelta(expResult);
        instance.applyWeightChange(1.0); //move current delta to the lastDelta

        result = instance.getDelta();
        assertEquals(expResult, result, 0.00001);
        result = instance.getLastDelta();
        assertEquals(expResult, result, 0.00001);

        instance.setDelta(1.6);
        result = instance.getDelta();
        assertEquals(1.6, result, 0.00001);
        result = instance.getLastDelta();
        assertEquals(expResult, result, 0.00001);

        instance.resetWeightChange();
        result = instance.getDelta();
        assertEquals(NeuralFactor.DEFAULT_DELTA, result, 0.00001);
        result = instance.getLastDelta();
        assertEquals(NeuralFactor.DEFAULT_DELTA, result, 0.00001);
    }

    /**
     * Test of applyWeightChange method, of class NeuralFactor.
     */
    @Test
    public void testApplyWeightChange() {
//        System.out.println("applyWeightChange");
//        double learningRate = 0.0;
//        NeuralFactor instance = null;
//        instance.applyWeightChange(learningRate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of resetWeightChange method, of class NeuralFactor.
     */
    @Test
    public void testResetWeightChange() {
        System.out.println("---- resetWeightChange");
        NeuralFactor instance = new NeuralFactor(1.5);
                
        double expResult = 1.1;
        double result;
        
        instance.setDelta(expResult);
        instance.applyWeightChange(1.0); //move current delta to the lastDelta

        result = instance.getDelta();
        assertEquals(expResult, result, 0.00001);
        result = instance.getLastDelta();
        assertEquals(expResult, result, 0.00001);

        instance.setDelta(1.6);
        result = instance.getDelta();
        assertEquals(1.6, result, 0.00001);
        result = instance.getLastDelta();
        assertEquals(expResult, result, 0.00001);

        instance.resetWeightChange();
        result = instance.getDelta();
        assertEquals(NeuralFactor.DEFAULT_DELTA, result, 0.00001);
        result = instance.getLastDelta();
        assertEquals(NeuralFactor.DEFAULT_DELTA, result, 0.00001);
    }
    
}
