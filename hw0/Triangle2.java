public class Triangle2 {
	
	public static void drawTriangle(int N) {
		int col = 0;
		while (col < N) {
			int row = 0;
			while (row <= col) {
				System.out.print('*');
				row += 1;
			}
			System.out.println();
			col += 1;
		}
	}
	public static void main(String[] args) {
		drawTriangle(10);
	}
}