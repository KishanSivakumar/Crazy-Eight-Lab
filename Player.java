import java.util.ArrayList;
import java.util.Scanner;

public class Player{
    
    private ArrayList<Card> hand; // the player's hand
    private Scanner input;

    public Player(){
        hand = new ArrayList<>();
        input = new Scanner(System.in);

    }

    // Adds a card to the player's hand
    public void addCard(Card c){
        hand.add(c);
    }
   
    // Covers all the logic regarding a human player's turn
    // public so it may be called by the Game class
    public Card playsTurn(Deck d,Card f){
        System.out.println("These are the cards you have" + getHand());
        ArrayList<Card>playableIndex=new ArrayList<>();
        boolean canPlay=false;
        for(int i=0;i<hand.size();i++)
        {
            if(hand.get(i).equals(f)||hand.get(i).getRank()==8)
            {
                playableIndex.add(hand.get(i));
                canPlay=true;
            }
        }
        if(canPlay==true)
        {
            System.out.println("Please pick a card by signifying a number 1-" + playableIndex.size() + " to decide which card you wish to use, the playable cards that you can choose are -> " + playableIndex + " the face up is " + f);
            int choice=input.nextInt();
            System.out.println("This is the faceup " + f + " " + choice );
            if(playableIndex.get(choice-1).getRank()==8)
            {
                System.out.println("By placing this 8, you may now choose the suit that must be followed, please indicate which suit you would like to use(s for spades, d for diamond, c for club, and h for heart)");
                input.nextLine();
                String choiceSuit=input.nextLine();
                hand.remove(getIndex(playableIndex.get(choice-1)));
                return new Card(choiceSuit.charAt(0),8);
            }
            hand.remove(getIndex(playableIndex.get(choice-1)));
            return playableIndex.get(choice-1);
        }
        else
        {
            System.out.println("You have no available options to play, therefore you must pick a card from the stock pile");
            addCard(d.deal());
            return f;
        }
    }
    public int getIndex(Card c)
    {
        for(int i=0;i<hand.size();i++)
        {
            if(hand.get(i).getRank()==c.getRank() && hand.get(i).getSuit()==c.getSuit())
            {
                return i;
            }
        }
        return -1;
    }
    // Accessor for the players hand
    public ArrayList<Card> getHand(){
        return hand;
    }

    // Returns a printable string representing the player's hand
    public String handToString(){
        return hand.toString();
    }

    // you will likely wish to have several more helper methods to simplify
    // and shorten the methods above.

} // end