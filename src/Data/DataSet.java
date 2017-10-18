/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author kwl
 */
public class DataSet extends ArrayList {

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public DataSet(){}
    
    public DataSet(Double[] items){
        loadDouble(items);
    }
    
    public DataSet(ArrayList items){
        addAll(items);
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Methods">
    public final boolean loadDouble(Double[] items){
        return addAll(Arrays.asList(items));
    }
//</editor-fold>
    
}
