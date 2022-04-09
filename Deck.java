import java.util.ArrayList;

public class Deck{

    private ArrayList<Card> deck; // contains the cards to play with
    private int top; // controls the "top" of the deck to deal from
    private final char [] suits = {'h','c','s','d'};
    private final int [] ranks = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    // constructs a default Deck
    public Deck() {
        deck = new ArrayList<>();
        for (int i = 0; i < ranks.length; i++) {
            for (char suitString : suits) {
                deck.add(new Card(suitString, ranks[i]));

            }
        }
        shuffle();

    }

    // Deals the top card off the deck
    public Card deal(){
        return deck.remove(0);

    }


    // returns true provided there is a card left in the deck to deal
    public boolean canDeal(){
        return deck.size()>0;
    }

    // Shuffles the deck
    public void shuffle(){
        for (int i = 51; i > 0; i--) {
            int r = (int)(Math.random() * i);
            Card temp = deck.get(i);
            deck.set(i, deck.get(r));
            deck.set(r, temp);
        }
    }

    // Returns a string representation of the whole deck
    public String toString(){
        String deckString="";
       for(int i=0;i<deck.size();i++)
       {
            deckString="|||" +deck.get(i).toString() + "|||";
       }
       return deckString;
    }

    // you may wish to have more helper methods to simplify
    // and shorten the methods above.
}