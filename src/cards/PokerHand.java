/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

/**
 *
 * @author kwl
 * 
 *       Ordinal (0-9)

      0: Nothing in hand; not a recognized poker hand 
      1: One pair; one pair of equal ranks within five cards
      2: Two pairs; two pairs of equal ranks within five cards
      3: Three of a kind; three equal ranks within five cards
      4: Straight; five cards, sequentially ranked with no gaps
      5: Flush; five cards with the same suit
      6: Full house; pair + different rank three of a kind
      7: Four of a kind; four equal ranks within five cards
      8: Straight flush; straight + flush
      9: Royal flush; {Ace, King, Queen, Jack, Ten} + flush

 */
public enum PokerHand {
    
    NOTHING(0), ONE_PAIR(1), TWO_PAIRS(2), THREE_OF_A_KIND(3), STRAIGHT(4), FLUSH(5), FULL_HOUSE(6), FOUR_OF_A_KIND(7), STRAIGHT_FLUSH(8), ROYAL_FLUSH(9);
    
    private PokerHand(int value){
        this.value = value;
    }
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private final int value;
    
    /**
     * @return the value
     */
    public int value() {
        return value;
    }
    private static final double NORMALIZATION_FACTOR = 9.0;
    
    public int value(double normalized){
        return (int) Math.round(normalized * NORMALIZATION_FACTOR);
    }
    
    public double normalized(){
        return normalized(this.value);
    }

    public static double normalized(int value){
        return value / NORMALIZATION_FACTOR;
    }
//</editor-fold>
    
}
