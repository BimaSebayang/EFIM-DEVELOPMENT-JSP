package tester.SubTester;

public class ClassC extends ClassA{

	int ac;
	String hc;
	
	public ClassC(int a, String h) {
		super(a, h);
		this.ac = 10;
		this.hc = "deh";
	}
	
	@Override
	public String fix() {
		return ac+hc;
	}

}
