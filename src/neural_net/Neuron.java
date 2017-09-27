/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import java.util.Map;

/**
 * @author kwl
 *  http://www.c-sharpcorner.com/article/C-Sharp-artificial-intelligence-ai-programming-a-basic-object/
 */
public class Neuron implements NeuronIntf, NeuralFactorIntf, NeuralSignalIntf, NeuralReceptorIntf {

    private static final long serialVersionUID = 0L;

//<editor-fold defaultstate="collapsed" desc="Constructors">    
    public Neuron(double biasWeight){ 
        bias = new NeuralFactor(biasWeight);
        receptor = new NeuralReceptor();     
        error = 0.0;
    }  
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private double error;
    private double lastError;
    private double lastDelta;
    
    /**
     * @return the error
     */
    @Override
    public double getError() {
        return error;
    }
    
    /**
     * @param value the error to set
     */
    @Override
    public void setError(double value) {
        this.lastError = this.error;
        this.error = value;
    }
    
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="NeuralFactorIntf">
    private NeuralFactorIntf bias;
    
    @Override
    public double getWeight() {
        return bias.getWeight();
    }
    
    @Override
    public void setWeight(double weight) {
        bias.setWeight(weight);
    }
    
    @Override
    public double getDelta() {
        return bias.getDelta();
    }
    
    @Override
    public void setDelta(double delta) {
        bias.setDelta(delta);
    }
    
    @Override
    public void addDelta(double delta) {
        bias.addDelta(delta);
    }
    
    @Override
    public void resetWeightChange() {
        bias.resetWeightChange();
    }//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="NeuralReceptorIntf">
    
    private final NeuralReceptor receptor;
    
    @Override
    public Map<NeuralSignalIntf, NeuralFactorIntf> getInputs() {
        return receptor.getInputs();
    }

    @Override
    public void AddInput(NeuralSignalIntf signal, NeuralFactorIntf factor) {
        receptor.getInputs().put(signal, factor);
    }

    @Override
    public void RemoveInput(NeuralSignalIntf signal) {
        receptor.getInputs().remove(signal);
    }

    @Override
    public double getWeightedInput() {
        return receptor.getWeightedInput();
    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="NeuralSignalIntf">
    private double output;
    
    @Override
    public double getOutput() {
        return output;
    }
    
    @Override
    public void setOutput(double output) {
        this.output = output;
    }
//</editor-fold>
 
//<editor-fold defaultstate="collapsed" desc="NeuronIntf">
    /**
     * 
     * This function sums the weight-adjusted input values to this neuron - as
     * provided by the NeuralReceptor object - then adds the result to the 
     * current bias weight; finally, the neuron's output value is adjusted/scaled
     * to the range 0 to 1 using the sigmoid function.
     */
    @Override
    public void pulse(){
        output = Sigmoid.applyTransform(receptor.getWeightedInput() + bias.getWeight());
    }

    @Override
    public void applyLearning(double learningRate) {
        receptor.getInputs().entrySet().forEach((input) -> {
            input.getValue().applyWeightChange(learningRate);
        });
        
        bias.applyWeightChange(learningRate);      
    }
    
    @Override
    public void initializeLearning() {
        receptor.getInputs().entrySet().forEach((input) -> {
            input.getValue().resetWeightChange();
        });
        
        bias.resetWeightChange();
    }
    
    @Override
    public NeuralFactorIntf getNeuralFactor() {
        return bias;
    }
    
    @Override
    public void setNeuralFactor(NeuralFactorIntf neuralFactor) {
        bias = neuralFactor;
    }
    
    @Override
    public double getLastError() {
        return lastError;
    }
    
    @Override
    public void setLastError(double lastError) {
        this.lastError = lastError;
    }
    
    @Override
    public double getLastDelta() {
        return lastDelta;
    }
    
    @Override
    public void applyWeightChange(double learningRate) {
        bias.applyWeightChange(learningRate);
    }
//</editor-fold>

}
