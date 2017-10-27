/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kwl
 */
public class NeuralReceptors implements NeuralReceptorsIntf {

    private static final long serialVersionUID = 0L;

//<editor-fold defaultstate="collapsed" desc="Properties">
    {
        inputs = new HashMap<>();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Properties">
    private final HashMap<NeuralSignalIntf, NeuralFactorIntf> inputs;

    @Override
    public Map<NeuralSignalIntf, NeuralFactorIntf> getInputs() {
        return inputs;
    }

    @Override
    public void AddInput(NeuralSignalIntf signal, NeuralFactorIntf factor) {
        inputs.put(signal, factor);
    }

    @Override
    public void RemoveInput(NeuralSignalIntf signal) {
        inputs.remove(signal);
    }

    @Override
    public double getWeightedAggregateInput() {
        double weightedInput = 0.0;
        weightedInput = inputs.entrySet().stream().map((input) -> input.getKey().getOutput() * input.getValue().getWeight()).reduce(weightedInput, (accumulator, _item) -> accumulator + _item);
        return weightedInput;
    }
//</editor-fold>
}
