/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import common.InitializerIntf;
import java.util.ArrayList;

/**
 *
 * @author kwl
 */
public interface NeuralLayerIntf {
    ArrayList<Neuron> getNeurons();
    int getCount();
    boolean setOutputValues(double[] values);
    void connectProviderLayer(NeuralLayerIntf providerLayer, InitializerIntf weightInitializer);

    void pulse();
    void applyLearning(double learningRate);
    void initializeLearning();
    
    boolean updateErrorsFromExpectedResults(double[] desiredResults, Sigmoid sigmoid);
    boolean updateErrorsFromConsumerLayer(NeuralLayerIntf consumerLayer, Sigmoid sigmoid);
    
    boolean updateDeltasBasedOnCurrentErrors(NeuralLayerIntf providerLayer);
}
