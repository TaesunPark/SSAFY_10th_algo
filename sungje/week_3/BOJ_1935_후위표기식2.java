package sungje.week_3;

import java.io.*;
import java.util.*;

public class BOJ_1935_후위표기식2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int alphabets = Integer.parseInt(br.readLine());

		double[] alphabetValues = new double[alphabets];
		char[] inputOperators = br.readLine().toCharArray();
		Stack<Double> stack = new Stack<Double>();

		for (int i = 0; i < alphabets; i++) {
			alphabetValues[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < inputOperators.length; i++) {
			if ('A' <= inputOperators[i] && inputOperators[i] <= 'Z') {
				stack.push(alphabetValues[inputOperators[i] - 65]);
				continue;
			}
			double backwardOperator = stack.pop();
			double forwardOperator = stack.pop();
			if (inputOperators[i] == '*') {
				stack.push(forwardOperator * backwardOperator);
			}
			if (inputOperators[i] == '/') {
				stack.push(forwardOperator / backwardOperator);
			}
			if (inputOperators[i] == '+') {
				stack.push(forwardOperator + backwardOperator);
			}
			if (inputOperators[i] == '-') {
				stack.push(forwardOperator - backwardOperator);
			}
		}
		
		System.out.printf("%.2f", stack.pop());
	}
}

