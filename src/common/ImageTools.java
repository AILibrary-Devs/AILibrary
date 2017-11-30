/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author kwl
 */
public class ImageTools {

    /**
     * @param resourcePath fully qualified location of the image in the compiled
     * binary file/library
     * @return an Image
     */
    public static Image loadImageFromResource(String resourcePath) {
        Image image = null;
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream(resourcePath);
            image = ImageIO.read(input);
        } catch (IOException e) {
            //TODO - exception handling
        }
        return image;
    }

    /**
     * @param image the Image to be converted to a BufferedImage; no scaling or 
     * transposition is performed
     * 
     * @return a BufferedImage
     */
    public static BufferedImage imageToBufferedImage(Image image) {
        BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        bi.getGraphics().drawImage(image, 0, 0, null);
        return bi;
    }

    public static Image[] getSubimageArray(Image image, int xCount, int yCount) {
        Image[] images = new Image[xCount * yCount];
        Image[][] imgs = getSubimageArrays(image, xCount, yCount);

        int idx = 0;
        for (Image[] ii : imgs) {
            for (Image i : ii) {
                images[idx] = i;
                idx++;
            }
        }

        return images;
    }

    public static Image[][] getSubimageArrays(Image image, int xCount, int yCount) {
        Image[][] images = new Image[xCount][yCount];
        BufferedImage bi = (BufferedImage) image;

        int width = bi.getWidth() / xCount;
        int height = bi.getHeight() / yCount;

        for (int i = 0; i < xCount; i++) {
            for (int j = 0; j < yCount; j++) {
                images[i][j] = bi.getSubimage(i * width, j * height, width, height);
            }
        }

        return images;
    }

    public static double[] imageToDoubleRowColArray(Image source, int rows, int columns) {
        double[][] target = new double[rows][columns];
        BufferedImage bi = (BufferedImage) source;
        
        int srcRowTrans = bi.getHeight() / 2;
        int srcColTrans = bi.getWidth() / 2;
        
        int tgtRowTrans = rows / 2;
        int tgtColTrans = columns / 2;

        //create a row, col matrix of integer color values, one for each pixel; 
        //if a pixel in the "target" array is outside of the space of the source
        //array, fill that pixel in the target array with BLACK
        //TODO: parameterize "fill" color
        for (int row = 0; row < target.length; row++) {
            for (int col = 0; col < target[row].length; col++) {
                if ((row - tgtRowTrans < -srcRowTrans) || 
                    (row - tgtRowTrans >=  srcRowTrans) ||
                    (col - tgtColTrans < -srcColTrans) || 
                    (col - tgtColTrans >=  srcColTrans)) {
                    target[row][col] = ARGB_MASK_BLACK;
                } else {
                    target[row][col] = getARGBLinearTransform(getARGB(bi.getRGB(col, row)));
                }
            }
        }
        
        return square2DArrayTo1DArray(target);
    }
    
    public static double[] square2DArrayTo1DArray(double[][] square2D){
        double[] result = new double[square2D.length * square2D[0].length];
        int idx = 0;
        
        for (double[] array : square2D) {
            for (int col = 0; col < array.length; col++) {
                result[idx] = array[col];
                idx++;
            }
        }
        
        return result;
    }
    
    public static double[] imageToDoubleRowColArray(Image image) {
        double[][] arrays = imageToDoubleRowColArrays(image);
        double[] result = new double[arrays.length * arrays[0].length];

        int idx = 0;
        for (int row = 0; row < arrays.length; row++) {
            for (int col = 0; col < arrays[row].length; col++) {
                result[idx] = arrays[row][col];
                idx++;
            }
        }
        return result;
    }
    
    public static double[][] imageToDoubleRowColArrays(Image image) {
        double[][] result = new double[image.getHeight(null)][image.getWidth(null)];
        BufferedImage bi = (BufferedImage) image;

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = getARGBLinearTransform(getARGB(bi.getRGB(col, row)));
            }
        }
        return result;
    }
    
    public static int[][] imageToIntRowColArrays(Image image) {
        int[][] result = new int[image.getHeight(null)][image.getWidth(null)];
        BufferedImage bi = (BufferedImage) image;

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
//                result[row][col] = image.getRGB(col, row);
                result[row][col] = bi.getRGB(col, row);
            }
        }
        return result;
    }
    
    public final static int ARGB_MASK_ALPHA = 0xff000000;
    public final static int ARGB_MASK_BLACK = 0x00000000;
    public final static int ARGB_MASK_RED = 0x00ff0000;
    public final static int ARGB_MASK_GREEN = 0x0000ff00;
    public final static int ARGB_MASK_BLUE = 0x000000ff;

    public final static int ARGB_ALPHA = 0;
    public final static int ARGB_RED = 1;
    public final static int ARGB_GREEN = 2;
    public final static int ARGB_BLUE = 3;
    
    
    public static int[] getARGB(int color){
        int[] argb = new int[4];
        
        argb[ARGB_ALPHA] = (color & ARGB_MASK_ALPHA) >> 24;
        argb[ARGB_RED] = (color & ARGB_MASK_RED) >> 16;
        argb[ARGB_GREEN] = (color & ARGB_MASK_GREEN) >> 8;
        argb[ARGB_BLUE] = (color & ARGB_MASK_BLUE);
        
        return argb;
    }
        

    public static int getARGBSum(int[] argb){
        return argb[ARGB_RED] + argb[ARGB_GREEN] + argb[ARGB_BLUE];
    }
        
    public static int getARGBSum(int color){
        return getARGBSum(getARGB(color));
    }
    
    public static double getARGBLinearTransform(int[] argb){
        return LinearTransform.transform(argb[ARGB_RED] + argb[ARGB_GREEN] + argb[ARGB_BLUE], 0.0, 765.0, 0.0, 1.0);
    }
            
//    public static BufferedImage resizeImage(Image source, int width, int height, Color fill){
//        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//        WritableRaster wr = result.getRaster()etRaster();
//        //if images are a different size, center and mao the relevant pixels
//        //if source is "missing" data, ue "fill" color instead
//        
//        int xtSrc = source.getWidth(null) / 2;
//        int ytSrc = source.getHeight(null) / 2;
//        
//        int xtTgt = width / 2;
//        int ytTgt = height / 2;
//        
//         
//        for (int row = -xtTgt; row < xtTgt; row++) {
//            for (int col = -ytTgt; col < ytTgt; col++) {
//                if ((row < -xtSrc) || (row > xtSrc)) {
//                    rwr.
//                }
//            }
//        }
//        
////        for (int row = 0; row < height; row++) {
////            for (int col = 0; col < width; col++) {
////                if (row - xtTgt < )
////            }
////        }
//        
//        return result;
//    }    

}
