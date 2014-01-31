import java.util.Random;

public class Test {
	
	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			Random ranDirection = new Random();
			int direction =  ranDirection.nextInt(2);

		//HORIZONTAL
			if (direction == 0) {
				System.out.println("horizontal");
				int x1 = ranDirection.nextInt(5);
				int x2 = x1 + 1;
				int x3 = x1 + 2;
				int x4 = x1 + 3;

				int y1 = ranDirection.nextInt(8);

				System.out.println(x1 + " " + x2 + " " + x3 + " " + x4);
				System.out.println(y1);
			} else { //
				System.out.println("vertical");
				int x1 = ranDirection.nextInt(8);

				int y1 = ranDirection.nextInt(5);
				int y2 = y1 + 1;
				int y3 = y1 + 2;
				int y4 = y1 + 3;

				System.out.println(x1);
				System.out.println(y1 + " " + y2 + " " + y3 + " " + y4);
			}
			System.out.println(" CLEAR ");
		}	
	}
}

