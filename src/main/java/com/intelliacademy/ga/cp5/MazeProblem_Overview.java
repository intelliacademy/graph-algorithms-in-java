package com.intelliacademy.ga.cp5;

import com.intelliacademy.ga.util.Board;

public class MazeProblem_Overview {
    public static void main(String[] args) {
        var board = new Board(10, 10);
        board.run(new Board.Point(0,0), new Board.Point(9,9));
        System.out.println(board);
    }
}
