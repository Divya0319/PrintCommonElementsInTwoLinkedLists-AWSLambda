package com.fastturtle.PrintCommonElementsInLinkedLists;

import java.util.ArrayList;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class PrintCommonElementsBetweenTwoSortedLinkedLists implements RequestHandler<String, String> {
	
	public ListNode printCommonElements(ListNode l1, ListNode l2) {
		
		// Given lists are sorted
		// we maintain a dummy node, and
		// return common linked list as its next
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while(l1 != null && l2 != null) {
			if(l1.getData() == l2.getData()) {
				
				// common element found, so add it to resulting linked list
				head.setNext(new ListNode(l1.getData()));
				
				// advance both lists pointers
				l1 = l1.getNext();
				l2 = l2.getNext();
				head = head.getNext();
				
				// if l2 list has smaller element than l1
				// we advance pointer of l2 only,  bcz lists are sorted
			} else if(l1.getData() > l2.getData()) {
				l2 = l2.getNext();
			} else {
				
				// else, we advance pointer l2, as l2 has smaller element
				l1 = l1.getNext();
			}
		}
		
		
		// returning actual generated common linked list
		return dummy.getNext();
	}
	
	@Override
	public String handleRequest(String input, Context context) {
		
		return "";
		
	}

}
