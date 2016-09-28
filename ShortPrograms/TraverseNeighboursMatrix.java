package ShortPrograms;

import ImageProcessing.Pixel;

public class TraverseNeighboursMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[][] matrix = 
				   {{-1.0, -1.0, -1.0},
                    {-1.0, 8.0, -1.0},
                    {-1.0, -1.0, -1.0}};
		int[][] source = 
			   {{3, 10, 9, 0},
                {8, 2, 2, 0},
                {0, 1, 1, 0},
                {1, 2, 3, 4}};
		
		int[][] target =
			   {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
		        {0, 0, 0, 0}};
		 
		doOperation(target, source, matrix);

		for (int i=0;i < target.length;i++) {
			for(int j=0;j<target[0].length;j++) {
				System.out.print(target[i][j] + ",");
			}
			System.out.println();
		}
	}
	
	private static void doOperation(int[][] target, int[][] source, double[][] matrix) {
		
	    for (int sourceX=0; sourceX < source.length; sourceX++) {
	    	for (int sourceY=0; sourceY < source[0].length; sourceY++) {	    		
	    		operationHelper(target, source, matrix, sourceX, sourceY);
	    	}
	    }
	}
	
	private static void operationHelper(int[][] target, int[][] source, double[][] matrix, int sourceX, int sourceY) {
		
	    //Don't do calculation for edges of the new picture. Do blind copy from source.
		if (sourceX == 0 || sourceY == 0 || sourceX == source.length - 1 || sourceY == source[0].length - 1) {
			target[sourceX][sourceY] = source[sourceX][sourceY];
			
			return;
		}
		
		final int rowKeys[] = {-1, -1, -1,  0, 0, 0,  1, 1, 1};
		final int colKeys[] = {-1,  0,  1, -1, 0, 1, -1, 0, 1};
		    
		//Weighted sum
		double weightedSum = 0;
		 
		weightedSum = 0;
		for (int k=0; k < 9; k++) {
			weightedSum = weightedSum + 
		    				(matrix[1 + rowKeys[k]][1 + colKeys[k]] * 
		    			     source[sourceX + rowKeys[k]][sourceY + colKeys[k]]);
		}
		target[sourceX][sourceY] = (int) weightedSum;
	}

}
