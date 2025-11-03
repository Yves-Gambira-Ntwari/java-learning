package oop_java;

public class Abstruct {

	public static void main(String[] args) {
		abstract class Super{
			abstract void bye();
		}
		class Subcl extends Super{
			public void bye() {
				System.out.println("Goodbye");
			}
		}
		class Subtwo extends Super{
			public void bye() {
				System.out.print("Goodbye sub two");
			}
		}
		Subcl sub1 = new Subcl();
		Subtwo sub2 = new Subtwo();
		sub1.bye();
		sub2.bye();
	}

}
