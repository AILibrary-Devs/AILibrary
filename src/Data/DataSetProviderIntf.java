/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author kwl
 */
public interface DataSetProviderIntf {
    int count();
    int current();
    boolean hasNext();
    
}
