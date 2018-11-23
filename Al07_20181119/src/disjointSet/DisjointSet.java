package disjointSet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DisjointSet {

	// 노드를 입력 받아 그 자체를 하나의 집합으로 만드는 과정
	public void make_set(Node x) {
		x.setParent(x);
	}

	public void treeMakeUnion(Node a, Node b) {
		if (a.getValue() == b.getValue()) {
			b.setParent(a);
		}
	}

	public void union(Node a, Node b) {
		a = find(a);
		b = find(b);
		if (a.getValue() == b.getValue()) {
			return;
		} else {
			b.setParent(a);
		}
	}

	// 노드x가 속한 집합을 알아내는 함수(루트노드 반환)
	public Node find(Node x) {
		if (x.getParent().equals(x)) { // 루트 노드라면 반환
			return x;
		}
		return find(x.getParent()); // 아니면 부모 노드를 찾아 올라간다.
	}

	public static void main(String[] args) throws IOException {
		List<Node> nodeList = new ArrayList<Node>();
		DisjointSet ds = new DisjointSet();
		Node newNode;
		List<Node> valueList = new ArrayList<Node>();
		List<Node> value1 = new ArrayList<Node>();
		List<Node> value2 = new ArrayList<Node>();
		List<Node> value3 = new ArrayList<Node>();
		List<Node> value4 = new ArrayList<Node>();
		List<Node> value5 = new ArrayList<Node>();
		File file = new File("C:/Users/Administrator/Desktop/output1.txt");
		File file2 = new File("C:/Users/Administrator/Desktop/ourput2.txt");
		BufferedWriter bw = null;
		PrintWriter pw = null;
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/Administrator/Desktop/Data_updated.txt"));
		int i = 0;
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			} else {
				String[] list = line.split("\t");

				newNode = new Node(list[0], Integer.parseInt(list[1]));
				ds.make_set(newNode);
				nodeList.add(newNode);
			}
			if (i > 0) {
				nodeList.get(i - 1).setNext(nodeList.get(i));
				// System.out.println(nodeList.get(i-1).getValue()+"->"+nodeList.get(i-1).getNext().getValue);
			}
			i++;
		}

		// value별로 분류
		for (int j = 0; j < nodeList.size(); j++) {
			if (nodeList.get(j).getValue() == 1) {
				value1.add(nodeList.get(j));
			}
		}
		for (int j = 0; j < nodeList.size(); j++) {
			if (nodeList.get(j).getValue() == 2) {
				value2.add(nodeList.get(j));
			}
		}
		for (int j = 0; j < nodeList.size(); j++) {
			if (nodeList.get(j).getValue() == 3) {
				value3.add(nodeList.get(j));
			}
		}
		for (int j = 0; j < nodeList.size(); j++) {
			if (nodeList.get(j).getValue() == 4) {
				value4.add(nodeList.get(j));
			}
		}
		for (int j = 0; j < nodeList.size(); j++) {
			if (nodeList.get(j).getValue() == 5) {
				value5.add(nodeList.get(j));
			}
		}

		// 각각의 트리 만들기
		for (int k = 1; k < value1.size(); k++) {
			ds.treeMakeUnion(value1.get(k - 1), value1.get(k));
		}
		for (int k = 1; k < value2.size(); k++) {
			ds.treeMakeUnion(value2.get(k - 1), value2.get(k));
		}
		for (int k = 1; k < value3.size(); k++) {
			ds.treeMakeUnion(value3.get(k - 1), value3.get(k));
		}
		for (int k = 1; k < value4.size(); k++) {
			ds.treeMakeUnion(value4.get(k - 1), value4.get(k));
		}
		for (int k = 1; k < value5.size(); k++) {
			ds.treeMakeUnion(value5.get(k - 1), value5.get(k));
		}
		br.close();

		// output1 만들기
		if (file.exists()) {
			file.delete();
		}
		bw = new BufferedWriter(new FileWriter(file, true));
		pw = new PrintWriter(bw, true);
		if (file.isFile() && file.canWrite()) {

			pw.println("1:");
			for (int j = 0; j < nodeList.size(); j++) {
				if (nodeList.get(j).getValue() == 1) {
					pw.println(nodeList.get(j).getId() + " -> " + nodeList.get(j).parent.id);
				}
			}
			pw.println();
			pw.println("2:");
			for (int j = 0; j < nodeList.size(); j++) {
				if (nodeList.get(j).getValue() == 2) {
					pw.println(nodeList.get(j).getId() + " -> " + nodeList.get(j).parent.id);
				}
			}
			pw.println();
			pw.println("3:");
			for (int j = 0; j < nodeList.size(); j++) {
				if (nodeList.get(j).getValue() == 3) {
					pw.println(nodeList.get(j).getId() + " -> " + nodeList.get(j).parent.id);
				}
			}
			pw.println();
			pw.println("4:");
			for (int j = 0; j < nodeList.size(); j++) {
				if (nodeList.get(j).getValue() == 4) {
					pw.println(nodeList.get(j).getId() + " -> " + nodeList.get(j).parent.id);
				}
			}
			pw.println();
			pw.println("5:");
			for (int j = 0; j < nodeList.size(); j++) {
				if (nodeList.get(j).getValue() == 5) {
					pw.println(nodeList.get(j).getId() + " -> " + nodeList.get(j).parent.id);
				}
			}
		}
		bw.close();
		pw.close();

		//valuList에 번호순서대로 원소를 담기위함
		for (int q = 0; q < value1.size(); q++) {
			valueList.add(value1.get(q));
		}
		for (int q = 0; q < value2.size(); q++) {
			valueList.add(value2.get(q));
		}
		for (int q = 0; q < value3.size(); q++) {
			valueList.add(value3.get(q));
		}
		for (int q = 0; q < value4.size(); q++) {
			valueList.add(value4.get(q));
		}
		for (int q = 0; q < value5.size(); q++) {
			valueList.add(value5.get(q));
		}

		// 트리들 합치기
		for (int b = 1; b < valueList.size(); b++) {
			ds.union(valueList.get(b - 1), valueList.get(b));
		}
		
		
		// output2 만들기
		if (file2.exists()) {
			file2.delete();
		}
		bw = new BufferedWriter(new FileWriter(file2, true));
		pw = new PrintWriter(bw, true);
		if (file2.isFile() && file2.canWrite()) {
			
			for (int j = 0; j < nodeList.size(); j++) {
				pw.println(
						valueList.get(j).getId() + "->" + valueList.get(j).getParent().getId());
			}

		}
		bw.close();
		pw.close();
	}

}
