package tester.SubTester;

public class ClassB extends ClassA{

	int ab;
	String hb;
	
	public ClassB(int a, String h) {
		super(a, h);
		this.hb = "Test";
		this.ab = 139;
	}
	
	@Override
	public String fix() {
		return ab+hb;
	}

}
