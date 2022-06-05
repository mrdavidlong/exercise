package exercise.randompuzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {
    public static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public Board parent;
    public int[][] pieces;

    public Board(int[][] anotherPieces) {
        pieces = new int[anotherPieces.length][anotherPieces[0].length];
        for (int i = 0; i < anotherPieces.length; i++) {
            for (int j = 0; j < anotherPieces[0 ].length; j++) {
                pieces[i][j] = anotherPieces[i][j];
            }
        }
    }

    public Board(Board board) {
        pieces = new int[board.pieces.length][board.pieces[0].length];
        for (int i = 0; i < board.pieces.length; i++) {
            for (int j = 0; j < board.pieces[0].length; j++) {
                pieces[i][j] = board.pieces[i][j];
            }
        }
    }

    public Piece findZero() {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[0].length; j++) {
                if (pieces[i][j] == 0) {
                    return new Piece(i, j);
                }
            }
        }
        return null;
    }

    public Board getNewBoardBySwappingPiece(Piece point1, Piece point2) {
        Board newBoard = new Board(this);
        newBoard.parent = this;
        int num1 = newBoard.pieces[point1.r][point1.c];
        int num2 = newBoard.pieces[point2.r][point2.c];
        newBoard.pieces[point2.r][point2.c] = num1;
        newBoard.pieces[point1.r][point1.c] = num2;
        return newBoard;
    }

    public List<Piece> findNeighbors(Piece point) {
        List<Piece> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int nextR = point.r + dir[0];
            int nextC = point.c + dir[1];
            if (nextR >= 0 && nextR < pieces.length && nextC >= 0 && nextC < pieces[0].length) {
                neighbors.add(new Piece(nextR, nextC));
            }
        }
        return neighbors;
    }

    public Board getTargetBoard() {
        int[][] targetBoard = new int[pieces.length][pieces[0].length];
        int num = 1;
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[0].length; j++) {
                if (i == pieces.length - 1 && j == pieces[0].length - 1) {
                    targetBoard[i][j] = 0;
                } else {
                    targetBoard[i][j] = num;
                    num++;
                }
            }
        }
        return new Board(targetBoard);
    }

    public void print() {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[0].length; j++) {
                System.out.print(pieces[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public int hashCode() {
        int[] oneDimArray = new int[pieces.length * pieces[0].length];
        int index = 0;
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[0].length; j++) {
                oneDimArray[index] = pieces[i][j];
            }
        }
        return Objects.hash(oneDimArray);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Board)) return false;

        if (obj == this) return true;
        Board anotherBoard = (Board)obj;
        if (anotherBoard.pieces.length != pieces.length ||
                anotherBoard.pieces[0].length != pieces[0].length) {
            return false;
        }

        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[0].length; j++) {
                if (pieces[i][j] != anotherBoard.pieces[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
