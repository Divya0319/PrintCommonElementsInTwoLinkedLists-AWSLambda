package com.fastturtle.PrintCommonElementsInLinkedLists;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LinkedListDeserializer {
	
	public static class RequestClass {
		private LinkedList<Integer> linkedList1;
        private LinkedList<Integer> linkedList2;

        // Getters and setters...
        public LinkedList<Integer> getLinkedList1() {
            return linkedList1;
        }

        public void setLinkedList1(LinkedList<Integer> linkedList1) {
            this.linkedList1 = linkedList1;
        }

        public LinkedList<Integer> getLinkedList2() {
            return linkedList2;
        }

        public void setLinkedList2(LinkedList<Integer> linkedList2) {
            this.linkedList2 = linkedList2;
        }
	}
	
	// Factory method for deserialization
    public static RequestClass fromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);

        // Deserialize linkedList1
        JsonNode linkedList1Node = rootNode.get("linkedList1");
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        for (JsonNode valueNode : linkedList1Node) {
            linkedList1.insert(valueNode.asInt());
        }

        // Deserialize linkedList2
        JsonNode linkedList2Node = rootNode.get("linkedList2");
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        for (JsonNode valueNode : linkedList2Node) {
            linkedList2.insert(valueNode.asInt());
        }

        // Construct RequestClass instance
        RequestClass request = new RequestClass();
        request.setLinkedList1(linkedList1);
        request.setLinkedList2(linkedList2);
        return request;
    }
    
    public static void main(String[] args) throws IOException {
        // Example JSON input
        String json = "{\"linkedList1\": [1, 3, 8], \"linkedList2\": [3, 6, 8, 12]}";

        // Deserialize JSON input using factory method
        RequestClass request = fromJson(json);

        // Print deserialized object
        System.out.println("LinkedList1: " + request.getLinkedList1());
        System.out.println("LinkedList2: " + request.getLinkedList2());
    }

}
