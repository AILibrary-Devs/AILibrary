/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author kwl
 * @param <T>
 */
public interface IODataSetPairIntf<T> {
    public int size();
    
    public Iterable<T> getInputs();
    public Iterable<T> getOutputs();
}
