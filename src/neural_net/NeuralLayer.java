/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import common.InitializerIntf;
import common.RangeTransformIntf;
import java.util.ArrayList;

/**
 *
 * @author kwl
 */
public class NeuralLayer implements NeuralLayerIntf{//, NeuralLayerFactoryIntf {

    private static final long serialVersionUID = 0L;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    {
        neurons = new ArrayList<>();
    }

    public NeuralLayer() {}

    public NeuralLayer(int neuronCount, InitializerIntf initializer) {
        for (int i = 0; i < neuronCount; i++) {
            neurons.add(new Neuron(initializer.getValue()));
        }     
    }
    
//<editor-fold defaultstate="collapsed" desc="NeuralLayerFactoryIntf methods">
//    @Override
    public static NeuralLayerIntf getNeuralLayer(int neuronCount, InitializerIntf neuronBiasInitializer){
        return new NeuralLayer(neuronCount, neuronBiasInitializer);
    }
//</editor-fold>
    
//</editor-fold>
        
//<editor-fold defaultstate="collapsed" desc="NeuralLayerIntf">
    private final ArrayList<Neuron> neurons;
    
    @Override
    public ArrayList<Neuron> getNeurons(){
        return neurons;
    }
    
    @Override
    public int getCount(){
        return neurons.size();
    }

    @Override
    public void pulse() {
        neurons.forEach((neuron) -> {
            neuron.pulse();
        });
    }
    
    @Override
    public void applyLearning(double learningRate) {        
        neurons.forEach((neuron) -> {
            neuron.applyLearning(learningRate);
        });
    }

    @Override
    public void initializeLearning() {
        neurons.forEach((neuron) -> {
            neuron.initializeLearning();
        });
    }
    
    /**
     *
     * @param values
     * @return
     */
    @Override
    public boolean setOutputValues(double[] values){
        if (values.length != neurons.size()){
            System.out.printf("Initialization data set size [%d] does not match neuron set size [].\n", values.length, neurons.size());
            return false;
        }
        
        for (int i = 0; i < neurons.size(); i++){
            neurons.get(i).setOutput(values[i]);
        }
           
        return true;
    }
    
    @Override
    public void connectProviderLayer(NeuralLayerIntf providerLayer, InitializerIntf weightInitializer){
        for (Neuron neuron : neurons){
            for (Neuron providerNeuron : providerLayer.getNeurons()){
                neuron.AddInput(providerNeuron, new NeuralFactor(weightInitializer.getValue()));
            }
        }
    }

    @Override
    public boolean updateErrorsFromExpectedResults(double[] expectedResults, RangeTransformIntf sigmoid) {
        if (expectedResults.length != getCount()){
            System.out.printf("Unable to update neuron errors from desired results, because neuron array size [%d] does not match desired result array size [%d].\n", getCount(), expectedResults.length);
            return false;
        }

        int result = 0;
        for (Neuron neuron : neurons){
            neuron.setError((expectedResults[result] - neuron.getOutput()) * sigmoid.derivative(neuron.getOutput()));
            result++;
        }
        
        return true;
    }

    @Override
    public boolean updateErrorsFromConsumerLayer(NeuralLayerIntf consumerLayer, RangeTransformIntf sigmoid) {
//        if (consumerLayer.getCount() != getCount()){
//            System.out.printf("Unable to update provider layer neuron errors from consumer layer values, because neuron array size [%d] does not match consumer layer array size [%d].\n", getCount(), consumerLayer.getCount());
//            return false;
//        }

        double errorSummedFromConsumerLayer, providerLayerOutput;
        for (Neuron providerLayerNeuron : neurons){
            
            providerLayerOutput = providerLayerNeuron.getOutput();
                    
            //iterate across all the consumer layer neurons and sum the weighted
            //errors multiplied by the sigmoid derivative of the provider layer 
            //output value
            errorSummedFromConsumerLayer = 0;
            for (Neuron consumerLayerNeuron : consumerLayer.getNeurons()){
                errorSummedFromConsumerLayer += consumerLayerNeuron.getError() * consumerLayerNeuron.getInputs().get(providerLayerNeuron).getWeight() * sigmoid.derivative(providerLayerOutput);
            }
            
            //update the error at the provider layer, based on the computed
            //deviations from the consumer layer
            providerLayerNeuron.setError(errorSummedFromConsumerLayer);
        }
               
        return true;
    }
    
    @Override
    public boolean updateDeltasBasedOnCurrentErrors(NeuralLayerIntf providerLayer){
        // iterate across all the neurons in this layer
        for (Neuron consumerNeuron : neurons){
            
            // iterate across all the neurons in the provider layer, i.e. the 
            // layer that provides data to this layer, and update the "delta"
            // based on the error in the consumer layer multiplied by the 
            // value output (sent to the consumer layer) from the provider layer.
            // ... I think this is effectively saying: set the change on the 
            //     provider layer to how far off the answer was from the expected
            //     answer.
//            for (Neuron providerNeuron : providerLayer.getNeurons()){
//                consumerNeuron.getInputs().get(providerNeuron).addDelta(consumerNeuron.getError() * providerNeuron.getOutput());
//            }
            providerLayer.getNeurons().forEach((providerNeuron) -> {consumerNeuron.getInputs().get(providerNeuron).addDelta(consumerNeuron.getError() * providerNeuron.getOutput());});
            
            consumerNeuron.addDelta(consumerNeuron.getError() * consumerNeuron.getWeight());
        }
        
        return true;
    }
    
    @Override
    public double[] getOutputValues() {
        double[] outputs = new double[getCount()];
        
        for (int i = 0; i < getCount(); i++) {
            outputs[i] = getNeurons().get(i).getOutput();
        }
        
        return outputs;
    }
//</editor-fold>

    
}
