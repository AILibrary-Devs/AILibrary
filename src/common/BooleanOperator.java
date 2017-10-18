/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author kwl
 */
public enum BooleanOperator {

    AND("AND"), OR("OR"), XOR("XOR");

    private BooleanOperator(String label) {
        this.label = label;
    }

    private final String label;

    public String getLabel() {
        return label;
    }

    public boolean operate(boolean one, boolean two) {
        return operate(this, one, two);
    }

    public static boolean operate(BooleanOperator type, boolean one, boolean two) {
        switch (type) {
            case AND:
                return Boolean.logicalAnd(one, two);
            case OR:
                return Boolean.logicalOr(one, two);
            case XOR:
            default:
                return Boolean.logicalXor(one, two);
        }
    }
    
    private static final Double TRUE_DOUBLE = 0.9;
    private static final Double FALSE_DOUBLE = 0.1;

    public static Double toDouble(Boolean value) {
        return value ? TRUE_DOUBLE : FALSE_DOUBLE;
    }

}
