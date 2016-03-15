package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
	List<Integer> hand=new ArrayList<Integer>();
	List<Integer>  hiddenCard=new ArrayList<Integer>();
	boolean dealer;
	String playerName;
	
	public Player(String name, boolean isDealer){
		dealer=isDealer;
		playerName=name;
	}
	public Player(String name){
		dealer=false;
		playerName=name;
	}
	
	public void addCard(int newCardIndex){
		if((dealer)&&(hiddenCard.size()==0)){
			hiddenCard.add(newCardIndex);
			System.out.println(playerName+" is dealt a card facedown...");
		}
		else{
			hand.add(newCardIndex);
			System.out.println(playerName+" is dealt the "+CardIndexer.intToCard(newCardIndex)+"!");
		}
		
	}
	public void printPlayerHand(){
		String gameStateBlurb=playerName+" has:";
        //generic opener for blurb
		
		for(int cardPos=0; cardPos<hand.size(); cardPos++){
			if((cardPos==(hand.size()-1) && (hand.size()>=2)  && (hiddenCard.size()==0))){
				gameStateBlurb+=" and ";
				//adds "and" before last entry of listed cards for hand sizes at least two in which the last card isn't hidden
			}
			gameStateBlurb+=(" "+CardIndexer.intToCard(hand.get(cardPos)));
			if((hand.size()>=3)||((hand.size()>=2)&&(hiddenCard.size()==1))){
				//adds commas if there are at least 3 cards listed
				gameStateBlurb+=",";
			}
			
		}
		if(dealer){
			gameStateBlurb+=" and one card face down.";
		}
		else{
			gameStateBlurb+=".";
		}
		
		if(hiddenCard.size()>1){
			//precaution to catch if somehow more then one card every makes it into hiddenCard list
			gameStateBlurb+=" ERROR, MULTIPLE HIDDEN CARDS!";
		}
		
		System.out.println(gameStateBlurb);
		
	}
	public int computeTotal(){
		//finds the best non-bust score of player's current hand and returns that
		// Value.  On a bust returns -1
		
		int score=0;
		int aces=0;
		
		for(int cardPos=0; cardPos<hand.size(); cardPos++){
			int cardIndex=hand.get(cardPos);
			if((cardIndex%13>=10)&&(cardIndex%13<=12)){
				score+=10;
			//	System.out.println(score);
			}
			else if(cardIndex%13!=0){
				score+=(cardIndex%13+1);
			//	System.out.println(score);
			}
			else{
				aces+=1;
				score+=11;
				//System.out.println(score);
			}
		}
		for(int options=0;options<aces;options++){
			if (score>21){
				score-=10;
				aces-=1;
				//System.out.println(score);
			}
	
		}
		if (score<=21){
			return score;
		}
		return -1;
		
	}
	
	public void dealerReveal(){
		// player reveals hidden card and adds it to hand.
		System.out.println("Dealer turns facedowncard up, it's the "+CardIndexer.intToCard(hiddenCard.get(0))+".");
		hand.add(hiddenCard.get(0));
		if(hiddenCard.size()>1){
			//one more chance to catch a bug
			System.out.println("SOMETHINGS BROKE, FOR SOME REASON THERE WERE MORE THEN ONE HIDDEN CARDS");
		}
	}
	

}
