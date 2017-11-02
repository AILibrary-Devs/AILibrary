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
public class ImageToolbox {
    
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
    
    public static Image[] getSubimageArray(Image image, int xCount, int yCount){
        Image[] images = new Image[xCount * yCount];
        Image[][] imgs = getSubimageArrays(image, xCount, yCount);
        
        int idx = 0;
        for (Image[] ii : imgs){
            for (Image i : ii){
                images[idx] = i;
                idx++;
            }
        }
        
        return images;
    }
    
    public static Image[][] getSubimageArrays(Image image, int xCount, int yCount){
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
    
//    public static void test(){
//        BufferedImage bi = new BufferedImage(1, 1, 1);
//        bi.
//    }
    
}
