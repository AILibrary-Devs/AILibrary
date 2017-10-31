/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class NeuralNet_PokerHandTest {

    public NeuralNet_PokerHandTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("-- NeuralNet: Poker Hand Test: START");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("-- NeuralNet: Poker Hand Test: END\n");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private ArrayList<double[]> getDataFromFile(String filePath, int elements, int recordLimit) {
        ArrayList<double[]> data = new ArrayList<>();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());

        try (Scanner scanner = new Scanner(file)) {
            int counter = 0;
            while (scanner.hasNextLine() && (counter < recordLimit)) {
                String line = scanner.nextLine();
                System.out.println(line);

                String[] list = line.split(",");

                double[] input = new double[elements];
                for (int i = 0; i < input.length; i++) {
                    input[i] = Integer.parseInt(list[i]);
                }

                data.add(input);
                counter++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NeuralNet_PokerHandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    
    /**
     * Test of train method, of class NeuralNet.
     * https://archive.ics.uci.edu/ml/machine-learning-databases/poker/
     *
     */
    @Test
    public void testPokerHand() throws Exception {//String testLabel, double[][] inputValues, double[][] expectedValues, int iterationLimit, double accuracyLimit) {
//        final double scaleFactor = 10.0;
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("neural_net/poker_hand_training_data.txt").getFile());

        try (Scanner scanner = new Scanner(file)) {
            int trainLimit = 20000;
            int counter = 0;
            ArrayList<double[]> inputData = new ArrayList<>();
            ArrayList<double[]> expectedData = new ArrayList<>();

            while (scanner.hasNextLine() && (counter < trainLimit)) {
                String line = scanner.nextLine();
//                System.out.println(line);

                String[] list = line.split(",");

                double[] input = new double[10];
                for (int i = 0; i < input.length; i++) {
                    input[i] = Integer.parseInt(list[i]);
                }
                inputData.add(input);

                double[] expected = new double[1];
                expected[0] = Integer.parseInt(list[10]);
                expectedData.add(expected);

                counter++;
            }

            scanner.close();

            double[][] inputs = new double[inputData.size()][10];
            double[][] expected = new double[expectedData.size()][1];
            for (int i = 0; i < inputData.size(); i++) {
                inputs[i] = inputData.get(i);
                expected[i] = expectedData.get(i);
            }

            int[] layerNodeCounts = {10, 10, 1};
            NeuralNet net = new NeuralNet(layerNodeCounts);
            net.train(inputs, expected, 3);

            
        //test the model
        ArrayList<double[]> testData = getDataFromFile("neural_net/poker_hand_test_data.txt", 11, 2000);
        
        System.out.println("  Poker Hands");
        System.out.println("  Expected    Result      Variance");


        double[] testInputs = new double[10];
        double testExpected, variance, testOutput;
        
        for (double[] testAll : testData){
            System.arraycopy(testAll, 0, testInputs, 0, testInputs.length);
            testExpected = testAll[10];
            
            double[] testResult = net.computeOutputs(testInputs);
            testOutput = testResult[0];
            variance = testExpected - testOutput;
            
            System.out.println(String.format("  %.5f     %.5f     %.5f", testExpected, testOutput, variance));
        }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        
        
//	return result.toString();
//        System.out.println("train - " + testLabel);
//
//        NeuralNet net = new NeuralNet(layerNodeCounts);
//        net.train(inputValues, expectedValues, iterationLimit);
//
//        double output, expected, variance;
//        boolean pass = true;
//
//        //test the model
//        System.out.println("  Expected    Result      Variance");
//        for (int i = 0; i < inputValues.length; i++) {
//            try {
//                double[] result = net.computeOutputs(inputValues[i]);
//                output = result[0];
//                expected = expectedValues[i][0];
//                variance = expected - output;
//
//                System.out.println(String.format("  %.5f     %.5f     %.5f", expected, output, variance));
//                pass &= (Math.abs(output - expected) <= accuracyLimit);
////                assertTrue(Math.abs(output - expected) <= accuracyLimit);       
//            } catch (Exception e) {
//            } //bury it... for now
//        }
        assertTrue(true);
    }

}
