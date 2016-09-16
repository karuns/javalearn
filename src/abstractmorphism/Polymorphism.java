package abstractmorphism;

import org.testng.annotations.Test;

public class Polymorphism {
	@Test
	public void polymorphysm() {
//		Animal dog = new GoldenRetriver();
//		dog.makeSound();
//		dog.whichAnimal();
		
		BaseFeatureClass featureClass = new FeatureClass81();
		featureClass.whichTest("A");
		System.out.println(Integer.toString(featureClass.i));
		System.out.println(Integer.toString(featureClass.j));
		
		
	}
}
