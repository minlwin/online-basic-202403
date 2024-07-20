package com.jdc.lambda.demo;

public class MethodReferenceDemo {

	public static void main(String[] args) {
		
		Runnable r1 = () -> System.out.println("Lambda");
		r1.run();
		
		Runnable r2 = MethodReferenceDemo::sayHello;
		r2.run();
		
		var demo = new Demo();
		
		Runnable r3 = demo::demoMethod;
		r3.run();
		
		Runnable r4 = Demo::new;
		r4.run();
	}
	
	static void sayHello() {
		System.out.println("Hello Lambda");
	}
	
	static class Demo {
		
		public Demo() {
			System.out.println("Hello from constructor.");
		}
		
		public void demoMethod() {
			System.out.println("Hello instance method");
		}
	}
}
