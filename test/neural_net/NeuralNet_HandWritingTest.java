/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import common.ImageTools;
import java.awt.Image;
import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kwl http://www.cs.nyu.edu/~roweis/data/
 */
public class NeuralNet_HandWritingTest {

    public NeuralNet_HandWritingTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("-- NeuralNet: Hand Wrtiting Test: START");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("-- NeuralNet: Hand Writing Test: END\n");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testHandwritingReconition(){
        System.out.println("testHandwritingRecognition)");

        int[] layerNodeCounts = {784, 16, 16, 10};
        NeuralNet net = new NeuralNet(layerNodeCounts);
        
        Image source;
        Image[] trainingImages;
        double[] inputData;
        int input;
        
        //train against all numbers
        for (int i = 0; i < 10; i++) {
            double[] expectedData = new double[10];
            expectedData[i] = 1.0;
            System.out.printf("%d) %s", i, expectedData.toString());
            
            source = ImageTools.loadImageFromResource(String.format("neural_net/mnist_train%d.jpg", i));
            trainingImages = ImageTools.getSubimageArray(source, 76, 77); //remove last column: final few are bad data
            
            for (Image image : trainingImages){
                inputData = ImageTools.imageToDoubleRowColArray((BufferedImage)image);
                net.train(inputData, expectedData, 1);
            }
        }

        int count, passCount;
        int totalCount = 0;
        int totalPassCount = 0;
        boolean pass;
        
        for (int number = 0; number < 10; number++) {
            double[] outputData;// = new double[10];
            count = 0;
            passCount = 0;

            source = ImageTools.loadImageFromResource(String.format("neural_net/mnist_test%d.jpg", number));
            trainingImages = ImageTools.getSubimageArray(source, 30, 32);

            for (Image image : trainingImages){
                count++;
                inputData = ImageTools.imageToDoubleRowColArray((BufferedImage)image);
                try {
                    outputData = net.computeOutputs(inputData);
                    
                    pass = true;
                    for (int idx = 0; idx < outputData.length; idx++) {
                        pass &= (outputData[number] >= outputData[idx]);
                    }
                    
                    if (pass) {
                        passCount++;
                    }
                    
                } catch (Exception e) {
                }
            }
            
            System.out.printf("%d) %d of %d passed\n", number, passCount, count);
            totalCount += count;
            totalPassCount += passCount;
        }
        
        double percentPass = (100.0 * totalPassCount / totalCount);
        System.out.printf("ALL: %d of %d passed : %.1f %%\n", totalPassCount, totalCount, percentPass);
        assertTrue(percentPass >= 90.0);   
    }
    

}
