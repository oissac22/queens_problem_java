import entities.Infos;
import entities.Queen;
import entities.Tab;

public class App {
    private static Tab tab;
    private static final int size = Infos.SIZE;

    public static void main(String[] args) throws Exception {
        tab = new Tab();

        Queen[] listQueens = new Queen[size];

        for (int x = 0; x < size; x++)
            listQueens[x] = new Queen(x, 0);

        positionSecurityQueens(listQueens, 0);

        System.out.println(tab);
    }

    private static boolean positionSecurityQueens(Queen[] queens, int index) {
        Queen q = queens[index];
        for (int y = 0; y < size; y++) {
            q.move(q.getX(), y);
            Queen q_danger = tab.dangetPositionArea(index, y);
            if (q_danger == q || q_danger == null) {
                tab.addQueen(q);
                if (index == size - 1)
                    return true;
                boolean nextResult = positionSecurityQueens(queens, index + 1);
                if (nextResult)
                    return true;
                tab.removeQueen(q);
            }
        }
        return false;
    }
}
