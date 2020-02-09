package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class LSEO<T extends Comparable<T>> implements IListaOrdenada<T> {
	private Node head;
	private int size;
	private boolean ascending;

	public LSEO(boolean ascending) {
		head = null;
		size = 0;
		this.ascending = ascending;
	}

	public LSEO() {
		this(true);
	}

	class Node {
		T value;
		Node next;

		Node(T value) {
			this.value = value;
			this.next = null;
		}
	}

	@Override
	public void insert(T value) {
		Node newNode = new Node(value);
		Node current = head;
		Node previous = null;
		if (this.ascending == true) {
			while (current != null && value.compareTo(current.value) > 0) {
				previous = current;
				current = current.next;
			}
		} else {
			while (current != null && value.compareTo(current.value) < 0) {
				previous = current;
				current = current.next;
			}
		}
		if (previous == null) {
			head = newNode;
		} else {
			previous.next = newNode;
		}
		newNode.next = current;
		this.size++;
	}

	@Override
	public Node remove(T e) {
		if (head == null) {
			throw new RuntimeException("List is empty..");
		}

		Node previousNode = null;
		Node currentNode = this.head;
		for (int i = 0; i < this.size; i++) {
			if (currentNode.value.compareTo(e) == 0) {
				previousNode.next = currentNode.next;
				this.size--;
				return currentNode;
			} else {
				previousNode = currentNode;
				currentNode = currentNode.next;
			}
		}
		throw new RuntimeException(e + " is not in the list");
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();

		buffer.append("[");

		if (head != null) {
			Node aux = head;
			while (aux.next != null) {
				buffer.append(aux.value);
				buffer.append(", ");
				aux = aux.next;
			}

			buffer.append(aux.value);
		}

		buffer.append("]");

		return buffer.toString();
	}

	@Override
	public int length() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}


	public void reader(String path) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(path));

		while (true) {
			String line = reader.readLine();
			if (line == null) {
				break;
			}
			// Split em cada ponto final encontrado e organiza o espaçamento. (StringTokenizer pelo que vi é ultrapassado)
			String[] parts = line.split("\\s*\\.\\s*");
			for (String part : parts) {
				System.out.println(part);
			}
			System.out.println();
		}

		reader.close();
	}


	public String findLongestWords() throws Exception {

		String longest_word = "";
		String current;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new File("C:\\Users\\Lucas\\Downloads\\texto.txt"));


		while (sc.hasNext()) {
			current = sc.next();
			if (current.length() > longest_word.length()) {
				longest_word = current;
			}

		}
		System.out.println("\nA maior palavra que aparece no texto é: "+longest_word+"\n");
		return longest_word;
	}
}