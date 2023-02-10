// Реализовать алгоритм волновой

package Task1;

import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    static int[][] getMap() {
        return new int[][]{
                {00, 00, 00, 00, 00, 00, 00, 00},
                {00, 00, -1, 00, 00, 00, 00, 00},
                {00, 00, -1, 00, -1, 00, -1, 00},
                {00, 00, -1, 00, 00, 00, -1, 00},
                {00, 00, -1, 00, 00, 00, -1, 00},
                {00, -1, -1, -1, -1, -1, -1, 00},
                {00, 00, -1, 00, 00, 00, -1, 00},
                {00, 00, -1, 00, 00, 00, -1, 00},
                {00, 00, 00, 00, 00, 00, -1, 00},
                {00, 00, 00, 00, 00, 00, -1, 00},
                {00, 00, 00, 00, 00, 00, 00, 00}
        };
    }

    static void pprint(int[][] m) {
        int rows = m.length;
        int colums = m[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (m[i][j] == -1)
                    System.out.printf("%s", " @ ");
                else if (m[i][j] == 1)
                    System.out.printf("%s", " # ");
                else if (m[i][j] == -3)
                    System.out.printf("%s", " % ");
                else if (m[i][j] == -5)
                    System.out.printf("%s", " $ ");
                else
                    System.out.printf("%s", "░░░");
            }
            System.out.println();
        }
    }

    static void start(int[][] map, LinkedList queue, int x, int y) {
        map[x][y] = 1;
        queue.add(x * 1000 + y);
    }

    static void end(int[][] map, int x, int y) {
        map[x][y] = -3;
    }

    static void step(int[][] map, LinkedList queue, int x, int y) {
        if (0 <= x && x <= 10 && 0 <= y && y <= 7) {
            if (x > 0 && (map[x - 1][y] == 0 || map[x - 1][y] == -3)) {
                map[x - 1][y] = map[x][y] + 1;
                queue.add((x - 1) * 1000 + y);
            }
            if (y < 7 && (map[x][y + 1] == 0 || map[x][y + 1] == -3)) {
                map[x][y + 1] = map[x][y] + 1;
                queue.add(x * 1000 + (y + 1));
            }
            if (x < 10 && (map[x + 1][y] == 0 || map[x + 1][y] == -3)) {
                map[x + 1][y] = map[x][y] + 1;
                queue.add((x + 1) * 1000 + y);
            }
            if (y > 0 && (map[x][y - 1] == 0 || map[x][y - 1] == -3)) {
                map[x][y - 1] = map[x][y] + 1;
                queue.add(x * 1000 + y - 1);
            }
        }
    }

    static void backStep(int[][] map, LinkedList queue, int x, int y, int present_step) {
        if (x > 0 && map[x - 1][y] == present_step - 1) {
            map[x - 1][y] = -5;
            queue.add((x - 1) * 1000 + y);
        } else if (y < 7 && map[x][y + 1] == present_step - 1) {
            map[x][y + 1] = -5;
            queue.add(x * 1000 + (y + 1));
        } else if (x < 10 && map[x + 1][y] == present_step - 1) {
            map[x + 1][y] = -5;
            queue.add((x + 1) * 1000 + y);
        } else if (y > 0 && map[x][y - 1] == present_step - 1) {
            map[x][y - 1] = -5;
            queue.add(x * 1000 + y - 1);
        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[][] map = getMap();
        pprint(map);
        Scanner in = new Scanner(System.in);
        System.out.print("Input start row: ");
        int startRow = in.nextInt();
        System.out.print("Input start column: ");
        int startColumn = in.nextInt();
        System.out.print("Input end row: ");
        int endRow = in.nextInt();
        System.out.print("Input end column: ");
        int endColumn = in.nextInt();
        end(map, endRow, endColumn);
        start(map, queue, startRow, startColumn);

        while (queue.size() > 0) {
            step(map, queue, queue.get(0) / 1000, queue.get(0) % 1000);
            queue.remove(0);
        }
        int presentStep = map[endRow][endColumn];
        System.out.println("Shortest way in " + presentStep + " steps: ");
        queue.add(endRow * 1000 + endColumn);

        while (queue.size() > 0) {
            backStep(map, queue, queue.get(0) / 1000, queue.get(0) % 1000, presentStep);
            presentStep -= 1;
            queue.remove(0);
        }
        end(map, endRow, endColumn);
        start(map, queue, startRow, startColumn);
        pprint(map);
    }
}