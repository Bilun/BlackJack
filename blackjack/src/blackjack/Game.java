package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	Deck ourDeck;
	List<Player> nonDealerPlayers=new ArrayList<Player>();
	Player theDealer;
	//Deck gameDeck;
	Scanner input;

	public Game(){
		
		input= new Scanner(System.in);
		System.out.println("Name your player...");
		String playerName=input.nextLine();
		Player addedPlayer=new Player(playerName);
		nonDealerPlayers.add(addedPlayer);
		theDealer=new Player("The Dealer", true);
		//created all player objects
				
		
		ourDeck=new Deck();
		//creates deck object to be used in game
	}
	public void playRound(){
		List<Boolean> playerIn=new ArrayList<Boolean>();
		//for any player who has chosen to stay or busted, playerOut will be
		//False at the same index as the player is in nonDealerPlayers
		
		Player currentPlayer;
		//local variable to track which player is currently being given the option to hit/stay
		
		for(int cardsDealt=0; cardsDealt<2; cardsDealt++){
			//deals initial 2 card hands
			
			for(int player=0; player<nonDealerPlayers.size();player++){
				
				
				ourDeck.dealCard(nonDealerPlayers.get(player));
				
				if(cardsDealt==0){
					playerIn.add(true);
					//convenient time to populate playerIn to the right size
				}
				
			}
			ourDeck.dealCard(theDealer);
		}
		boolean playersDone=false;
		while(playersDone==false){
			//loop for player hit/stay phase
			playersDone=true; // if no players act this will break loop
			
			for(int player=0; player<nonDealerPlayers.size();player++){
				//hit or stay phase of game
				if(playerIn.get(player)){
					playersDone=false; 
					//so long as any player acts loop condition if renewed
					
					currentPlayer=nonDealerPlayers.get(player);
					//temporary local variable which is more explanatory then
					//nonDealerPlayers.get(player).  once hit/stay decision
					//has been made all changes to currentPlayer are copies to
					// the actual object field for the player.
				
					int entryCount=0;
					while( entryCount<10 ){//gives 10 tries to correctly respond then chooses "stay"
						currentPlayer.printPlayerHand();
						theDealer.printPlayerHand();
						System.out.println("enter 'hit' or 'stay'");
						System.out.println(currentPlayer.playerName+" enter 'h' to hit or 's' to stay.");
						String entry=input.next();
						System.out.println(entry);
						if(entry.equals("h")){
							entryCount=11;
							ourDeck.dealCard(currentPlayer);
							if(currentPlayer.computeTotal()==-1){
								System.out.println(currentPlayer.playerName+" Busts!");
								playerIn.set(player, false);
							
							
							}
							nonDealerPlayers.set(player, currentPlayer);
							//  moving the updated local variable's data back to the object field
						}
						else if(entry.equals("s")){
							entryCount=11;
							playerIn.set(player, false);
						
							nonDealerPlayers.set(player, currentPlayer);
							//  moving the updated local variable's data back to the object field
						}
						else{
							entryCount++;
							if(entryCount>=10){
								playerIn.set(player, false);
							
								nonDealerPlayers.set(player, currentPlayer);
								//  moving the updated local variable's data back to the object field
							}
						}
					
					
				
					
					}
				
				
				
				}
			
			}
		}
		
		
		
		//time to resolve the dealer!
		theDealer.dealerReveal();
		int dealerTotal=theDealer.computeTotal();
		while((dealerTotal<=16)&&(dealerTotal>0)){
			ourDeck.dealCard(theDealer);
			dealerTotal=theDealer.computeTotal();
		}
		
		if (dealerTotal==-1){
			System.out.println("Dealer Busts! All players win!");
		}
		else{
			//List<Player> winners=new ArrayList<Player>();
		//	List<Player> ties=new ArrayList<Player>();
			for(int player=0; player<nonDealerPlayers.size();player++){
				if(nonDealerPlayers.get(player).computeTotal()>dealerTotal){
					System.out.println(nonDealerPlayers.get(player).playerName+" wins!");
				}
				else if(nonDealerPlayers.get(player).computeTotal()==dealerTotal){
					System.out.println(nonDealerPlayers.get(player).playerName+" ties!");
				}
				else{
					System.out.println(nonDealerPlayers.get(player).playerName+" loses!");
				}
			}
		}
		
			
		
		
	}
	public void resetGameState(){
		
	}
}
