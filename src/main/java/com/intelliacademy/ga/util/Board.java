package com.intelliacademy.ga.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Stream;

public class Board {
    private final Stack<Cell> stack = new Stack<>();
    private final Integer rows;
    private final Integer columns;
    private final Cell[][] board;

    public Board(Integer rows, Integer columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new Cell[rows][columns];
        this.initializeBoard();
    }

    public Cell getCell(Integer row, Integer column) {
        if (row < 0 || row >= this.rows || column < 0 || column >= this.columns) {
            return null;
        }
        return this.board[row][column];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.rows; i++) {
            sb.append(Arrays.toString(this.board[i]))
                    .append("\n")
                    .append("\n");

        }
        return sb.toString();
    }

    private void initializeBoard() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.board[i][j] = new Cell(this,i, j, "O");
            }
        }
    }


    public Cell run(Point startPoint,Point targetPoint) {
        Cell current = this.getCell(startPoint.row(), startPoint.column());
        current.visit();
        this.stack.push(current);

        while (!this.stack.isEmpty()) {
            Cell top = this.stack.peek();
            List<Cell> neighbors = top.getAvailableUnvisitedNeighbors();
            if (neighbors.isEmpty()) {
                this.stack.pop();
            } else {
                Cell next = neighbors.get(0);
                next.visit();
                this.stack.push(next);
            }
        }
        return current;
    }

}


class Cell {
    private Board board;
    private final Integer row;
    private final Integer column;
    private String value;
    private Boolean visited = false;
    private Boolean available = true;

    public Cell(Board board,Integer row, Integer column, String value) {
        this.board = board;
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public Cell down() {
        return this.board.getCell(this.row + 1, this.column);
    }

    public Cell up() {
        return this.board.getCell(this.row - 1, this.column);
    }

    public Cell left() {
        return this.board.getCell(this.row, this.column - 1);
    }

    public Cell right() {
        return this.board.getCell(this.row, this.column + 1);
    }

    public List<Cell> getAvailableUnvisitedNeighbors() {
        return Stream.of(this.up(), this.down(), this.left(), this.right())
                .filter(Objects::nonNull)
                .toList();
    }

    public Boolean isArrived(Point targetPoint) {
        return this.row.equals(targetPoint.row()) && this.column.equals(targetPoint.column());
    }

    public void destination() {
        this.value = "D";
    }

    public void wall() {
        this.available = false;
        this.value = "W";
    }

    public void unAvailable() {
        this.available = false;
        this.value = "X";
        this.visited = true;
    }

    public Boolean isAvailable() {
        return this.available;
    }

    public void visit() {
        this.visited = true;
    }

    @Override
    public String toString() {
        return "[" + this.value + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(row, cell.row) && Objects.equals(column, cell.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}


record Point(Integer row, Integer column) { }