package polymorphism;

public class Dog extends Animal {
	Dog() {
		System.out.println("Instantiating Dog");
		
	}
	public void makeSound() {
		System.out.println("sounds is Woof");
	}
	
	public void whichAnimal() {
		System.out.println("Animal is Dog");
	}
}
