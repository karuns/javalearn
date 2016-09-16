package intr.cardgame;
import java.util.Random;
import java.util.Stack;

public class Deck {
	
	Stack<Integer> cardStack = new Stack<Integer>();
	Random rad = new Random();
	public Deck () {	
		for(int i = 1; i<=52 ;i++) {
			cardStack.push(i);
		}
	}
	private String getCardSymbol(Integer i) {
		if(i<=13) {
			return "spade";
		}
		else if(i>13 && i <=26) {
			return "hearts";
		}
		else if(i>26 && i <=39) {
			return "clubs";
		}
		else {
			return "diamonds";
		}
	}
	
	private String getCardNumber(Integer i) {
		i = i%13;
		if(i==0) {
			i=13;
		}
		return Integer.toString(i);
	}
	
	public void shuffle () {
		for(int i = cardStack.size()-1;i>=0 ;i--) {
			Integer temp = cardStack.get(i);
			Integer tempIndex = rad.nextInt(cardStack.size()-1);
			cardStack.set(i,cardStack.get(tempIndex));
			cardStack.set(tempIndex,temp);
		}
	}
	
	public void deal(int NumberOfPlayer) {
		Integer i = 0;
		while(!cardStack.isEmpty()) {
			i++;
			i = i%NumberOfPlayer;
			if(i==0){ 
				i = NumberOfPlayer;
			}
			
			Integer tempInt = cardStack.pop();
			System.out.println("Player ("+Integer.toString(i)+") got ("+getCardNumber(tempInt)+" of "+getCardSymbol(tempInt)+")");
		}
		
	}

}
