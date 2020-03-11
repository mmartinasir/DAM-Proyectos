package main;

import java.io.IOException;
import java.util.Scanner;

import source.CrossWord;

public class Main {
	
	public static void main(String[] args) throws IOException {
		boolean endLoop = false;
		int operation = 0;
		int x = 0;
		int y = 0;
		String word = "";
		Scanner input = new Scanner(System.in);
		
		CrossWord soup = new CrossWord();
		System.out.println(soup);
		
		while (!endLoop) {
			System.out.println("¿Qué desea hacer?");
			System.out.println("1.- Cerrar el juego");
			System.out.println("2.- Buscar palabra");
			try {
				operation = input.nextInt();
				if (operation == 2 || operation == 1) {
					if (operation == 1) {
						endLoop = true;
					} else {
						System.out.println("¿Qué palabra desea buscar?");
						try {
							word = input.nextLine();
							x = soup.search(word).x;
							y = soup.search(word).y;
							if (x <= 0) {
								System.out.println("Palabra "+word+" encontrada en la posicion: ");
								System.out.println("X: "+x);
								System.out.println("Y: "+y);
								System.out.println();
							} else {
								System.out.println("Palabra "+word+" NO encontrada.");
								System.out.println();
							}
						} catch (Exception e) {
							System.out.println("ERROR: no se ha introducido una palabra");
						}
					}
				} else {
					System.out.println("ERROR: Por favor elija un número de operación correcto");
				}
			} catch (Exception e) {
				System.out.println("ERROR: No se ha introducido un número de operación");
			}
		}

	}


}
