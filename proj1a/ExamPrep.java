public class ExamPrep {

    public static int[] flatten(int[][] x) {
        int totalLen = 0;
        for (int i = 0; i < x.length; i++) {
            totalLen += x[i].length;
        }

        int[] res = new int[totalLen];
        int adjIndex = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                res[adjIndex] = x[i][j];
                adjIndex += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 2, 3}, {}, {7, 8}};
        int[] res = flatten(x);
        System.out.println(res.length);
    }
}
