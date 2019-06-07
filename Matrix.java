//Submitted by: Laura Neff

import java.util.Arrays;


public class Matrix {


/*two constructors -- the first constructor should take a two-dimensional array of doubles

(where the outer array represents the rows of the matrix) and build a matrix with the same elements,

while the second constructor should create a matrix with the specified number of rows and columns that is filled with zeros.
 */


	private double[][] matrix;
	/*static String StandardMatrix = "A standard matrix has the same number of elements in each row. Ragged arrays cannot serve as standard matrices, and thus" +
			"standard matrix transformations cannot be performed on them.";

	static String MatrixAddition = "Two matrices must be of the same dimension to be able to add them. Addition is done" +
			"by adding corresponding elements (located in the same row and column of their respective matrices) together to make" +
			"a new matrix made up of these additions.";
	static String MatrixProduct = "A matrix can be multiplied by another matrix that has rows equal to the former mentioned's columns. However, matrix products are not commutative, so matrix A * matrix B != matrix B * matrix A."
			+ "The size of the product of two matrices has the same amount of rows as the first matrix in the multiplication equation and the same amount of columns as the second matrix in the multiplication equation." +
			"Multiplication is done by multiplying each row in the first matrix by the corresponding column in the second matrix.";
*/

	public Matrix(double[][] Array) {
		matrix = new double[Array.length][Array[0].length];
		for (int i = 0; i < Array.length; i++) {
			for (int j = 0; j < Array[0].length; j++) {
				matrix[i][j] = Array[i][j];
			}
		}
	}

	public Matrix(int rows, int columns) {
		matrix = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = 0;
			}
		}
	}
/* a toString() method that creates a string representation of the matrix, with its column elements
separated by tabs and its row elements separated by "\n". */


	public String toString() {

		String matrixStrin = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrixStrin += matrix[i][j] + "\t";
			}
			matrixStrin += "\n";
		}
		return matrixStrin;
	}

/* methods named numRows() and numCols() which return the number or
rows and columns of the matrix, respectively.
*/

	public int numRows() {
		return matrix.length;
	}


	public int numCols() {
		return matrix[0].length;
	}

/* a method getElement(r, c) that returns the element
in the r_th row and the c_th column of the matrix.
 */

	public double getElement(int row, int column) {
		return matrix[row][column];
	}

/*a method setElement(r, c, value) that sets
the value of the element in the r_th row and
the c_th column to value.
 */

	public void setElement(int row, int column, double value) {
		matrix[row][column] = value;
	}


/* a method sum(a,b) that creates a new matrix equal to the sum of matrices a and b,
 and that can be invoked using the class name (e.g. ReviewTest3Again c = ReviewTest3Again.sum(a,b);)
  */

   /* public static boolean CanTheyAdd(ReviewTest3Again a, ReviewTest3Again b) {

		return (a.matrix.length == b.matrix.length) && (a.matrix[0].length == b.matrix[0].length);
	}
	*/

	public static Matrix sum(Matrix a, Matrix b) {

		Matrix c = new Matrix(a.matrix.length, a.matrix[0].length);

		if ((a.matrix.length == b.matrix.length) && (a.matrix[0].length == b.matrix[0].length)) {
			for (int i = 0; i < a.matrix.length; i++) {
				for (int j = 0; j < a.matrix[0].length; j++) {
					//double ElementA = a.getElement(i, j);
					//double ElementB = b.getElement(i, j);
					double finalElement = a.matrix[i][j] + b.matrix[i][j];
					c.matrix[i][j] = finalElement;
				}
			}
			return c;
		} else {
			return null;
		}
	}
	/*a method product(a,b) that creates a new matrix equal to the product of matrices a and b,
	 that can be invoked using the class name (e.g. ReviewTest3Again c = ReviewTest3Again.product(a,b);
	  */

	public static Matrix product(Matrix a, Matrix b) {
		Matrix c = new Matrix(a.matrix.length, b.matrix[0].length);
		if (a.matrix[0].length == b.matrix.length) {
			for (int i = 0; i < c.matrix.length; i++) {
				for (int j = 0; j < c.matrix[0].length; j++) {
					//make third "for" loop to indicate when we are done with the first column of b and need to move on to its second and etc.
					//l will take the place of j as the column element for a
					//make it go up to a.matrix[0] to indicate when we are done with row of a
					for (int l = 0; l < a.matrix[0].length; l++) {
						c.matrix[i][j] += a.matrix[i][l] * b.matrix[l][j];
					}
				}

			}
			return c;
		} else {
			return null;
		}
	}

	/* a method subMatrix(deletedRow, deletedCol) that creates a new (smaller)
	 matrix from the existing one by deleting the specified row and column.
	 If there is no such row or column, or if the matrix only has one row or column,
	null should be returned.
	 */

	public Matrix subMatrix(int deletedRow, int deletedCol) {
        Matrix Subby = new Matrix(matrix.length - 1, matrix[0].length - 1);
        if ((deletedRow < matrix.length) && (deletedCol < matrix[0].length)) {
            for (int i = 0; i < matrix.length; i++) {
                if (i == deletedRow) {
                    continue;
                }
                int newI = i;
                if (i > deletedRow) {
                    newI = i - 1;
                }
                for (int j = 0; j < matrix[0].length; j++) {
                    if (j == deletedCol) {
                        continue;
                    }
                    int newJ = j;
                    if (j > deletedCol) {
                        newJ = j - 1;
                    }
                    Subby.matrix[newI][newJ] = matrix[i][j];
                }
            }
            return Subby;
        } else {
            return null;

            /* Fills in Parts Want to Remove with 0s (not like example, which has blanks) //

		if ((deletedRow <= matrix.length) && (deletedCol <= matrix[0].length)) {
			ReviewTest3Again Subby = new ReviewTest3Again (matrix.length, matrix[0].length);
			for(int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					if ((i != deletedRow) && (j != deletedCol)) {
						Subby.matrix[i][j] = matrix[i][j];
					} else {
						Subby.matrix[i][j] = 0;
					}
				}
			} return Subby;
*/

		}
    }
    

    public Double determinant() {
		//first do when it's not a square matrix
		if(matrix.length != matrix[0].length) {
			return null;
		}
		//first find determinant of a 1 * 1 matrix
		if(numRows() == 1) {
			return matrix[0][0];
			//then find determinant of a 2 * 2 matrix
		} else if (numRows() == 2) {
			return matrix[0][0] * matrix[1][1] - (matrix[0][1] * matrix[1][0]);
			//find determinant of every other kind of matrix
		} else {
			double det = 0;
			for(int j = 0; j < matrix[0].length; j++) {
				det += matrix[0][j] * Math.pow(-1, 1 + (j + 1)) * subMatrix(0,j).determinant();
			} return det;
		}
	}




	}






