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
public class LinearTransform implements RangeTransformIntf {

//<editor-fold defaultstate="collapsed" desc="Constructors">
    {
    inputMinimum = INPUT_MINIMUM_DEFAULT;
    inputMaximum = INPUT_MAXIMUM_DEFAULT;
    outputMinimum = OUTPUT_MINIMUM_DEFAULT;
    outputMaximum = OUTPUT_MAXIMUM_DEFAULT;
}
    
    public LinearTransform() {}
    
    public LinearTransform(double inputMinimum, double inputMaximum, double outputMinimum, double outputMaximum) {
        this.inputMinimum = inputMinimum;
        this.inputMaximum = inputMaximum;
        
        this.outputMinimum = outputMinimum;
        this.outputMaximum = outputMaximum;
    }
//</editor-fold>
    
    
    
//<editor-fold defaultstate="collapsed" desc="Methods">
    public static double transform(double value, double inputMinimum, double inputMaximum, double outputMinimum, double outputMaximum) {
        return value * (outputMaximum - outputMinimum) / (inputMaximum - inputMinimum);
    }
    
//<editor-fold defaultstate="collapsed" desc="RangeTransformIntf">
    @Override
    public double transform(double value) {
        return transform(value, inputMinimum, inputMaximum, outputMinimum, outputMaximum);
    }
    
    @Override
    public double derivative(double value) {
        return 1.0;
    }
//</editor-fold>
//</editor-fold>
    
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    public static final double INPUT_MINIMUM_DEFAULT = -10.0;
    public static final double INPUT_MAXIMUM_DEFAULT = 10.0;
    public static final double OUTPUT_MINIMUM_DEFAULT = 0.0;
    public static final double OUTPUT_MAXIMUM_DEFAULT = 1.0;

    private double inputMinimum, inputMaximum, outputMinimum, outputMaximum;

    /**
     * @return the inputMinimum
     */
    public double getInputMinimum() {
        return inputMinimum;
    }

    /**
     * @param inputMinimum the inputMinimum to set
     */
    public void setInputMinimum(double inputMinimum) {
        this.inputMinimum = inputMinimum;
    }

    /**
     * @return the inputMaximum
     */
    public double getInputMaximum() {
        return inputMaximum;
    }

    /**
     * @param inputMaximum the inputMaximum to set
     */
    public void setInputMaximum(double inputMaximum) {
        this.inputMaximum = inputMaximum;
    }

    /**
     * @return the outputMinimum
     */
    public double getOutputMinimum() {
        return outputMinimum;
    }

    /**
     * @param outputMinimum the outputMinimum to set
     */
    public void setOutputMinimum(double outputMinimum) {
        this.outputMinimum = outputMinimum;
    }

    /**
     * @return the outputMaximum
     */
    public double getOutputMaximum() {
        return outputMaximum;
    }

    /**
     * @param outputMaximum the outputMaximum to set
     */
    public void setOutputMaximum(double outputMaximum) {
        this.outputMaximum = outputMaximum;
    }
//</editor-fold>

}
