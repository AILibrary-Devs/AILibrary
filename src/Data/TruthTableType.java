/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author kwl
 */
public enum TruthTableType {

    AND("AND"), OR("OR"), XOR("XOR");

    private TruthTableType(String label) {
        this.label = label;
    }

    private final String label;

    public String getLabel() {
        return label;
    }

    public boolean getValue(boolean one, boolean two) {
        switch (this) {
            case AND:
                return Boolean.logicalAnd(one, two);
            case OR:
                return Boolean.logicalOr(one, two);
            case XOR:
            default:
                return Boolean.logicalXor(one, two);
        }
    }
}
