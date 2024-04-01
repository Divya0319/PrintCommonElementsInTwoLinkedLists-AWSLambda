package com.fastturtle.PrintCommonElementsInLinkedLists;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LinkedListDeserializer {
	
	private static final Gson gson;
	
	static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LinkedList.class, new CustomLinkedListDeserializer());
        gson = gsonBuilder.create();
    }

	
	// Factory method for deserialization
    public static RequestClass fromJson(String json) {
        return gson.fromJson(json, RequestClass.class);
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
