package ch05_조건;

import java.util.Scanner;

public class Switch01 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String cmd = null;

		System.out.println("명령 선택:");
		cmd = scanner.next();
		//입,출력 형태 다 맞춰줘야함.
		
		switch (cmd) {
			case "create" : 
				System.out.println("데이터를 생성합니다.");
				break;

			case "read" : 
				System.out.println("데이터를 조회합니다.");
				break;

			case "update" : 
				System.out.println("데이터를 수정합니다.");
				break;

			case "delete" : 
				System.out.println("데이터를 삭제합니다.");
				break;

			default : 

				System.out.println("나머지");

		}

	}
}

