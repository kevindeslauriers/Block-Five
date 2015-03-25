package com.bayviewglen.regional2011;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

import com.bayviewglen.datastructures.Cell;

public class Problem_4 {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(new File("input/q4.dat"));
		HashSet<Cell> marked = new HashSet<Cell>();
		
		int numCells = Integer.parseInt(input.nextLine());
		Cell[] cells = new Cell[numCells];
		
		// we have the cells
		for (int i=0; i<numCells; ++i){
			String t = input.nextLine();
			cells[i] = new Cell(Integer.parseInt(t.split(" ")[0]), Integer.parseInt(t.split(" ")[1]));
		}
		
		for (Cell c1 : cells){
			for (Cell c2 : cells){
				if (!c1.equals(c2) && (!marked.contains(c1) || !marked.contains(c1))){
					if (isPermTree(c1,c2,cells)){
						marked.add(c1);
						marked.add(c2);
					}	
				}
			}
		}
		
		System.out.println("The are " + marked.size() + " perimeter trees in this grove of " + numCells + " trees.");
		input.close();
	}

	private static boolean isPermTree(Cell c1, Cell c2, Cell[] cells) {
		boolean hasLeft = false;
		boolean hasRight = false;
		
		int Ax = c1.getRow();
		int Bx = c2.getRow();
		
		int Ay = c1.getCol();
		int By = c2.getCol();
		
		for (Cell c : cells){
			int Y = c.getCol();
			int X = c.getRow();
			if (((Bx-Ax)*(Y-Ay) - (By-Ay)*(X-Ax)) < 0)
				hasLeft = true;
			else if (((Bx-Ax)*(Y-Ay) - (By-Ay)*(X-Ax)) > 0)
				hasRight = true;
		}
		
		return !hasLeft || !hasRight;
		
	}
}
