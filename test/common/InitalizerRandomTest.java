/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

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
public class InitalizerRandomTest {
    
    public InitalizerRandomTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("-- InitalizerRandomTest: START");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("-- InitalizerRandomTest: END\n");
    }

    /**
     * Test of getValue method, of class InitializerRandom.
     */
    @Test
    public void testGetValueNonParamConstructor() {
        System.out.println("getValue, non-parameterized constructor");
        InitializerRandom instance = new InitializerRandom();

        double expMinimum = InitializerRandom.DEFAULT_MINIMUM;
        double expMaximum = InitializerRandom.DEFAULT_MAXIMUM;

        double result;
        for (int i = 0; i < 2500; i++){
            result = instance.getValue();
            assertTrue((result >= expMinimum) && (result < expMaximum));
        }
    }
    
    /**
     * Test of getValue method, of class InitializerRandom.
     */
    @Test
    public void testGetValueRangedConstructor() {
        System.out.println("getValue, ranged constructor");


        double expMinimum = -13.1;
        double expMaximum = 125.5;
        InitializerRandom instance = new InitializerRandom(expMinimum, expMaximum);

        double result;
        for (int i = 0; i < 2500; i++){
            result = instance.getValue();
            assertTrue((result >= expMinimum) && (result < expMaximum));
        }
    }
    
}
