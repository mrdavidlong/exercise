package exercise;

// Determine the Cribbage score (simplified) for a hand of four cards.  Rules:
// a) "Fifteen" any 2 cards' values sum to 15 => 2 points
//        (where value of Jack,Queen,King = 10, Ace = 1).
// b) "Pair" any two cards with same rank => 2 points.
// c) "flush" all four cards with same suit => 4 points.
// Example: [Jack Hearts, Jack Clubs, 5 Spades, Queen Clubs] ==> 8 pts 
//  2 pts:  Jack Hearts + 5 = 15
//  2 pts:  Jack Clubs  + 5 = 15 
//  2 pts:  Queen Clubs + 5 = 15
//  2 pts:  Pair of Jacks)

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// enum of suit
// cards values: 1 to 10, names

enum Suit {
  Club (0),
  Diamond (1),
  Heart (2),
  Spade (3);
  
  private int value;
  private Suit(int v) {
    value = v;
  }
//  
//  public static Suit getSuit(int value) {
//    switch (value) {
//      case 0:
//        return Suit.Club;
//      case 1:
//        return Suit.Diamond;
//      case 2:
//        return Suit.Heart;
//      case 3:
//        return Suit.Spade;
//      default:
//        return null;
//    }
//  }
}

class Card {
  public int rankIndex;
  public Suit suit;
  
  public String[] ranks = {"A", "2", "3", "4", "5", "6", "7",  "8", "9", "10", "J", "Q", "K"};
  
  public int[] rankValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
  
  public Card(String rank, Suit s) {
    for (int i = 0; i < ranks.length; i++) {
      if (ranks[i] == rank) {
        rankIndex = i;
      }
    }
    
    suit = s;
  }
  
  public String getRank() {
    return ranks[rankIndex];
  }
  
  public int getValue() {
    return rankValue[rankIndex];
  }
}

class BestResult {
  public int score;
  public Card[] cards;
}


// Example: [Jack Hearts, Jack Clubs, 5 Spades, Queen Clubs] ==> 8 pts 
class Cribbage {
  public static void main(String[] args) {
    Card c1 = new Card("J",Suit.Heart);
    Card c2 = new Card("J",Suit.Club);
    Card c3 = new Card("5",Suit.Spade);
    Card c4 = new Card("Q",Suit.Club);
    Card c5 = new Card("3",Suit.Heart);
    Card c6 = new Card("A",Suit.Spade);
    
    Card[] cards = {c1, c2, c3, c4};
    int result = getScore(cards);
    System.out.println("Score of 4 cards:");
    System.out.println(result);
    
    Card[] sixCards = {c1, c2, c3, c4, c5, c6};
    BestResult bestResult = getBestScore(sixCards);
    System.out.println("Best Result out of Six:");
    System.out.println(bestResult.score);
    for (Card c : bestResult.cards) {
    	System.out.println(c.getRank() + " " + c.suit );
    }
  }
  
// a) "Fifteen" any 2 cards' values sum to 15 => 2 points
//        (where value of Jack,Queen,King = 10, Ace = 1).
// b) "Pair" any two cards with same rank => 2 points.
// c) "flush" all four cards with same suit => 4 points.
// Example: [Jack Hearts, Jack Clubs, 5 Spades, Queen Clubs] ==> 8 pts 
//  2 pts:  Jack Hearts + 5 = 15
//  2 pts:  Jack Clubs  + 5 = 15 
//  2 pts:  Queen Clubs + 5 = 15
//  2 pts:  Pair of Jacks)

  // Question: Determine the best Cribbage hand keeping four out of six cards dealt.
  

  
  public static BestResult getBestScore(Card[] cards) {
    int maxScore = 0;
    Card[] newCards = new Card[4];
    Card[] bestCards = new Card[4];
    for (int i = 0; i < cards.length - 1; i++) {
      for (int j = i+1; j < cards.length; j++) {
        int index = 0;
        for (int k = 0; k < cards.length; k++) {
          if (k != i && k != j) {
            newCards[index] = cards[k];
            index++;
          }
        }
        int score = getScore(newCards);
        if (score > maxScore) {
          maxScore = score;
          
          bestCards = newCards.clone();
          
        }
      } 
    }
    BestResult result = new BestResult();
    result.score = maxScore;
    result.cards = bestCards;
    return result;
  }
  
  public static int getScore(Card[] cards) {
    int score = 0;
    
    // rule 1 and 2
    for (int i = 0; i < cards.length-1; i++) {
      for (int j = i+1; j <cards.length; j++) {
        if (cards[i].getValue() + cards[j].getValue() == 15) {
          score += 2;
        }
        
        if (cards[i].suit == cards[j].suit) {
          score += 2;
        }
      }
    }
    
    // rule 3
    Suit s = cards[0].suit;
    int numSameSuit = 1;
    for (int i = 1; i < cards.length; i++) {
      if (cards[i].suit == s) {
        numSameSuit++;
      }
    }
    if (numSameSuit == 4) {
      score += 4;
    }
    return score;
  }
}

