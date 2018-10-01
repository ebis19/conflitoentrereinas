package conflitoentrereinas;

import java.util.ArrayList;
import java.util.Arrays;

public class Reina {

	int f;
	int c;
	int []conflictos;
	int i;
	public Reina(int f2, int c2) {
		this.f=f2;
		this.c=c2;
		this.i=0;
		conflictos = new int[8];
	}
	
	public void agregarConflicto(int conflicto){
		conflictos[this.i]=conflicto;
		i++;
	}

	@Override
	public String toString() {
		String str="";
		int cant=0;
		Arrays.sort(conflictos);
		for (Integer i : conflictos) {
			if(i!=0){
				str+=" "+i;
				cant++;
			}
		}
		str=cant+str+"\n";
		return str;
	}
	

}
