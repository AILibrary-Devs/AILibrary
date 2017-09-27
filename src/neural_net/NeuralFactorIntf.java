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
public interface NeuralFactorIntf {
    double getWeight();
    void setWeight(double weight);
    
    double getDelta();
    void setDelta(double delta);
    void addDelta(double delta);

    double getLastDelta();
    
    void applyWeightChange(double learningRate);
    void resetWeightChange();
}
