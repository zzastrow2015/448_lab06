import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<ArrayList<Integer>> matrix1 = readCSV(new File("Matrix1.csv"));
		System.out.println();
		ArrayList<ArrayList<Integer>> matrix2 = readCSV(new File("Matrix2.csv"));		
		System.out.println();
		
		ArrayList<ArrayList<Integer>> multiply1 = readCSV(new File("multiplier1.csv"));
		System.out.println();
		ArrayList<ArrayList<Integer>> multiply2 = readCSV(new File("multiplier2.csv"));
		System.out.println();
		
		System.out.println("multiply");
		ArrayList<ArrayList<Integer>> multiplied = multiply(multiply1, multiply2);
		
		for(int i = 0; i < multiplied.size(); i++){
			System.out.println();
			for(int j = 0; j < multiplied.get(i).size(); j++){
				System.out.print(multiplied.get(i).get(j) + " ");
			}
		}
		
		System.out.println();
		ArrayList<ArrayList<Integer>> add1 = readCSV(new File("add1.csv"));
		System.out.println();
		ArrayList<ArrayList<Integer>> add2 = readCSV(new File("add2.csv"));
		System.out.println();
		
		System.out.println("add");
		ArrayList<ArrayList<Integer>> added = add(add1, add2);
		
		for(int i = 0; i < added.size(); i++){
			System.out.println();
			for(int j = 0; j < added.get(i).size(); j++){
				System.out.print(added.get(i).get(j) + " ");
			}
		}
		
		System.out.println();
		ArrayList<ArrayList<Integer>> transpose = readCSV(new File("transpose.csv"));
		System.out.println();
		
		System.out.println("transpose");
		ArrayList<ArrayList<Integer>> transposed = transpose(transpose);
		
		for(int i = 0; i < transposed.size(); i++){
			System.out.println();
			for(int j = 0; j < transposed.get(i).size(); j++){
				System.out.print(transposed.get(i).get(j) + " ");
			}
		}
		
		
	}

	
	
	
	private static ArrayList<ArrayList<Integer>> readCSV(File csv)throws NumberFormatException, IOException{
		
		BufferedReader br;
		String line;
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		String split = ",";
		int prevRow = 0;
		boolean initial = true;
		int rowNumber = 0;
		
		try {
			br = new BufferedReader(new FileReader(csv));
			
			while((line = br.readLine()) != null){
				String rowString[] = line.split(split);
				int row[] = new int[rowString.length];
				matrix.add(new ArrayList<Integer>());
				for(int x = 0; x < rowString.length; x++){
					row[x] = Integer.parseInt(rowString[x]);
					matrix.get(rowNumber).add(x, row[x]);;
					System.out.print(row[x] + " ");
				}
				
				if((!initial) && (prevRow != rowString.length)){
					System.out.println("Not a matrix.");
					break;
				}
				
				if(initial){
					initial = false;
				}
				
				
				rowNumber++;
				System.out.println();
				prevRow = rowString.length;
			}
			
			return matrix;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return matrix;
		
	}
	
	
	
 	private static ArrayList<ArrayList<Integer>> multiply(ArrayList<ArrayList<Integer>> csv1, ArrayList<ArrayList<Integer>> csv2){
 		
 		ArrayList<ArrayList<Integer>> product = new ArrayList<ArrayList<Integer>>();
 		int sum = 0;
 		
 		for(int i = 0; i < csv1.size(); i++){
 			product.add(new ArrayList<Integer>());
 			for(int j = 0; j < csv2.get(0).size(); j++){
 				product.get(i).add(j, 0);
 			}
 		}
 		
 		for(int i = 0; i < csv1.size(); i++){
 			for(int j = 0; j < csv2.get(0).size(); j++){
 				sum = 0;
 				for(int k = 0; k < csv1.get(0).size(); k++){
 					sum += csv1.get(i).get(k) * csv2.get(k).get(j);
 					product.get(i).set(j, sum);
 					
 				}
 			}
 		}
 		
 		return product;
 		
 	}
 	
 	private static ArrayList<ArrayList<Integer>> add(ArrayList<ArrayList<Integer>> csv1, ArrayList<ArrayList<Integer>> csv2){
 		
 		ArrayList<ArrayList<Integer>> sum = new ArrayList<ArrayList<Integer>>();
 		
 		for(int i = 0; i < csv1.size(); i++){
 			sum.add(new ArrayList<Integer>());
 			for(int j = 0; j < csv1.get(i).size(); j++){
 				sum.get(i).add(j, csv1.get(i).get(j) + csv2.get(i).get(j));
 			}
 		}
 		
 		return sum;
 		
 	}


 	private static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> csv1){
 		
 		ArrayList<ArrayList<Integer>> transposed = new ArrayList<ArrayList<Integer>>();
 		
 		for(int i = 0; i < csv1.get(0).size(); i++){
 			transposed.add(new ArrayList<Integer>());
 			for(int j = 0; j < csv1.size(); j++){
 				
 				transposed.get(i).add(j, csv1.get(j).get(i));
 				
 			}
 		}
 		
 		
 		return transposed;
 	}

	
}

