package exercise.randompuzzle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RandomPuzzle {
    public static int minStepsToSolveWithPath(int[][] board, List<Board> path) {
        Board originalBoard = new Board(board);
        Board targetBoard = originalBoard.getTargetBoard();

        Queue<Board> boardStepsQueue = new LinkedList<>();
        boardStepsQueue.offer(new Board(board));
        while (!boardStepsQueue.isEmpty()) {
            Board boardStep = boardStepsQueue.poll();
            Piece pointOfZeroPiece = boardStep.findZero();
            List<Piece> neighborsOfZeroPiece = boardStep.findNeighbors(pointOfZeroPiece);
            if (neighborsOfZeroPiece.size() > 0) {
                for (Piece neighborOfZero : neighborsOfZeroPiece) {
                    Board newBoard = boardStep.getNewBoardBySwappingPiece(pointOfZeroPiece, neighborOfZero);
                    boardStepsQueue.offer(newBoard);
                    if (newBoard.equals(targetBoard)) {
                        int numOfSteps = 0;
                        Board pathNode = newBoard;
                        while (pathNode != null) {
                            path.add(0, pathNode);
                            pathNode = pathNode.parent;
                            numOfSteps++;
                        }

                        return numOfSteps;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int board[][] = new int[][]{
                {0, 1, 3},
                {4, 2, 5},
                {7, 8, 6}
        };

//        int target[][] = new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 0}
//        };
        List<Board> path = new LinkedList<>();
        int minSteps = minStepsToSolveWithPath(board, path);

        System.out.println("Min path:");

        for (Board node : path) {
            node.print();
        }

        System.out.println("Min steps: " + minSteps);

    }
}
