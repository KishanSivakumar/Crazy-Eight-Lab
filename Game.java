import java.util.Scanner;
import java.util.ArrayList;

public class Game{

    private char currentSuit; // need in case an 8 is played
    private Card faceup; 
    private Scanner input;
    private Player p1;
    private ArrayList<Card> compHand;
    private Deck cards;
    
    // sets up the Game object for play
    public Game(){
        cards = new Deck();
        p1 = new Player();
        compHand = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            p1.addCard(cards.deal());
            compHand.add(cards.deal());
        }
        faceup  = cards.deal();
        input = new Scanner(System.in);
    }
    public Card getFaceUp()
    {
        return faceup;
    }
    public Deck getCards()
    {
        return cards;
    }

    // Plays a game of crazy eights. 
    // Returns true to continue playing and false to stop playing
    public boolean play(){
        boolean compTurn=false;
        while((p1.getHand().size()>0 && compHand.size()>0 && cards.canDeal()==true))
        {
            if(compTurn==false)
            {
                 faceup=p1.playsTurn(cards,faceup);   
                 compTurn=true;
            }
            else
            {
                faceup=computerTurn();
                compTurn=false;
            }
        }
        if(cards.canDeal()==false)
        {
            if(p1.getHand().size()<compHand.size())
            {
                System.out.println("Player 1 is the winner! Congratulations, with the match ending by the the exhaustion of the stock pile, by having less cards you are declared the winner!");
            }
            else if(p1.getHand().size()>compHand.size())
            {
                System.out.println("Unfortunately, your opponent has triumphed. With the match ending by the the exhaustion of the stock pile, by having more cards you are declared the loser...");
            }
            else
            {
                System.out.println("This match has ended as a tie...");
            }
        }
        else if(p1.getHand().size()==0)
        {
            System.out.println("Player 1 is the winner! Congratulations, with the match ending by the the exhaustion of your hand, you are declared the winner!");
        }
        else
        {
            System.out.println("Unfortunately, your opponent has triumphed. With the match ending by the the exhaustion of your opponent's hand, they are declared the winner!");
        }
        System.out.println("Would you like to play again? Type 1 for YES and 2 for NO");
        int finalChoice=input.nextInt();
        if(finalChoice==1)
        {
            return true;
        }
        return false;
    }

    /* Naive computer player AI that does one of two actions:
        1) Plays the first card in their hand that is a valid play
        2) If no valid cards, draws until they can play

        You may choose to use a different approach if you wish but
        this one is fine and will earn maximum marks
     */
     private Card computerTurn(){
        for(int i=0;i<compHand.size();i++)
        {
            if(compHand.get(i).equals(getFaceUp())||compHand.get(i).getRank()==8)
            {
                return compHand.get(i);
            }
        }
        compHand.add(cards.deal());
        return faceup;
    }
    
   // you will likely wish to have several more helper methods to simplify
   // and shorten the methods above.


}