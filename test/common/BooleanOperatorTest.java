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
        System.out.println("-- BooleanOperator: START");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("-- BooleanOperator: END\n");
    }
    
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getLabel method, of class BooleanOperator.
     */
    @Test
    public void testGetLabel() {
        System.out.println("getLabel");
        BooleanOperator boolOp;
        String result;

        boolOp = BooleanOperator.AND;
        result = boolOp.getLabel();
        assertTrue("AND".equals(result));

        boolOp = BooleanOperator.OR;
        result = boolOp.getLabel();
        assertTrue("OR".equals(result));

        boolOp = BooleanOperator.XOR;
        result = boolOp.getLabel();
        assertTrue("XOR".equals(result));
    }

    /**
     * Test of operate method, of class BooleanOperator.AND
     */
    @Test
    public void testOperate_AND() {
        System.out.println("AND.operate");
        
        BooleanOperator boolOp = BooleanOperator.AND;
        int counter = 0;
        
        for (boolean[] AND_TT : AND_ARRAY) {
            assertEquals(AND_TT[TT_RESULT_IDX], boolOp.operate(AND_TT[TT_ONE_IDX], AND_TT[TT_TWO_IDX]));
            counter++;
        }
        
        assertEquals(counter, 4);
    }

    /**
     * Test of operate method, of class BooleanOperator.OR
     */
    @Test
    public void testOperate_OR() {
        System.out.println("OR.operate");
        
        BooleanOperator boolOp = BooleanOperator.OR;
        int counter = 0;
        
        for (boolean[] OR_TT : OR_ARRAY) {
            assertEquals(OR_TT[TT_RESULT_IDX], boolOp.operate(OR_TT[TT_ONE_IDX], OR_TT[TT_TWO_IDX]));
            counter++;
        }
        
        assertEquals(counter, 4);
    }

    /**
     * Test of operate method, of class BooleanOperator.XOR
     */
    @Test
    public void testOperate_XOR() {
        System.out.println("XOR.operate");

        BooleanOperator boolOp = BooleanOperator.XOR;
        int counter = 0;

        for (boolean[] XOR_TT : XOR_ARRAY) {
            assertEquals(XOR_TT[TT_RESULT_IDX], boolOp.operate(XOR_TT[TT_ONE_IDX], XOR_TT[TT_TWO_IDX]));
            counter++;
        }
        
        assertEquals(counter, 4);
    }


    /**
     * Test of static operate method, of class BooleanOperator.AND
     */
    @Test
    public void testOperate_static_AND() {
        System.out.println("static AND.operate");
        
        int counter = 0;

        for (boolean[] AND_TT : AND_ARRAY) {
            assertEquals(AND_TT[TT_RESULT_IDX], BooleanOperator.operate(BooleanOperator.AND, AND_TT[TT_ONE_IDX], AND_TT[TT_TWO_IDX]));
            counter++;
        }

        assertEquals(counter, 4);
    }

    /**
     * Test of static operate method, of class BooleanOperator.OR
     */
    @Test
    public void testOperate_static_OR() {
        System.out.println("static OR.operate");
        
        int counter = 0;

        for (boolean[] OR_TT : OR_ARRAY) {
            assertEquals(OR_TT[TT_RESULT_IDX], BooleanOperator.operate(BooleanOperator.OR, OR_TT[TT_ONE_IDX], OR_TT[TT_TWO_IDX]));
            counter++;
        }

        assertEquals(counter, 4);
    }

    /**
     * Test of static operate method, of class BooleanOperator.XOR
     */
    @Test
    public void testOperate_static_XOR() {
        System.out.println("static XOR.operate");
        
        int counter = 0;

        for (boolean[] XOR_TT : XOR_ARRAY) {
            assertEquals(XOR_TT[TT_RESULT_IDX], BooleanOperator.operate(BooleanOperator.XOR, XOR_TT[TT_ONE_IDX], XOR_TT[TT_TWO_IDX]));
            counter++;
        }

        assertEquals(counter, 4);
    }

    private static final int TT_ONE_IDX = 0;
    private static final int TT_TWO_IDX = 1;
    private static final int TT_RESULT_IDX = 2;

    private static final boolean[][] AND_ARRAY = 
        {{false, false, false},
         {false, true, false},
         {true, false, false},
         {true, true, true}};

    private static final boolean[][] OR_ARRAY = 
        {{false, false, false},
         {false, true, true},
         {true, false, true},
         {true, true, true}};

    private static final boolean[][] XOR_ARRAY = 
        {{false, false, false},
         {false, true, true},
         {true, false, true},
         {true, true, false}};
    
    private static final boolean[] FT = {false, true};

    /**
     * Test of operate method, of class BooleanOperator.
     */
    @Test
    public void testOperate_static() {
        BooleanOperator type = null;
        int counter;

        System.out.println("static operate (AND)");
        type = BooleanOperator.AND;
        counter = 0;
        
        for (boolean[] AND_TT : AND_ARRAY) {
            assertEquals(AND_TT[TT_RESULT_IDX], BooleanOperator.operate(type, AND_TT[TT_ONE_IDX], AND_TT[TT_TWO_IDX]));
            counter++;
        }
        
        assertEquals(counter, 4);
        
        
        System.out.println("static operate (OR)");
        type = BooleanOperator.OR;
        counter = 0;
        
        for (boolean[] OR_TT : OR_ARRAY) {
            assertEquals(OR_TT[TT_RESULT_IDX], BooleanOperator.operate(type, OR_TT[TT_ONE_IDX], OR_TT[TT_TWO_IDX]));
            counter++;
        }
        
        assertEquals(counter, 4);
        
        
        System.out.println("static operate (XOR)");
        type = BooleanOperator.XOR;
        counter = 0;
        
        for (boolean[] XOR_TT : XOR_ARRAY) {
            assertEquals(XOR_TT[TT_RESULT_IDX], BooleanOperator.operate(type, XOR_TT[TT_ONE_IDX], XOR_TT[TT_TWO_IDX]));
            counter++;
        }
        
        assertEquals(counter, 4);
    }

    /**
     * Test of toDouble method, of class BooleanOperator.
     */
    @Test
    public void testToDouble_instance() {
        System.out.println("toDouble instance - DEFAULT");

        Boolean value = false;
        Double expResult = BooleanOperator.FALSE_DOUBLE_DEFAULT;
        Double result = BooleanOperator.toDouble(value);
        assertEquals(expResult, result);


        value = true;
        expResult = BooleanOperator.TRUE_DOUBLE_DEFAULT;
        result = BooleanOperator.toDouble(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of toDouble method, of class BooleanOperator.
     */
    @Test
    public void testToDouble_static() {
        System.out.println("static toDouble");

        Double trueValue = 0.98765;
        Double falseValue = 0.12345;
        Boolean value;
        Double result;

        value = false;
        result = BooleanOperator.toDouble(value, trueValue, falseValue);
        assertEquals(falseValue, result);


        value = true;
        result = BooleanOperator.toDouble(value, trueValue, falseValue);
        assertEquals(trueValue, result);
    }
   
}
