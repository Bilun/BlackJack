package blackjack;

public class CardIndexer {
	public CardIndexer(){
		
	}
	
	public static String intToCard(int cardNum) {
		// converts hand from integer values(cards are indexed in ascending numeric order
	    // starting with ace, first spades, then diamonds, then hearts, then clubs
		//so ace of spades is "0", 4 of hearts is 29, and king of diamonds is 25)
		String cardSuit="ErrorInvalidSuit";
		if(cardNum>51){
			return "invalid card index";
		}
		else if(cardNum>39){
			cardSuit="Clubs";
		}
		else if(cardNum>26){
			cardSuit="Hearts";
		}
		else if(cardNum>13){
			cardSuit="Diamonds";
		}
		else if(cardNum>=0){
			cardSuit="Spades";
		}
		else{
			return "invalid card index";
		}
		
		String cardString = "No cardstrike specified, suit is: "+cardSuit;
		if(cardNum%13==0){
			cardString="Ace of "+cardSuit;
		}
		else if(cardNum%13==1){
			cardString="Two of "+cardSuit;
		}
		else if(cardNum%13==2){
			cardString="Three of "+cardSuit;
		}
		else if(cardNum%13==3){
			cardString="Four of "+cardSuit;
		}
		else if(cardNum%13==4){
			cardString="Five of "+cardSuit;
		}
		else if(cardNum%13==5){
			cardString="Six of "+cardSuit;
		}
		else if(cardNum%13==6){
			cardString="Seven of "+cardSuit;
		}
		else if(cardNum%13==7){
			cardString="Eight of "+cardSuit;
		}
		else if(cardNum%13==8){
			cardString="Nine of "+cardSuit;
		}
		else if(cardNum%13==9){
			cardString="Ten of "+cardSuit;
		}
		else if(cardNum%13==10){
			cardString="Jake of "+cardSuit;
		}
		else if(cardNum%13==11){
			cardString="Queen of "+cardSuit;
		}
		else if(cardNum%13==12){
			cardString="King of "+cardSuit;
		}
		return cardString;
	}






}