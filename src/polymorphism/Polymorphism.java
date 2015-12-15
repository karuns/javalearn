package polymorphism;

import org.testng.annotations.Test;

public class Polymorphism {
	@Test
	public void polymorphysm() {
		Animal dog = new GoldenRetriver();
		dog.makeSound();
		dog.whichAnimal();
		
		Animal cat = new Cat();
		cat.makeSound();
	}
}
