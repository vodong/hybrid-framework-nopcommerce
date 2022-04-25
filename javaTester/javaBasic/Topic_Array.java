package javaBasic;

import java.util.Iterator;

public class Topic_Array {
	// Thuộc tính / Biến
	String name;
	int age;
	
	// Constrcutor: Hàm khởi tạo
	public Topic_Array(String name, int age) {
		this.name =  name;
		this.age = age;
	}
	
	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Age:" + age);
	}
	
	public static void main(String[] args) {
		Topic_Array[] students = new Topic_Array[3];
		
		students[0] = new Topic_Array("Cường", 25);
		students[1] = new Topic_Array("An", 35);
		students[2] = new Topic_Array("Tien", 45);
		for (int i = 0; i < 3; i++) {
			students[i].display();
			
		}
	}

}
