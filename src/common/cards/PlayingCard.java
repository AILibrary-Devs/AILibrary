/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.cards;

/**
 *
 * @author kwl
 */
public class PlayingCard {

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public PlayingCard(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Properties">
    private Suit suit;
    private Rank rank;
    
    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }
    
    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    
    /**
     * @return the rank
     */
    public Rank getRank() {
        return rank;
    }
    
    /**
     * @param rank the rank to set
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }
//</editor-fold>
}
