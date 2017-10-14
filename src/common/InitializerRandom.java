/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 * Computes random values between a minimum (inclusive) and maximum (exclusive); 
 * the default minimum value is 0.0, and the default maximum value is 1.0
 * @author kwl
 */
public class InitializerRandom implements InitializerIntf {

    private static final long serialVersionUID = 0L;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    {
    minimum = DEFAULT_MINIMUM;
    maximum = DEFAULT_MAXIMUM;
}
    
    public InitializerRandom(){}
    
    public InitializerRandom(double minimum, double maximum){
        this.minimum = minimum;
        this.maximum = maximum;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    public static final double DEFAULT_MINIMUM = 0.0;
    public static final double DEFAULT_MAXIMUM = 1.0;
    
    private double minimum, maximum;
    
    /**
     *
     * @return a random value between the minimum and maximum values
     */
    @Override
    public double getValue(){
        return (Math.random() * (maximum - minimum)) + minimum;
    }
//</editor-fold>
    
}
