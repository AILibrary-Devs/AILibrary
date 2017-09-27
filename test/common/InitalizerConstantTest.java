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
public class InitalizerConstantTest {
    
    public InitalizerConstantTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("-- InitalizerConstantTest: START");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("-- InitalizerConstantTest: END\n");
    }

    /**
     * Test of getValue method, of class InitalizerConstant.
     */
    @Test
    public void testGetValue() {
        System.out.println("---- getValue");
        
        double expResult = 11.1;

        InitalizerConstant instance = new InitalizerConstant(expResult);
        
        double result = instance.getValue();
        assertEquals(expResult, result, 0.0);

        result = instance.getValue();
        assertEquals(expResult, result, 0.0);

        result = instance.getValue();
        assertEquals(expResult, result, 0.0);
    }
    
}
