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

//<editor-fold defaultstate="collapsed" desc="Constructors">
    private BooleanOperator(String label) {
        this.label = label;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Properties">
    private final String label;

    public String getLabel() {
        return label;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Methods">
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

    public static final Double TRUE_DOUBLE_DEFAULT = 0.9;
    public static final Double FALSE_DOUBLE_DEFAULT = 0.1;

    public static Double toDouble(Boolean value) {
        return toDouble(value, TRUE_DOUBLE_DEFAULT, FALSE_DOUBLE_DEFAULT);
    }

    public static Double toDouble(Boolean value, Double trueValue, Double falseValue) {
        return value ? trueValue : falseValue;
    }
//</editor-fold>
}
