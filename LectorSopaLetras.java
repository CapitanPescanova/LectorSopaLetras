package projectOne;

import java.util.*;

public class LectorSopaLetras {
	static int	contar;
	public static void main(String[] args) {
		
//		DEFINICIÓN SOPA
		char[][] sopa;
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce altura");
		int x = Integer.parseInt(entrada.nextLine());
		
		System.out.println("Introduce anchura");
		int y = Integer.parseInt(entrada.nextLine());
		
		sopa = new char[x][y];

		System.out.println("Introduce la sopa de letras");
		
		for(int i=0; i<x; i++) {
				String letra = entrada.nextLine().replaceAll(" ", "").toUpperCase();
				sopa[i]= letra.toCharArray();			
		}
		
//		PALABRAS A BUSCAR
		
		System.out.println("Introduce el número de palabras que quieres buscar");
		int Npalabras = entrada.nextInt();
		
		
		System.out.println("Introduce las palabras que quieres buscar");
		
		
		char[][] ListaPalabrasChar = new char[Npalabras][];
		
		for(int i=0; i<Npalabras; i++) {	
			ListaPalabrasChar[i] = entrada.next().toUpperCase().toCharArray();
			
		}
		
			
		
		ArrayList<Integer> contador = new ArrayList<Integer>();
		long inicio = System.currentTimeMillis(); //Tiempo de ejecución
			for (char[] punter : ListaPalabrasChar) {
				contar=0;
				char[]punterInverse=new char[punter.length];
				for (int i = 0; i < punter.length; i++) {
					punterInverse[i]=punter[punter.length-i-1];
					
				}
			
//				HORIZONTAL ➡️ 
				HorizontalChar(sopa, x, y, punter);
				HorizontalChar(sopa, x, y, punterInverse);	
				
				//VERTICAL ⬇️
				VerticalChar(sopa, x, y, punter);
				VerticalChar(sopa, x, y, punterInverse);
				
//				DIAGONAL D ↘️
				
				DiagonalChar_LtoR(sopa, x, y, punter);
				DiagonalChar_LtoR(sopa, x, y, punterInverse);
				
				
//				DIAGONAL I ↙️
				
				DiagonalChar_RtoL(sopa, x, y, punter);
				DiagonalChar_RtoL(sopa, x, y, punterInverse);
					
				contador.add(contar);
					
		}
			
//			SALIDA
			
			int i=0;
			for (char[] word : ListaPalabrasChar) {
					System.out.println(String.valueOf(word) +" = "+contador.get(i));
					i++;
			}
		
			long fin = System.currentTimeMillis();		//SALIDA TIEMPO DE EJECUCIÓN
			double tiempo = (double) ((fin - inicio));
			System.out.println("ExecuteTime: "+tiempo+"ms");
		
	}


//	METODOS
	private static void DiagonalChar_RtoL(char[][] sopa, int x, int y, char[] punter) {
		for(int px=0; px<x; px++) {	
			for(int py=0; py<y; py++) {
				if (sopa[py][px]==punter[0] && ((x+1)-(x-px))>=punter.length && (y-py)>=punter.length) {
					int aux = 0;
					
					for(int s=0; s<punter.length; s++) {
						if (punter[s]==sopa[py+s][px-s]) {
						aux++;
						}
						
					}
					if (aux==punter.length) {
						contar+=1;
					}
				}
				
				
			}
			
		}
	}



	private static void DiagonalChar_LtoR(char[][] sopa, int x, int y, char[] punter) {
		for(int px=0; px<x; px++) {	
			for(int py=0; py<y; py++) {
				if (sopa[py][px]==punter[0] && (x-px)>=punter.length && (y-py)>=punter.length) {
					int aux = 0;
					
					for(int s=0; s<punter.length; s++) {
						
						if (punter[s]==sopa[py+s][px+s]) {
							aux++;
						}
//										
					}
					if (aux==punter.length) {
						contar+=1;
					}
				}
				
				
			}
			
		}
	}



	private static void VerticalChar(char[][] sopa, int x, int y, char[] punter) {
		for(int py=0; py<x; py++) {	
			for(int px=0; px<y; px++) {
				if (sopa[px][py]==punter[0] && (y-px)>=punter.length) {
					int aux = 0;
//									System.out.println(sopa[i][j]);
					for(int s=0; s<punter.length; s++) {
						if (punter[s]==sopa[px+s][py]) {
							aux++;
						}
						
					}
//											
					if (aux==punter.length) {
						contar+=1;
					}
				}
				
				
			}
			
		}
	}



	private static void HorizontalChar(char[][] sopa, int x, int y, char[] punter) {
		for(int px=0; px<x; px++) {	
			for(int py=0; py<y; py++) {
				if (sopa[px][py]==punter[0] && (x-py)>=punter.length) {
					int aux = 0;
					
					for(int s=0; s<punter.length; s++) {
						if (punter[s]==sopa[px][py+s]) {
							aux++;
						}
						
					}
//								
					if (aux==punter.length) {
						contar+=1;
					}
				}
				
				
			}
			
		}
	}
}

	

	
