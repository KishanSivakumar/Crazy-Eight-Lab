public class Card{
    
    private char suit;
    private int rank;

    // Initializes a card instance
    public Card(char suit, int rank){
       this.suit = suit;
       this.rank = rank;
    }

    // Accessor for suit
    public char getSuit(){
        return suit;
    }
    
    // Accessor for rank
    public int getRank(){
       return  rank;
    }
    public boolean equals(Object obj)
    {
        Card card=(Card)obj;
        if(card.getSuit()==(suit)||card.getRank()==rank)
        {
            return true;
        }
        return false;
    }
    // Returns a human readable form of the card (eg. King of Diamonds)
    public String toString(){
        String temp="";
        String tempRank="";
        if(suit=='d')
        {
            temp="Diamonds";
        }
        if(suit=='h')
        {
            temp="Hearts";
        }
        if(suit=='s')
        {
            temp="Spades";
        }
        if(suit=='c')
        {
            temp="Clubs";
        }
        if(rank>10)
        {
            if(rank==13)
            {
                tempRank="King";
            }
            if(rank==12)
            {
                tempRank="Queen";
            }
            if(rank==11)
            {
                tempRank="Jack";
            }
            return tempRank + " of " + temp;
        }
        return rank + " of " + temp;
    }
}