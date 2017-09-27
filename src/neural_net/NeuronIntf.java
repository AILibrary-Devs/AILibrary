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
public interface NeuronIntf {
    void pulse();
    void applyLearning(double learningRate);
    void initializeLearning();
    
    NeuralFactorIntf getNeuralFactor();
    void setNeuralFactor(NeuralFactorIntf neuralFactor);
    
    double getError();
    void setError(double error);
    
    double getLastError();
    void setLastError(double lastError);    
}
