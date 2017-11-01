/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

/**
 *
 * @author kwl
 */
public enum Suit {
    HEARTS(1), SPADES(2), DIAMONDS(3), CLUBS(4);
    
//<editor-fold defaultstate="collapsed" desc="Constructors and Factory ">
    private Suit(int value){
        this.value = value;
    }
    
    public static Suit getSuit(int value){
       switch (Suit.value(value)) {
           case (1): return Suit.HEARTS;
           case (2): return Suit.SPADES;
           case (3): return Suit.DIAMONDS;
           default: return Suit.CLUBS;
       }
    }
    public static Suit getSuit(double normalized){
        return getSuit(Suit.value(normalized));
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private final int value;
    
    public int value(){
        return value;
    }

    private static final double NORMALIZATION_FACTOR = 4.0;
    
    public static int value(double normalized){
        return (int) Math.round(normalized * NORMALIZATION_FACTOR);
    }
    
    public double normalized(){
        return normalized(value);
    }
    
    public static double normalized(int value){
        return value / NORMALIZATION_FACTOR;
    }
//</editor-fold>
    
}
