public class Triangle {
	
	public static void main(String[] args) {
		int col = 0;
		int size = 5;
		while (col < size) {
			int row = 0;
			while (row <= col) {
				System.out.print('*');
				row += 1;
			}
			System.out.println();
			col += 1;
		}
	}
}