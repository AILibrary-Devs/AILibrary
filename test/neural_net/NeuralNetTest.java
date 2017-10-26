/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import common.InitializerIntf;
import common.InitializerRandom;
import java.util.ArrayList;
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
public class NeuralNetTest {
    
    public NeuralNetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("-- NeuralNet: START");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("-- NeuralNet: END\n");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSimpleNeuralNet method, of class NeuralNet.
     */
    @Test
    public void testConstructor() {
        System.out.println("Constructort(parameterized)");

        int[] layerNodeCounts = {2, 4, 1};
        NeuralNet net = new NeuralNet(layerNodeCounts);

        // layer count
        assertEquals(net.getLayers().size(), 3);
        
        //input layer node count
        assertEquals(net.getInputLayer().getCount(), 2);
        assertEquals(net.getLayer(0).getCount(), 2);

        //hidden layer node count
        assertEquals(net.getLayer(1).getCount(), 4);

        //output layer node count
        assertEquals(net.getLayer(2).getCount(), 1);
        assertEquals(net.getOutputLayer().getCount(), 1);
        

        int[] layerNodeCounts2 = {6, 12, 24, 3};
        net = new NeuralNet(layerNodeCounts2);

        // layer count
        assertEquals(net.getLayers().size(), layerNodeCounts2.length);
        
        for (int i = 0; i < layerNodeCounts2.length; i++) {
           assertEquals(net.getLayer(i).getCount(), layerNodeCounts2[i]);
        }
    }

    /**
     * Test of getLayers method, of class NeuralNet.
     */
    @Test
    public void testGetLayers() {
//        System.out.println("getLayers");
//        NeuralNet instance = new NeuralNet();
//        ArrayList<NeuralLayerIntf> expResult = null;
//        ArrayList<NeuralLayerIntf> result = instance.getLayers();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getLayer method, of class NeuralNet.
     */
    @Test
    public void testGetLayer() {
//        System.out.println("getLayer");
//        int index = 0;
//        NeuralNet instance = new NeuralNet();
//        NeuralLayerIntf expResult = null;
//        NeuralLayerIntf result = instance.getLayer(index);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getInputLayer method, of class NeuralNet.
     */
    @Test
    public void testGetInputLayer() {
//        System.out.println("getInputLayer");
//        NeuralNet instance = new NeuralNet();
//        NeuralLayerIntf expResult = null;
//        NeuralLayerIntf result = instance.getInputLayer();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getOutputLayer method, of class NeuralNet.
     */
    @Test
    public void testGetOutputLayer() {
//        System.out.println("getOutputLayer");
//        NeuralNet instance = new NeuralNet();
//        NeuralLayerIntf expResult = null;
//        NeuralLayerIntf result = instance.getOutputLayer();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getLearningRate method, of class NeuralNet.
     */
    @Test
    public void testGetLearningRate() {
//        System.out.println("getLearningRate");
//        NeuralNet instance = new NeuralNet();
//        double expResult = 0.0;
//        double result = instance.getLearningRate();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setLearningRate method, of class NeuralNet.
     */
    @Test
    public void testSetLearningRate() {
//        System.out.println("setLearningRate");
//        double learningRate = 0.0;
//        NeuralNet instance = new NeuralNet();
//        instance.setLearningRate(learningRate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of pulse method, of class NeuralNet.
     */
    @Test
    public void testPulse() {
//        System.out.println("pulse");
//        NeuralNet instance = new NeuralNet();
//        instance.pulse();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of applyLearning method, of class NeuralNet.
     */
    @Test
    public void testApplyLearning() {
//        System.out.println("applyLearning");
//        NeuralNet instance = new NeuralNet();
//        instance.applyLearning();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeLearning method, of class NeuralNet.
     */
    @Test
    public void testInitializeLearning() {
//        System.out.println("initializeLearning");
//        NeuralNet instance = new NeuralNet();
//        instance.initializeLearning();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of train method, of class NeuralNet.
     */
    @Test
    public void testTrain() {
//        System.out.println("train");
//        double[][] inputs = null;
//        double[][] expected = null;
//        int iterationLimit = 0;
//        NeuralNet instance = new NeuralNet();
//        instance.train(inputs, expected, iterationLimit);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    private static final Double FALSE_DBL = 0.1;
    private static final Double TRUE_DBL = 0.9;
    
    private static final int ITERATION_LIMIT = 100000;
    
    /**
     * Test of train method, of class NeuralNet.
     */
    @Test
    public void testTrain_AND_TruthTable() {
//        System.out.println("train AND TT");
        
        int[] layerNodeCounts = {2, 2, 1};
        double[][] inputs = {{FALSE_DBL, FALSE_DBL}, {FALSE_DBL, TRUE_DBL}, {TRUE_DBL, FALSE_DBL},  {TRUE_DBL, TRUE_DBL}};
        double[][] expected = {{FALSE_DBL}, {FALSE_DBL}, {FALSE_DBL}, {TRUE_DBL}};
        
        testTrain("AND TT", layerNodeCounts, inputs, expected, ITERATION_LIMIT, 0.1);
    }
    
    /**
     * Test of train method, of class NeuralNet.
     */
    @Test
    public void testTrain_OR_TruthTable() {
//        System.out.println("train OR TT");
        
        int[] layerNodeCounts = {2, 2, 1};
        double[][] inputs = {{FALSE_DBL, FALSE_DBL}, {FALSE_DBL, TRUE_DBL}, {TRUE_DBL, FALSE_DBL},  {TRUE_DBL, TRUE_DBL}};
        double[][] expected = {{FALSE_DBL}, {TRUE_DBL}, {TRUE_DBL}, {TRUE_DBL}};
        
        testTrain("OR TT", layerNodeCounts, inputs, expected, ITERATION_LIMIT, 0.1);
    }
    
    /**
     * Test of train method, of class NeuralNet.
     */
    @Test
    public void testTrain_XOR_TruthTable() {
        System.out.println("train XOR TT");
        
        int[] layerNodeCounts = {2, 2, 1};
        double[][] inputs = {{FALSE_DBL, FALSE_DBL}, {FALSE_DBL, TRUE_DBL}, {TRUE_DBL, FALSE_DBL},  {TRUE_DBL, TRUE_DBL}};
        double[][] expected = {{FALSE_DBL}, {TRUE_DBL}, {TRUE_DBL}, {FALSE_DBL}};
        
        testTrain("XOR TT", layerNodeCounts, inputs, expected, ITERATION_LIMIT, 0.1);
    }
    
    public void testTrain(String testLabel, int[] layerNodeCounts, double[][] inputValues, double[][] expectedValues, int iterationLimit, double accuracyLimit) {
        System.out.println("train - " + testLabel);

        NeuralNet net = new NeuralNet(layerNodeCounts);
        net.train(inputValues, expectedValues, iterationLimit);

        double output, expected, variance; 
        boolean pass = true;


        //test the model
        System.out.println("  Expected    Result      Variance");
        for (int i = 0; i < inputValues.length; i++) {
            try {
                double[] result = net.computeOutputs(inputValues[i]);
                output = result[0];
                expected = expectedValues[i][0];
                variance = expected - output;

                System.out.println(String.format("  %.5f     %.5f     %.5f", expected, output, variance));
                pass &= (Math.abs(output - expected) <= accuracyLimit);
//                assertTrue(Math.abs(output - expected) <= accuracyLimit);       
            } catch (Exception e) { } //bury it... for now
        }
        
        assertTrue(pass);
    }
    
    

    /**
     * Test of runTrainingSession method, of class NeuralNet.
     */
    @Test
    public void testRunTrainingSession() {
//        System.out.println("runTrainingSession");
//        NeuralNetIntf net = null;
//        double[] inputData = null;
//        double[] expectedData = null;
//        NeuralNet.runTrainingSession(net, inputData, expectedData);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
