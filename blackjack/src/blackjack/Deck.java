package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Integer> drawPile;
	List<Integer> fullDeck=new ArrayList<Integer>();;
	
	public Deck(){

		// Initializes and shuffles the deck
		for(Integer cardIndex=0; cardIndex<52;cardIndex++){
		//	System.out.println(cardIndex);
			fullDeck.add(cardIndex);
			
		}
		drawPile=fullDeck;
		Collections.shuffle(drawPile);
		
		
	}
	public void dealCard(Player dealtTo){
		//removes the index 0 card from deck and returns the integer corresponding
		//uniquely to that card's suit and face values(see cardIndexer class for details)
		Thread.sleep(750);
		int nextCard=drawPile.get(0);
		dealtTo.addCard(nextCard);
		drawPile.remove(0);
		
		
	}
	public void shuffleDeck(){
		Collections.shuffle(drawPile);
	}
	public void rebuildDeck(){
		drawPile=fullDeck;
		Collections.shuffle(drawPile);
	}
}
