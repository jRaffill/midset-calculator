import java.util.ArrayList;

public class DotbookRunner {

	public static void main(String[] args) {
		System.out.println("Virtual dotbook! So you don't have to do math yourself :)");
		System.out.println("Input your dots in the format: [S1/S2] [no. steps] [in/out] [yardline], [steps] [front/back] [hash]");
		System.out.println("Type 'done' to exit.");
		ArrayList<Dot> dots = new ArrayList<Dot>();
		String input;
		String lastInput;
		input = TextIO.getlnString();
		
		while (!input.equals("done")) {
			lastInput = input;
			input = TextIO.getlnString();
			if (!input.equals("done")) {
				dots.add(new Dot(lastInput, input));
			}
		}
				
		for (Dot dot:dots) {
			System.out.println(dot);
		}
	}

}
