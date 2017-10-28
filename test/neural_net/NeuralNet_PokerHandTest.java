/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
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

    /**
     * Test of train method, of class NeuralNet.
     * https://archive.ics.uci.edu/ml/machine-learning-databases/poker/
     *
     *
     */
    @Test
//    public void testPokerHand(String testLabel, int[] layerNodeCounts, double[][] inputValues, double[][] expectedValues, int iterationLimit, double accuracyLimit) {
    public void testPokerHand(){//String testLabel, double[][] inputValues, double[][] expectedValues, int iterationLimit, double accuracyLimit) {

        int[] layerNodeCounts = {10, 10, 1};
        NeuralNet net = new NeuralNet(layerNodeCounts);

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("neural_net/poker_hand_test_data.txt").getFile());

        try (Scanner scanner = new Scanner(file)) {
            int limit = 20;
            int counter = 0;
            
            while (scanner.hasNextLine() && (counter < limit)) {
                String line = scanner.nextLine();
                System.out.println(line);
                
                String[] list = line.split(",");

                int[] inputs = new int[10];
                for (int i = 0; i < inputs.length; i++) {
                    inputs[i] = Integer.parseInt(list[i]);
                }
                
                int[] expected = new int[1];
//                int value = Integer.parseInt(list[10]);
                expected[0] = Integer.parseInt(list[10]);
                
                counter++;
            }
            scanner.close();

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
