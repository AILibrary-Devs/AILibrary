/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
public class ImageToolboxTest {

    public ImageToolboxTest() {
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
     * Test of loadImageFromResource method, of class ImageTools.
     */
    @Test
    public void testLoadImageFromResource() {
        System.out.println("loadImageFromResource");
        String resourcePath = "neural_net/mnist_test0.jpg";
        Image expResult = null;
        Image result = ImageTools.loadImageFromResource(resourcePath);

        BufferedImage bi = (BufferedImage) result;
//        Color clr = new Color();

//        System.out.println(bi.getHeight());
//        System.out.println(bi.getWidth());

//        assertEquals(expResult, result);
    }

    /**
     * Test of getSubimageArray method, of class ImageTools.
     */
    @Test
    public void testGetSubimageArray() {
        System.out.println("getSubimageArray");

        int xCount = 31;
        int yCount = 32;
        String resourcePath = "neural_net/mnist_test0.jpg";

        Image image = ImageTools.loadImageFromResource(resourcePath);
        Image[] images = ImageTools.getSubimageArray(image, xCount, yCount);

        for (Image img : images) {
            BufferedImage bi = (BufferedImage) img;

//            System.out.println(bi.getHeight());
//            System.out.println(bi.getWidth());
        }

//        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getSubimageArrays method, of class ImageTools.
     */
    @Test
    public void testGetSubimageArrays() {
        System.out.println("getSubimageArray");

        String resourcePath = "neural_net/mnist_test0.jpg";
        Image image = ImageTools.loadImageFromResource(resourcePath);

        int xCount = 31;
        int yCount = 32;
        Image[][] images = ImageTools.getSubimageArrays(image, xCount, yCount);

        for (int i = 0; i < images.length; i++) {
            for (int j = 0; j < images[i].length; j++) {
                BufferedImage bi = (BufferedImage) images[i][j];
//                System.out.printf("[%d, %d] (%d, %d)\n", i, j, bi.getWidth(), bi.getHeight());
            }
        }

//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
//        private static int[][] imageToRowColInt(BufferedImage image) {

      /**
     * Test of getSubimageArrays method, of class ImageTools.
     */
    @Test
    public void testImageToIntRowColArrays() {
        System.out.println("imageToIntRowColArrays");

        int xCount = 31;
        int yCount = 32;
        String resourcePath = "neural_net/mnist_test0.jpg";

        Image srcImage = ImageTools.loadImageFromResource(resourcePath);
        Image[] images = ImageTools.getSubimageArray(srcImage, xCount, yCount);

        Image image = images[0];
        int[][] imageArrays = ImageTools.imageToIntRowColArrays((BufferedImage) images[0]);
        int[] argb;
        
        for (int row = 0; row < imageArrays.length; row++) {
            for (int col = 0; col < imageArrays[row].length; col++) {
                argb = ImageTools.getARGB(imageArrays[row][col]);
                System.out.printf("[%d, %d] %d : %s : [A %d] [R %d] [G %d] [B %d] \n", row, col, imageArrays[row][col], Integer.toHexString(imageArrays[row][col]), argb[0], argb[1], argb[2], argb[3]);
            }
        }
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
  

}
