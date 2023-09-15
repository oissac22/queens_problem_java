package entities;

import java.util.HashSet;
import java.util.Set;

public class Tab {
    private final int size = Infos.SIZE;

    private Set<Queen> listQueens = new HashSet<>();
    private Queen table[][] = new Queen[size][size];

    public Tab() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                table[y][x] = null;
            }
        }
    }

    public Queen dangetPositionArea(int x, int y) {
        for (Queen q:listQueens) {
            if (q.positionIsDanger(x, y))
                return q;
        }
        return null;
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Queen q = table[y][x];
                if (q != null)
                    s.append(" " + table[y][x] + " ");
                else
                    s.append(" _ ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void addQueen(Queen q) {
        removeQueen(q);
        table[q.getY()][q.getX()] = q;
        listQueens.add(q);
    }

    public void removeQueen(Queen q) {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (table[y][x] == q) {
                    table[y][x] = null;
                }
            }
        }
        listQueens.remove(q);
    }
}
