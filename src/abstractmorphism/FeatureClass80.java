package abstractmorphism;

public class FeatureClass80 extends BaseFeatureClass {
	public FeatureClass80(){
		System.out.println("constructor of FeatureClass80");
		j = 80;
		i = 80;
	}
	void whichTest(String a) {
		System.out.println("method from FeatureClass80 called");
	}
	public void makeSound() {
		System.out.println("sounds is Woof");
	}
	
	public void whichAnimal() {
		System.out.println("Animal is Dog");
	}
}
