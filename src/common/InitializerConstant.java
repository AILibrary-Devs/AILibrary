/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 * Initializer provides constant (set on construction)
 * @author kwl
 */
public class InitializerConstant implements InitializerIntf {

    private static final long serialVersionUID = 0L;

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public InitializerConstant(double constantValue) {
        value = constantValue;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Properties">
    private final double value;

    /**
     *
     * @return a constant value, as initialized during construction
     */
    @Override
    public double getValue() {
        return value;
    }
//</editor-fold>

}
