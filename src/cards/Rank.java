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
public enum Rank {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
    
//<editor-fold defaultstate="collapsed" desc="Constructors and Factory Methods">
    private Rank(int value){
        this.value = value;
    }

    public static Rank getRank(int value){
       switch (Suit.value(value)) {
           case (1): return Rank.ACE;
           case (2): return Rank.TWO;
           case (3): return Rank.THREE;
           case (4): return Rank.FOUR;
           case (5): return Rank.FIVE;
           case (6): return Rank.SIX;
           case (7): return Rank.SEVEN;
           case (8): return Rank.EIGHT;
           case (9): return Rank.NINE;
           case (10): return Rank.TEN;
           case (11): return Rank.JACK;
           case (12): return Rank.QUEEN;
           default: return Rank.KING;
       }
    }
    
    public static Rank getRank(double normalized){
        return getRank(Suit.value(normalized));
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private final int value;
    
    public int value(){
        return value;
    }

    private static final double NORMALIZATION_FACTOR = 13.0;
    
    public int value(double normalized){
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
