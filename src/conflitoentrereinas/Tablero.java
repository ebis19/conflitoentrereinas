package conflitoentrereinas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

public class Tablero {
	
	Reina [] reinas;
	int [][] tablero;
	int tamano;
	public Tablero(String archivo) throws IOException{
		Scanner in = new Scanner(new File(archivo+".in"));
		this.tamano = in.nextInt();
		reinas = new Reina[in.nextInt()];
		tablero= new int[this.tamano][this.tamano];
		int f,c;
		for (int i = 0; i < reinas.length; i++) {
			f=in.nextInt();
			c=in.nextInt();
			reinas[i]= new Reina(f-1,c-1);
			tablero[f-1][c-1]=i+1;
		}
		in.close();
		
	}
	public void resolver(){
		int rec[][]= {{1,-1},{-1,-1},{0,-1},{1,0},{-1,1},{-1,-1},{1,1},{0,1}};
		for (Reina reina : reinas) {
			for (int[] is : rec) {
				reina.agregarConflicto(buscarConflicto(reina,is));
			}
		}		
	}
	public void guardarEnArchivo(String o) throws IOException{
		
		PrintWriter out = new PrintWriter(new File(o+".out"));
		for (Reina reina : reinas)
			out.print(reina);
		out.close();
	}
	private boolean estaEnTablero(int f , int c){
		return f<tamano && c<tamano && f>=0 && c>=0;
	}
	private int buscarConflicto(Reina reina,int is[]) {
		int posf=reina.f+is[0];
		int posc=reina.c+is[1];
		while(estaEnTablero(posf,posc)){
			if(tablero[posf][posc]!=0)
				return tablero[posf][posc];
			posf+=is[0];
			posc+=+is[1];
			
		}
		return 0;
	}
}
/*
 * 
 * 			reina.agregarConflicto(buscarConflicto(reina,1,-1)); // izq ds
			reina.agregarConflicto(buscarConflicto(reina,-1,-1));// izq dp
			reina.agregarConflicto(buscarConflicto(reina,0,-1)); // izq h
			reina.agregarConflicto(buscarConflicto(reina,1,0)); // arriva
			reina.agregarConflicto(buscarConflicto(reina,-1,0)); //abajo
			reina.agregarConflicto(buscarConflicto(reina,-1,1)); // der ds
			reina.agregarConflicto(buscarConflicto(reina,1,1)); // der dp
			reina.agregarConflicto(buscarConflicto(reina,0,1)); // der h
 * 
	private int buscarConflictosDer(Reina reina) {
		for (int i = reina.c; i < tamano; i++) {
			if(tablero[reina.f][i]!=0)
				return tablero[reina.f][i];
		}
		return 0;
	}
	private int buscarConflictosIzq(Reina reina) {
			for (int i = reina.c; i<0; i--) {
				if(tablero[reina.f][i]!=0)
					return tablero[reina.f][i];
			}
			return 0;
	}

	private int buscarConflictosAbajo(Reina reina) {
		for (int i = reina.c; i<tamano; i++) {
			if(tablero[reina.f][i]!=0)
				return tablero[reina.f][i];
		}
		return 0;
	}

	private int buscarConflictosArriba(Reina reina) {
		for (int i = reina.c; i<0; i--) {
			if(tablero[reina.f][i]!=0)
				return tablero[reina.f][i];
		}
		return 0;
	}



	private int buscarConflictosDpder(Reina reina) {
		int i=0;
		while(reina.f+i<tamano&& reina.c+i<tamano){
			if(tablero[reina.f+i][reina.c+i]!=0)
				return tablero[reina.f+i][reina.c+i];
			i++;
		}
		return 0;
	}

	private int buscarConflictosDpiqz(Reina reina) {
		int i=0;
		while(reina.f+i<0&& reina.c+i<0){
			if(tablero[reina.f+i][reina.c+i]!=0)
				return tablero[reina.f+i][reina.c+i];
			i--;
		}
		return 0;
	}

	private int buscarConflictosDsder(Reina reina) {
			int i=0;
			while(reina.f-i<0&& reina.c+i<tamano){
				if(tablero[reina.f-i][reina.c+i]!=0)
					return tablero[reina.f-i][reina.c+i];
				i--;
			}
			return 0;
	}

	private int buscarConflictosDsiqz(Reina reina) {
		int i=0;
		while(reina.f+i<tamano&& reina.c-i<0){
			if(tablero[reina.f+i][reina.c-i]!=0)
				return tablero[reina.f+i][reina.c-i];
			i--;
		}
		return 0;
	}
*/
	
	

