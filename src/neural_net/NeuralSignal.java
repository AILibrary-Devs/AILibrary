/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

/**
 *
 * @author kwl
 */
public class NeuralSignal implements NeuralSignalIntf {

    private static final long serialVersionUID = 0L;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public NeuralSignal(double output){
        this.output = output;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Properties">
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
    
}
