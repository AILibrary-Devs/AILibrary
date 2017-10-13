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
public interface RangeTransformIntf {
//    public double applyTransform(double value);
    public double transform(double value);    

//    public double applyDerivative(double value);
    public double derivative(double value);    
}
