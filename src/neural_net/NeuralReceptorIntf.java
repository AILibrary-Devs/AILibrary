/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import java.util.Map;

/**
 *
 * @author kwl
 */
public interface NeuralReceptorIntf {
    Map<NeuralSignalIntf, NeuralFactorIntf> getInputs();
    
    void AddInput(NeuralSignalIntf signal, NeuralFactorIntf factor);
    void RemoveInput(NeuralSignalIntf signal);
    
    double getWeightedInput();
}
