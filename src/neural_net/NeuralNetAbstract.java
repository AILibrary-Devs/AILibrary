/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import common.InitializerConstant;
import common.InitializerRandom;
import common.InitializerIntf;
import common.RangeTransformIntf;
import common.Sigmoid;
import java.util.ArrayList;

/**
 *
 * @author kwl
 */
//public abstract class NeuralNetAbstract implements NeuralNetIntf {
public class NeuralNetAbstract implements NeuralNetIntf {

    private static final long serialVersionUID = 0L;

//<editor-fold defaultstate="collapsed" desc="Constructor and Factory Methods">
    {
        layers = new ArrayList<>();
        learningRate = DEFAULT_LEARNING_RATE;
    }

    public NeuralNetAbstract() {}

    public NeuralNetAbstract(int[] layerNodeCounts, InitializerIntf neuronBiasInitializer, NeuralLayerFactoryIntf layerFactory) {
       
        // create all the layers 
        for (int nodeCount : layerNodeCounts){
            layers.add(layerFactory.getLayer(nodeCount, neuronBiasInitializer));
        }
        
        // connect the layers; note that the "input" (or perception) layer is
        // not connected to other layers, as it will receive the input data
        for (int i = 1; i < layers.size(); i++){
            layers.get(i).connectProviderLayer(layers.get(i-1), neuronBiasInitializer);
        }
    }
    
    public static NeuralNetIntf getSimpleNeuralNet(int inputLayerCount, int transformLayerCount, int outputLayerCount){
        int[] layerNodeCounts = {inputLayerCount};
        return new NeuralNetAbstract(layerNodeCounts, new InitializerRandom(), new NeuralLayer());
    }
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Properties">
    private ArrayList<NeuralLayerIntf> layers;
    
    public static final double DEFAULT_LEARNING_RATE = 0.5;
    private double learningRate;
    
    @Override
    public ArrayList<NeuralLayerIntf> getLayers() {
        return layers;
    }

    @Override
    public NeuralLayerIntf getLayer(int index){
        return layers.get(index);
    }

    @Override
    public NeuralLayerIntf getInputLayer() {
        return layers.get(0);
    }

    @Override
    public NeuralLayerIntf getOutputLayer() {
        return layers.get(layers.size() - 1);
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
        for (int i = 1; i < layers.size(); i++){
            getLayer(i).pulse();
        }
        
//        hiddenLayer.pulse();
//        outputLayer.pulse();
    }

    @Override
    public void applyLearning() {
        for (int i = 1; i < layers.size(); i++){
            getLayer(i).applyLearning(learningRate);
        }

//        hiddenLayer.applyLearning(learningRate);
//        outputLayer.applyLearning(learningRate);
    }
    
    @Override
    public void initializeLearning() {
        for (int i = 1; i < layers.size(); i++){
            getLayer(i).initializeLearning();
        }

//        hiddenLayer.initializeLearning();
//        outputLayer.initializeLearning();
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
    
    public static void runTrainingSession(NeuralNetIntf net, double[] inputData, double[] expectedData){
        setInputLayerData(net, inputData);
        net.pulse();
        calculateErrors(net, expectedData);
        calculateAndAppendTransformation(net);
    }
    
    private static boolean setInputLayerData(NeuralNetIntf net, double[] inputData) {
        if (inputData.length != net.getInputLayer().getCount()){
            System.out.print("Input data size does not match input layer size.");
            return false;
        } else {
            return net.getInputLayer().setOutputValues(inputData);
        }     
    }

    private static void calculateErrors(NeuralNetIntf net, double[] expectedData) {
        RangeTransformIntf sigmoid = new Sigmoid();

        //update the output layer from the "known" (expected) answers...
        net.getOutputLayer().updateErrorsFromExpectedResults(expectedData, sigmoid);

        //...then propagate this learning through the model
        for (int i = net.getLayers().size() - 2; i > 0; i--){
            net.getLayers().get(i).updateErrorsFromConsumerLayer(net.getLayers().get(i + 1), sigmoid);
        }        
    }

    private static void calculateAndAppendTransformation(NeuralNetIntf net) {
        for (int i = net.getLayers().size() - 1; i > 0; i--){
            net.getLayers().get(i).updateDeltasBasedOnCurrentErrors(net.getLayers().get(i + 1));
        }
    }
    
}
