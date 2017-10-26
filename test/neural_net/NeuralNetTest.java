/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

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
    }
    
    @AfterClass
    public static void tearDownClass() {
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
    public void testGetSimpleNeuralNet() {
        System.out.println("getSimpleNeuralNet");
        int inputLayerCount = 0;
        int transformLayerCount = 0;
        int outputLayerCount = 0;
        NeuralNetIntf expResult = null;
        NeuralNetIntf result = NeuralNet.getSimpleNeuralNet(inputLayerCount, transformLayerCount, outputLayerCount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLayers method, of class NeuralNet.
     */
    @Test
    public void testGetLayers() {
        System.out.println("getLayers");
        NeuralNet instance = new NeuralNet();
        ArrayList<NeuralLayerIntf> expResult = null;
        ArrayList<NeuralLayerIntf> result = instance.getLayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLayer method, of class NeuralNet.
     */
    @Test
    public void testGetLayer() {
        System.out.println("getLayer");
        int index = 0;
        NeuralNet instance = new NeuralNet();
        NeuralLayerIntf expResult = null;
        NeuralLayerIntf result = instance.getLayer(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInputLayer method, of class NeuralNet.
     */
    @Test
    public void testGetInputLayer() {
        System.out.println("getInputLayer");
        NeuralNet instance = new NeuralNet();
        NeuralLayerIntf expResult = null;
        NeuralLayerIntf result = instance.getInputLayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOutputLayer method, of class NeuralNet.
     */
    @Test
    public void testGetOutputLayer() {
        System.out.println("getOutputLayer");
        NeuralNet instance = new NeuralNet();
        NeuralLayerIntf expResult = null;
        NeuralLayerIntf result = instance.getOutputLayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLearningRate method, of class NeuralNet.
     */
    @Test
    public void testGetLearningRate() {
        System.out.println("getLearningRate");
        NeuralNet instance = new NeuralNet();
        double expResult = 0.0;
        double result = instance.getLearningRate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLearningRate method, of class NeuralNet.
     */
    @Test
    public void testSetLearningRate() {
        System.out.println("setLearningRate");
        double learningRate = 0.0;
        NeuralNet instance = new NeuralNet();
        instance.setLearningRate(learningRate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pulse method, of class NeuralNet.
     */
    @Test
    public void testPulse() {
        System.out.println("pulse");
        NeuralNet instance = new NeuralNet();
        instance.pulse();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of applyLearning method, of class NeuralNet.
     */
    @Test
    public void testApplyLearning() {
        System.out.println("applyLearning");
        NeuralNet instance = new NeuralNet();
        instance.applyLearning();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeLearning method, of class NeuralNet.
     */
    @Test
    public void testInitializeLearning() {
        System.out.println("initializeLearning");
        NeuralNet instance = new NeuralNet();
        instance.initializeLearning();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of train method, of class NeuralNet.
     */
    @Test
    public void testTrain() {
        System.out.println("train");
        double[][] inputs = null;
        double[][] expected = null;
        int iterationLimit = 0;
        NeuralNet instance = new NeuralNet();
        instance.train(inputs, expected, iterationLimit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of runTrainingSession method, of class NeuralNet.
     */
    @Test
    public void testRunTrainingSession() {
        System.out.println("runTrainingSession");
        NeuralNetIntf net = null;
        double[] inputData = null;
        double[] expectedData = null;
        NeuralNet.runTrainingSession(net, inputData, expectedData);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
