/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import common.InitializerRandom;
import common.InitializerIntf;
import common.RangeTransformIntf;
import common.Sigmoid;
import java.util.ArrayList;

/**
 *
 * @author kwl
 */
public class NeuralNet implements NeuralNetIntf {

    private static final long serialVersionUID = 0L;

//<editor-fold defaultstate="collapsed" desc="Constructor and Factory Methods">
    {
        layers = new ArrayList<>();
        learningRate = DEFAULT_LEARNING_RATE;
    }

    public NeuralNet() {
    }

    public NeuralNet(int[] layerNodeCounts, InitializerIntf neuronBiasInitializer, NeuralLayerFactoryIntf layerFactory) {
        // create all the layers 
        for (int nodeCount : layerNodeCounts) {
            layers.add(layerFactory.getNeuralLayer(nodeCount, neuronBiasInitializer));
        }

        // connect the layers; note that the "input" (or perception) layer is
        // not connected to other layers, as it will receive the input data
        for (int i = 1; i < layers.size(); i++) {
            layers.get(i).connectProviderLayer(layers.get(i - 1), neuronBiasInitializer);
        }
    }

    /**
     * Constructor - simplified; note that the
     *
     * @param layerNodeCounts and array of integers that defines the number of
     * nodes in each layer, and implicitly by the number of entries in the
     * array, the number of layers in the NeuralNet. Note that the "bias" values
     * on the inter-layer node collections will be initialized to a random value
     * between 0 (inclusive) and 1 (exclusive).
     */
    public NeuralNet(int[] layerNodeCounts) {
        InitializerIntf neuronBiasInitializer = new InitializerRandom();

        // create all the layers 
        for (int nodeCount : layerNodeCounts) {
            layers.add(NeuralLayer.getNeuralLayer(nodeCount, neuronBiasInitializer));
        }

        // connect the layers; note that the "input" (or perception) layer is
        // not connected to other layers, as it will receive the input data
        for (int i = 1; i < layers.size(); i++) {
            layers.get(i).connectProviderLayer(layers.get(i - 1), neuronBiasInitializer);
        }
    }

//    public static NeuralNetIntf getSimpleNeuralNet(int inputLayerCount, int transformLayerCount, int outputLayerCount){
//        int[] layerNodeCounts = {inputLayerCount};
//        return new NeuralNet(layerNodeCounts, new InitializerRandom(), new NeuralLayer());
//    }    
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Properties">
    private ArrayList<NeuralLayerIntf> layers;

    public static final double DEFAULT_LEARNING_RATE = 0.5;
    private double learningRate;

    private static final int INPUT_LAYER_IDX = 0;

    @Override
    public ArrayList<NeuralLayerIntf> getLayers() {
        return layers;
    }

    @Override
    public NeuralLayerIntf getLayer(int index) {
        return layers.get(index);
    }

    @Override
    public NeuralLayerIntf getInputLayer() {
        return layers.get(INPUT_LAYER_IDX);
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

//<editor-fold defaultstate="collapsed" desc="Methods">
//<editor-fold defaultstate="collapsed" desc="NeuralNetIntf Methods">
    @Override
    public void pulse() {
        for (int i = 1; i < layers.size(); i++) {
            getLayer(i).pulse();
        }
    }

    @Override
    public void applyLearning() {
        for (int i = 1; i < layers.size(); i++) {
            getLayer(i).applyLearning(learningRate);
        }
    }

    @Override
    public void initializeLearning() {
        for (int i = 1; i < layers.size(); i++) {
            getLayer(i).initializeLearning();
        }
    }

    @Override
    public void train(double[][] inputs, double[][] expected, int iterationLimit) {
        for (int iteration = 0; iteration < iterationLimit; iteration++) {
            initializeLearning(); //set weights to zero

            for (int session = 0; session < inputs.length; session++) {
                runTrainingSession(this, inputs[session], expected[session]);
            }
            applyLearning();
        }
    }
//</editor-fold>

    public double[] computeOutputs(double[] inputData) throws Exception {
        if (inputData.length != getInputLayer().getCount()) {
            throw new Exception("Input data size does not match input layer size.");
        }

        getInputLayer().setOutputValues(inputData);
        pulse();
        return getOutputLayer().getOutputValues();
    }

    public static void runTrainingSession(NeuralNetIntf net, double[] inputData, double[] expectedData) {
        setInputLayerData(net, inputData);

        net.pulse();

        calculateErrors(net, expectedData);
        calculateAndAppendTransformation(net);
    }

    private static boolean setInputLayerData(NeuralNetIntf net, double[] inputData) {
        if (inputData.length != net.getInputLayer().getCount()) {
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
        for (int i = net.getLayers().size() - 2; i > 0; i--) {
            net.getLayers().get(i).updateErrorsFromConsumerLayer(net.getLayers().get(i + 1), sigmoid);
        }
    }

    private static void calculateAndAppendTransformation(NeuralNetIntf net) {
        for (int i = net.getLayers().size() - 1; i > 0; i--) {
            net.getLayers().get(i).updateDeltasBasedOnCurrentErrors(net.getLayers().get(i - 1));
        }
    }
//</editor-fold>

}
