package Basics;

public class Calculator {

	public Calculator(int a) {
		System.out.println("public constructor is called");
	}

	public void add() {
		System.out.println("add() called");

	}

	public void sub() {
		System.out.println("sub() called");

	}

	public void mult() {

		System.out.println("mult() called");
	}

	public void div() {

		System.out.println("div() called");

	}

	public static void main(String[] args) {
	/*	new Calculator().add();
		new Calculator().sub();
		new Calculator().mult();
		new Calculator().div(); */
		
	//	new Calculator().add();
		
//	Calculator calc=new Calculator();
//		calc.add();
//		calc.sub();
//		calc.mult();
//		calc.div();
		Calculator calc=new Calculator(100);
		

	}
}
