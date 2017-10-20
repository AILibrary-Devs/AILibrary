/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

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
public class DataListTest {
    
    public DataListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("-- DataList: START");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("-- DataList: END\n");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of asDoubles method, of class DataList.
     */
    @Test
    public void testGetDoubles() {
        System.out.println("getDoubles");
        
        Double[] items = {1.1, 2.2, 3.3, 4.4, 5.5};
        DataList<Double> dl = DataList.asDoubles(items);
        
        assertEquals(dl.size(), 5);
        
        Double expected, actual;

        for (int i = 0; i < items.length; i++) {
            expected = items[i];
            actual = dl.get(i);
    
            assertEquals(expected, actual);
        }
    }
    
}
