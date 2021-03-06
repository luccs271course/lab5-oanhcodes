package edu.luc.cs271.linkedstack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements IStack<E> {

  /** The topmost node of this stack. The stack gets pushed down from here. */
  private Node<E> top;

  private List<E> dataList;

  @Override
  public E push(final E obj) {
    top = new Node<>(obj, top);
    return obj;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    } else {
      return top.data;
    }
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    } else {
      E result = top.data;
      top = top.next;
      return result;
    }
  }

  @Override
  public boolean isEmpty() {
    return top == null;
  }

  @Override
  public List<E> asList() {
    dataList = new ArrayList<>();
    while (top != null) {
      dataList.add(top.data);
      top = top.next;
    }
    return dataList;
  }
}
