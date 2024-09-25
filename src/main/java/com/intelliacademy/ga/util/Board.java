package com.intelliacademy.ga.util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {


    public record Point(Integer row, Integer column) { }

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

    public Cell cell(Point point) {
        return this.cell(point.row(), point.column());
    }

    public Cell cell(Integer row, Integer column) {
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
                this.board[i][j] = new Cell(this,i, j, "#");
            }
        }
    }


    public void run(Point startPoint,Point targetPoint) {
        var startCell = this.cell(startPoint);

        startCell.visit();
        this.stack.push(startCell);

        while (!this.stack.isEmpty()) {
            var neighbor = this.stack.peek().getAvailableUnvisitedNeighbors();
            if (neighbor.isEmpty()) {
                var cell = this.stack.pop();
                cell.unAvailable();
            } else {
                var nextCell = neighbor.poll();
                assert nextCell != null;
                if (nextCell.isArrived(targetPoint)) {
                    nextCell.destination();
                    break;
                }
                nextCell.visit();
                this.stack.push(nextCell);
                neighbor.forEach(Cell::viewed);
            }
        }


    }

}


class Cell implements Comparable<Cell> {
    private Board board;
    private final Board.Point point;
    private String value;
    private Boolean visited = false;
    private Boolean available = true;
    private Boolean viewed = false;
    private Integer priority = 10;

    public Cell(Board board,Integer row, Integer column, String value) {
        this.board = board;
        this.point = new Board.Point(row, column);
        this.value = value;
    }

    public Board.Point getPoint() {
        return point;
    }

    public Cell down() {
        return this.board.cell(this.point.row() + 1, this.point.column() );
    }

    public Cell up() {
        return this.board.cell(this.point.row()  - 1, this.point.column());
    }

    public Cell left() {
        return this.board.cell(this.point.row() , this.point.column() - 1);
    }

    public Cell right() {
        return this.board.cell(this.point.row() , this.point.column() + 1);
    }

    public Cell viewed() {
        this.viewed = true;
        this.priority = 5;
        return this;
    }

    public Queue<Cell> getAvailableUnvisitedNeighbors() {
        return Stream.of(this.up(), this.down(), this.left(), this.right())
                .filter(Objects::nonNull)
                .filter(Cell::isAvailable)
                .filter(cell -> !cell.visited)
                .collect(Collectors.toCollection(PriorityQueue::new));
    }

    public Boolean isArrived(Board.Point targetPoint) {
        return this.point.row().equals(targetPoint.row()) && this.point.column().equals(targetPoint.column());
    }

    public void destination() {
        this.value = "D";
    }

    public void wall() {
        this.available = false;
        this.priority = 0;
        this.value = "W";
    }

    public void unAvailable() {
        this.available = false;
        this.value = "X";
        this.priority = 0;
        this.visited = true;
    }

    public Boolean isAvailable() {
        return this.available;
    }

    public Cell visit() {
        this.visited = true;
        this.value = "V";
        this.priority = 1;
        //System.out.println("Visiting cell: " + this + " point: " + this.point);
        return this;
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
        return Objects.equals(point.row(), cell.point.row()) && Objects.equals(point.column(), cell.point.column());
    }

    @Override
    public int hashCode() {
        return Objects.hash(point.row(), point.column());
    }

    @Override
    public int compareTo(Cell o) {
        return o.priority.compareTo(this.priority);
    }
}
