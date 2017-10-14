/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import common.Sigmoid;
import common.InitializerIntf;
import common.InitializerConstant;
import common.InitializerRandom;
import java.util.ArrayList;

/**
 *
 * @author kwl
 */
public class NeuralNet implements NeuralNetIntf {

    private static final long serialVersionUID = 0L;

//<editor-fold defaultstate="collapsed" desc="Constructor and Factory Methods">
    {
        perceptionLayer = new NeuralLayer();
        hiddenLayer = new NeuralLayer();
        outputLayer = new NeuralLayer();

        learningRate = DEFAULT_LEARNING_RATE;
    }

    public NeuralNet() {}
    
    public static NeuralNetIntf neuralNetFactory(int perceptionLayerCount, int hiddenLayerCount, int outputLayerCount) {
        NeuralNetIntf net = new NeuralNet();
        
        InitializerIntf initializer = new InitializerRandom();
        //set up the layers
        net.setPerceptionLayer(new NeuralLayer(perceptionLayerCount, new InitializerConstant(0.0)));
        net.setHiddenLayer(new NeuralLayer(hiddenLayerCount, initializer));
        net.setOutputLayer(new NeuralLayer(outputLayerCount, initializer));
                
        //connect layers
        net.getHiddenLayer().connectProviderLayer(net.getPerceptionLayer(), initializer);
        net.getOutputLayer().connectProviderLayer(net.getHiddenLayer(), initializer);
        
        return net;
    }
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Properties">
    public static final double DEFAULT_LEARNING_RATE = 0.5;

    private double learningRate;
    private NeuralLayerIntf perceptionLayer, hiddenLayer, outputLayer;

    @Override
    public void setPerceptionLayer(NeuralLayerIntf perceptionLayer) {
        this.perceptionLayer = perceptionLayer;
    }

    @Override
    public NeuralLayerIntf getPerceptionLayer() {
        return perceptionLayer;
    }

    

    
    @Override
    public NeuralLayerIntf getInputLayer() {
        return getPerceptionLayer();
    }

    @Override
    public void setHiddenLayer(NeuralLayerIntf hiddenLayer) {
        this.hiddenLayer = hiddenLayer;
    }

    @Override
    public NeuralLayerIntf getHiddenLayer() {
        return hiddenLayer;
    }

    @Override
    public void setOutputLayer(NeuralLayerIntf outputLayer) {
        this.outputLayer = outputLayer;
    }

    @Override
    public NeuralLayerIntf getOutputLayer() {
        return outputLayer;
    }

    @Override
    public double getLearningRate() {
        return learningRate;
    }

    @Override
    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="NeuralNetIntf Methods">
    @Override
    public void pulse() {
        hiddenLayer.pulse();
        outputLayer.pulse();
    }

    @Override
    public void applyLearning() {
        hiddenLayer.applyLearning(learningRate);
        outputLayer.applyLearning(learningRate);
    }
    
    @Override
    public void initializeLearning() {
        hiddenLayer.initializeLearning();
        outputLayer.initializeLearning();
    }   
//</editor-fold>

    public void train(double[][] inputs, double[][]expected, int iterationLimit){
        for (int iteration = 0; iteration < iterationLimit; iteration++){
            
            initializeLearning(); //set weights to zero
            
            for (int session = 0; session < inputs.length; session++){
                runTrainingSession(this, inputs[session], expected[session]);
            }
            
            applyLearning();
        }
    }
    
//    public void train(double[][] inputs, double[]expected, int iterationLimit){
//        for (int iteration = 0; iteration < iterationLimit; iteration++){
//            
//            initializeLearning(); //set weights to zero
//            
//            for (int session = 0; session < inputs.length; session++){
//                runTrainingSession(this, inputs[session], expected);
//            }
//            
//            applyLearning();
//        }
//    }
    
    public static void runTrainingSession(NeuralNetIntf net, double[] inputData, double[] expectedData){
        preparePerceptionLayerForPulse(net, inputData);
        net.pulse();
        calculateErrors(net, expectedData);
        calculateAndAppendTransformation(net);
    }
    
    private static boolean preparePerceptionLayerForPulse(NeuralNetIntf net, double[] inputData) {
        if (inputData.length != net.getPerceptionLayer().getCount()){
            System.out.print("Input data size does not match perception layer size.");
            return false;
        } else {
            return net.getPerceptionLayer().setOutputValues(inputData);
        }     
    }

    private static void calculateErrors(NeuralNetIntf net, double[] expectedData) {
        Sigmoid sigmoid = new Sigmoid();
        net.getOutputLayer().updateErrorsFromExpectedResults(expectedData, sigmoid);
        net.getHiddenLayer().updateErrorsFromConsumerLayer(net.getOutputLayer(), sigmoid);
    }

    private static void calculateAndAppendTransformation(NeuralNetIntf net) {
        net.getOutputLayer().updateDeltasBasedOnCurrentErrors(net.getHiddenLayer());
        net.getHiddenLayer().updateDeltasBasedOnCurrentErrors(net.getPerceptionLayer());
    }

    @Override
    public ArrayList<NeuralLayerIntf> getLayers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NeuralLayerIntf getLayer(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}