/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

/**
 *
 * @author kwl
 */
public class Sigmoid {

    private static final long serialVersionUID = 0L;
    
//<editor-fold defaultstate="collapsed" desc="Methods">
    /**
     * @param value the value to transform to the range 0 to 1
     * @return a transformed value in the range between 0 and 1
     *
     * The applyTransform function uses a sigmoid curve to transform the
     * provided value (typically the sum of weight-adjusted inputs to the neuron
     * in a neural net) to values between 0 and 1.
     *
     * The standard sigmoid function is S(x) = 1 / (1 + e^(-x)), where e is
     * Euler's number.
     */
    public static double applyTransform(double value){
        return 1.0 / (1.0 + Math.exp(-value));
    }
    
    public double transform(double value){
        return applyTransform(value);
    }
    
    /**
     * @param value the value to be multiplied by the derivative of the sigmoid
     * @return the result of multiplying the input value by the sigmoid derivative
     *
     * The standard sigmoid function is S(x) = 1 / (1 + e^(-x)), where e is
     * Euler's number, and the derivative of the sigmoid function is x * (1 - x)
     */
    public static double applyDerivative(double value){
        return value * (1.0 - value);
    }
    
    public double derivative(double value){
        return applyDerivative(value);
    }
//</editor-fold>
}
