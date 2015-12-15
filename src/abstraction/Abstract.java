package abstraction;

import org.testng.annotations.Test;

public class Abstract {
	@Test
	public void LearnAbstract() {
		Dog d = new Dog();
		d.dotheyEgg();
		Cat  c = new Cat();
		c.dotheyEgg();
	}
}
