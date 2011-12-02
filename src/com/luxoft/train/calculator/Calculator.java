package com.luxoft.train.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class Calculator {

	private static byte getChoice() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		System.out.print(">");
		byte response = Byte.parseByte(br.readLine());//get input1
		return response;
	}

	private static String getUserAnswer(String invite) throws IOException  {
		System.out.println(invite);
		System.out.print(">");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		return br.readLine();		
	}

	private static byte enterOperator() throws IOException {
		String operator = getUserAnswer("Enter the operation:");
		byte operatorNumber = 0;

		if (operator.equals("+")) {
			operatorNumber = 1;
		} else if (operator.equals("-")) {
			operatorNumber = 2;
		} else if (operator.equals("*")) {
			operatorNumber = 3;
		} else if (operator.equals("/")) {
			operatorNumber = 4;
		} else if (operator.equals("sqrt")) {
			operatorNumber = 5;
		} else if (operator.equals("pow")) {
			operatorNumber = 6;
		} else if (operator.equals("sin")) {
			operatorNumber = 7;
		} else if (operator.equals("cos")) {
			operatorNumber = 8;
		} else if (operator.equals("tg")) {
			operatorNumber = 9;
		} else if (operator.equals("ctg")) {
			operatorNumber = 10;
		} else {
			operatorNumber = 0;
		}
		return operatorNumber;
	}
	
	private static byte selectOperator() throws IOException {
		System.out.println("Choose one of the following operations:");
		System.out.println("1. +");
		System.out.println("2. –");
		System.out.println("3. *");
		System.out.println("4. /");
		System.out.println("5. sqrt");
		System.out.println("6. pow");
		System.out.println("7. sin");
		System.out.println("8. cos");
		System.out.println("9. tg");
		System.out.println("10. ctg");
		return getChoice();
	}

	private static void doCalc(byte operator) throws NumberFormatException, IOException {
		Double op1 = 0.0;
		Double op2 = 0.0;
		Double res = 0.0;
		final String queryFirstOperand = "Please, enter the first operand: ";
		final String querySecondOperand = "Please, enter the second operand: ";		
		final String queryOperand = "Please, enter the operand: ";
		
		switch (operator) {
		case 1: 
			System.out.println("Operation is “+”");
			op1 = Double.parseDouble(getUserAnswer(queryFirstOperand));
			op2 = Double.parseDouble(getUserAnswer(querySecondOperand));
			res = op1 + op2;
			System.out.println(op1.toString() + "+" + op1.toString() + "=" +
					res.toString());
			break;
		case 2: 
			System.out.println("Operation is “-”");
			op1 = Double.parseDouble(getUserAnswer(queryFirstOperand));
			op2 = Double.parseDouble(getUserAnswer(querySecondOperand));
			res = op1 - op2;
			System.out.println(op1.toString() + "-"+op1.toString() + "=" +
					res.toString());
			break;
		case 3: 
			System.out.println("Operation is “/”");
			op1 = Double.parseDouble(getUserAnswer(queryFirstOperand));
			op2 = Double.parseDouble(getUserAnswer(querySecondOperand));
			res = op1 / op2;
			System.out.println(op1.toString() + "/" + op1.toString() + 
					"=" + res.toString());
			break;
		case 4: 
			System.out.println("Operation is “*”");
			op1 = Double.parseDouble(getUserAnswer(queryFirstOperand));
			op2 = Double.parseDouble(getUserAnswer(querySecondOperand));
			res = op1 * op2;
			System.out.println(op1.toString() + "*" + op1.toString() + "=" + 
					res.toString());
			break;
		case 5: 
			System.out.println("Operation is “sqrt”");
			op1 = Double.parseDouble(getUserAnswer(queryOperand));
			res = Math.sqrt(op1);
			System.out.println("sqrt(" + op1.toString() + ")=" + 
					res.toString());
			break;
		case 6: 
			System.out.println("Operation is “pow”");
			op1 = Double.parseDouble(getUserAnswer(queryFirstOperand));
			op2 = Double.parseDouble(getUserAnswer(querySecondOperand));
			res = Math.pow(op1, op2);
			System.out.println("pow(" + op1.toString() + "," + 
					op1.toString() + ")=" + res.toString());
			break;
		case 7: 
			System.out.println("Operation is “sin”");
			op1 = Double.parseDouble(getUserAnswer(queryOperand));
			res = Math.sin(op1);
			System.out.println("sin(" + op1.toString() + ")=" + 
					res.toString());
			break;
		case 8: 
			System.out.println("Operation is “cos”");
			op1 = Double.parseDouble(getUserAnswer(queryOperand));
			res = Math.cos(op1);
			System.out.println("cos(" + op1.toString() + ")=" + 
					res.toString());
			break;
		case 9: 
			System.out.println("Operation is “tg”");
			op1 = Double.parseDouble(getUserAnswer(queryOperand));
			res = Math.tan(op1);
			System.out.println("tg(" + op1.toString() + ")=" + 
					res.toString());
			break;
		case 10: 
			System.out.println("Operation is “ctg”");
			op1 = Double.parseDouble(getUserAnswer(queryOperand));
			res = 1.0 / Math.tan(op1);
			System.out.println("ctg(" + op1.toString() + ")=" + 
					res.toString());
			break;
		default: 
			System.out.println("You made a wrong choice.");
			System.out.println("Try again");
			break;
		}
	}

	public static void main(String[] args) {
		boolean isExit = false;
		byte operator = 0;
		System.out.println("Hello! I’m a Java:Reload calc.");
		try {
			while (!isExit) {
				System.out.println("What would you like to do (enter the number)?:");
				System.out.println("1. Choose an operation from the list.");
				System.out.println("2. Enter the operation manually.");
				System.out.println("3. Exit");
				switch (getChoice()) {
					case 1:
						operator = selectOperator();
						doCalc(operator);
						break;
					case 2:
						operator = enterOperator();
						doCalc(operator);
					case 3: 
						isExit = true;
						break;
					default:
						System.out.println("Please, enter a number from 0 to 3:");
						break;
				}
			}
		} catch (NumberFormatException exc) {
			System.err.println("You have entered wrong number.");
		} catch (IOException exc) {
			System.err.println(exc.getLocalizedMessage());
		}
		System.out.println("Thanks for using our program!");
	}
}