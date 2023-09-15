package entities;

public class Queen {
    private final int size = Infos.SIZE;
    private int x = 0;
    private int y = 0;
    private boolean[][] dangerArea;

    public Queen(int x, int y) {
        this.x = x;
        this.y = y;
        dangerArea = new boolean[size][size];
        setDangerArea();
    }

    public String toString() {
        return "R";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        setDangerArea();
    }

    private void setDangerArea() {
        dangerArea = new boolean[size][size];
        for (int y = 0; y < size; y++)
            for (int x = 0; x < size; x++)
                dangerArea[y][x] = false;
        for (int x = this.x - 1; x >= 0; x--)
            dangerArea[this.y][x] = true;
        for (int x = this.x + 1; x < size; x++)
            dangerArea[this.y][x] = true;
        for (int y = this.y - 1; y >= 0; y--)
            dangerArea[y][this.x] = true;
        for (int y = this.y + 1; y < size; y++)
            dangerArea[y][this.x] = true;
        for (int x = this.x - 1, y = this.y - 1; x >= 0 && y >= 0; x--, y--)
            dangerArea[y][x] = true;
        for (int x = this.x - 1, y = this.y + 1; x >= 0 && y < size; x--, y++)
            dangerArea[y][x] = true;
        for (int x = this.x + 1, y = this.y - 1; x < size && y >= 0; x++, y--)
            dangerArea[y][x] = true;
        for (int x = this.x + 1, y = this.y + 1; x < size && y < size; x++, y++)
            dangerArea[y][x] = true;
    }

    public boolean positionIsDanger(int x, int y) {
        return dangerArea[y][x];
    }
}
