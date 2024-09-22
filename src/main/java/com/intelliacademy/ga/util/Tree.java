package com.intelliacademy.ga.util;

public interface Tree<D extends Comparable<D>> {
    void insert(D data);
    void traverseInOrder();
}
