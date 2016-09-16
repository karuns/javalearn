package polymorphism;

public class Cat extends Animal {
	Cat() {
		System.out.println("Instantiating Cat");
		
	}
	public void makeSound() {
		System.out.println("sounds of animal is mew");
	}
	
	public void food() {
		System.out.println("drinks milk");
	}
}
