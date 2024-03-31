package com.fastturtle.PrintCommonElementsInLinkedLists;

public class ListNode {
    private Integer data;
    private ListNode next;
    public ListNode(Integer data) {
        this.data = data;
    }
    
    public void setData(Integer data) {
        this.data = data;
    }
    
    public Integer getData() {
        return data;
    }
    
    public void setNext(ListNode next) {
        this.next = next;
    }
    
    public ListNode getNext() {
        return next;
    }
}
