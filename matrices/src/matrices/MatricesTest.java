package matrices;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatricesTest {
	int[] myvoorstelling = {1,2,3,4,5,6,7,8,9};
	int mynumrows = 3;
	int mynumcols = 3;
	Matrices mymatrix = new Matrices(myvoorstelling,mynumcols,mynumrows);
	
	@Test
	void testconstructorenandere() {
		int[][] myarrayrows = {{1,2,3},{1,2,3},{1,2,3}};
		assertEquals(3,mymatrix.getNumberColumns());
		assertEquals(3,mymatrix.getNumberrows());
		assertArrayEquals(myvoorstelling,mymatrix.getMatrixrowmajor());
		int[] colmyvoorstelling = {1,4,7,2,5,8,3,6,9};
 		assertArrayEquals(colmyvoorstelling,mymatrix.getMatrixcolmajor());
 		assertArrayEquals(myarrayrows,mymatrix.getMatrixarrayrows());
 		assertEquals(1,mymatrix.getElementat(0,0));
 		assertEquals(9,mymatrix.getElementat(2,2));
	}
	@Test
	void testscaled() {
		int[] mynulvoorstelling = {0,0,0,0,0,0,0,0,0};
		int[] myscaled = {2,4,6,8,10,12,14,16,18};
		mymatrix.scaled(0);
		assertArrayEquals(mynulvoorstelling, mymatrix.getMatrixrowmajor());
		Matrices mymatrix = new Matrices(myvoorstelling,mynumcols,mynumrows);
		mymatrix.scaled(1);
		assertArrayEquals(myvoorstelling,mymatrix.getMatrixrowmajor());
		Matrices mymatrix2 = new Matrices(myvoorstelling,mynumcols,mynumrows);
		mymatrix.scaled(2);
		assertArrayEquals(myscaled,mymatrix2.getMatrixrowmajor());
		
	}
	@Test
	void testplus() {
		int[] myanderevoorstelling = {1,1,1,1,1,1,1,1,1};
		Matrices myandere = new Matrices(myanderevoorstelling,mynumcols,mynumrows);
		int[] myresultplusvoorstelling = {2,3,4,5,6,7,8,9,10};
		Matrices resultplus = new Matrices(myresultplusvoorstelling,mynumcols,mynumrows);
		assertEquals(resultplus,Matrices.plus(myandere,mymatrix));
	}
}
