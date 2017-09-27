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
public class NeuralFactor implements NeuralFactorIntf {

    private static final long serialVersionUID = 0L;
   
//<editor-fold defaultstate="collapsed" desc="Constructors">
    {
        weight = DEFAULT_WEIGHT;
        
        delta = DEFAULT_DELTA;
        lastDelta = DEFAULT_DELTA;
    }
    
    /**
     *
     * @param weight
     */
    public NeuralFactor(double weight){
        this.weight = weight;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="NeuralFactorIntf">
//<editor-fold defaultstate="collapsed" desc="Properties">
    public static double DEFAULT_WEIGHT = 1.0;
    public static double DEFAULT_DELTA = 0.0;

    private double weight, delta, lastDelta;
    
    /**
     * @return the weight
     */
    @Override
    public double getWeight() {
        return this.weight;
    }
    
    /**
     * @param weight the weight to set
     */
    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    /**
     * @return the delta
     */
    @Override
    public double getDelta() {
        return this.delta;
    }
    
    /**
     * @param delta the delta to set
     */
    @Override
    public void setDelta(double delta) {
        this.delta = delta;
    }

    /**
     * @param delta the delta to add to the current delta value
     */
    @Override
    public void addDelta(double delta) {
        this.delta += delta;
    }

    /**
     * @return the lastDelta
     */
    @Override
    public double getLastDelta() {
        return lastDelta;
    }
    
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Methods">
    /**
     * @param learningRate A coefficient applied to the computed delta as it the
     * delta is applied to the weight property; this essentially controls how 
     * fast the model reacts to computed deviations from the exemplar values.
     */
    @Override
    public void applyWeightChange(double learningRate) {
        weight += delta * learningRate;
        lastDelta = delta;
    }
    
    /**
     * Sets the delta and lastDelta properties to 0.0
     */
    @Override
    public void resetWeightChange(){
        lastDelta = DEFAULT_DELTA;
        delta = DEFAULT_DELTA;
    }
//</editor-fold>
//</editor-fold>

}
