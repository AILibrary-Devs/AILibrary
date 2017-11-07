/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import common.SigmoidTransform;
import common.InitializerIntf;
import common.RangeTransformIntf;
import java.util.ArrayList;

/**
 *
 * @author kwl
 */
public interface NeuralLayerIntf {

    ArrayList<Neuron> getNeurons();
    int getCount();
    boolean setOutputValues(double[] values);
    double[] getOutputValues();
    void connectProviderLayer(NeuralLayerIntf providerLayer, InitializerIntf weightInitializer);

    void pulse();
    void applyLearning(double learningRate);
    void initializeLearning();
    
    boolean updateErrorsFromExpectedResults(double[] desiredResults, RangeTransformIntf sigmoid);
    boolean updateErrorsFromConsumerLayer(NeuralLayerIntf consumerLayer, RangeTransformIntf sigmoid);
    
    boolean updateDeltasBasedOnCurrentErrors(NeuralLayerIntf providerLayer);
}
