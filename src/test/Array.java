package test;

public class Array {

	public static void main(String[] args) {

	char x[][]=new char[2][4];
	x[0][0]='a';
	x[0][1]='b';
	x[0][2]='c';
	x[0][3]='d';
	
	x[1][0]='e';
	x[1][1]='f';
	x[1][2]='g';
	x[1][3]='h';
	
	char row,col;
	for(row=0;row<x.length;row++) {
		for(col=0;col<x[0].length;col++) {
			System.out.println(x[row][col]);
			
		}
	}
	
	
	
		
	}

}
