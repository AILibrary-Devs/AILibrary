/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_net;

import common.InitializerIntf;

/**
 *
 * @author kwl
 */
public interface NeuralLayerFactoryIntf {
    // generic factory method, to make creating layers easier... (may change this)
    NeuralLayerIntf getNeuralLayer(int neuronCount, InitializerIntf neuronBiasInitializer);
}
