package com.fastturtle.PrintCommonElementsInLinkedLists;


public interface LinkedListService {
	
	void insert(Integer node);
		
	void insert(Integer node, int position);
	
	ListNode deleteAtBegin();
	
	ListNode deleteAtEnd();
	
	ListNode delete(int position);
	
	int getLength();
	
	boolean isEmpty();

}
