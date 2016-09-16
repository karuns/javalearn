package intr.cardgame;

public class CardGame {
	public static void main (String[] args) {
		System.out.println("Game starting");
		System.out.println("Let's get the deck initialized first");
		
		Deck deck = new Deck();
		deck.shuffle();
		deck.deal(4);
	}
}
