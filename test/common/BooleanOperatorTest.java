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
public class BooleanOperatorTest {
    
    public BooleanOperatorTest() {
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
     * Test of values method, of class BooleanOperator.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        BooleanOperator[] expResult = null;
        BooleanOperator[] result = BooleanOperator.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class BooleanOperator.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        BooleanOperator expResult = null;
        BooleanOperator result = BooleanOperator.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLabel method, of class BooleanOperator.
     */
    @Test
    public void testGetLabel() {
        System.out.println("getLabel");
        BooleanOperator instance = null;
        String expResult = "";
        String result = instance.getLabel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of operate method, of class BooleanOperator.
     */
    @Test
    public void testOperate_boolean_boolean() {
        System.out.println("operate");
        boolean one = false;
        boolean two = false;
        BooleanOperator instance = null;
        boolean expResult = false;
        boolean result = instance.operate(one, two);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of operate method, of class BooleanOperator.
     */
    @Test
    public void testOperate_3args() {
        System.out.println("operate");
        BooleanOperator type = null;
        boolean one = false;
        boolean two = false;
        boolean expResult = false;
        boolean result = BooleanOperator.operate(type, one, two);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toDouble method, of class BooleanOperator.
     */
    @Test
    public void testToDouble_Boolean() {
        System.out.println("toDouble");
        Boolean value = null;
        Double expResult = null;
        Double result = BooleanOperator.toDouble(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toDouble method, of class BooleanOperator.
     */
    @Test
    public void testToDouble_3args() {
        System.out.println("toDouble");
        Boolean value = null;
        Double trueValue = null;
        Double falseValue = null;
        Double expResult = null;
        Double result = BooleanOperator.toDouble(value, trueValue, falseValue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
