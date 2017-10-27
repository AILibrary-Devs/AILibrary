/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import java.util.ArrayList;

/**
 *
 * @author kwl
 */
public interface NeuralNetIntf {

    ArrayList<NeuralLayerIntf> getLayers();

    NeuralLayerIntf getLayer(int index);
    NeuralLayerIntf getInputLayer();
    NeuralLayerIntf getOutputLayer();
    
    double getLearningRate();
    void setLearningRate(double learningRate);
    
    void pulse();
    void applyLearning();
    void initializeLearning();

    void train(double[][] inputs, double[][]expected, int iterationLimit);
}
