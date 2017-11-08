/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.awt.Image;
import java.awt.image.BufferedImage;
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

    public static int[][] imageToIntRowColArrays(BufferedImage image) {
        int[][] result = new int[image.getHeight()][image.getWidth()];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = image.getRGB(col, row);
            }
        }
        return result;
    }
    
    public final static int ARGB_MASK_ALPHA = 0xff000000;
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
            
        

}
