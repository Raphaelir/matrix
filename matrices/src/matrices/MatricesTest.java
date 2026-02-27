package matrices;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatricesTest {
	double[] myvoorstelling = {1,2,3,4,5,6,7,8,9};
	int mynumrows = 3;
	int mynumcols = 3;
	Matrices mymatrix = new Matrices(myvoorstelling,mynumcols,mynumrows);
	
	@Test
	void testconstructorenandere() {
		double[][] myarrayrows = {{1,2,3},{4,5,6},{7,8,9}};
		assertEquals(3,mymatrix.getNumberColumns());
		assertEquals(3,mymatrix.getNumberrows());
		assertArrayEquals(myvoorstelling,mymatrix.getMatrixrowmajor());
		double[] colmyvoorstelling = {1,4,7,2,5,8,3,6,9};
 		assertArrayEquals(colmyvoorstelling,mymatrix.getMatrixcolmajor());
 		assertArrayEquals(myarrayrows,mymatrix.getMatrixarrayrows());
 		assertEquals(1,mymatrix.getElementat(0,0));
 		assertEquals(9,mymatrix.getElementat(2,2));
	}
	@Test
	void testscaled() {
		Matrices scaledversion = mymatrix.scaled(2);
		double[] myscaled = {2,4,6,8,10,12,14,16,18};
		assertArrayEquals(myscaled,scaledversion.getMatrixrowmajor());
		
	}
	@Test
	void testplus() {
		double[] myanderevoorstelling = {1,1,1,1,1,1,1,1,1};
		Matrices myandere = new Matrices(myanderevoorstelling,mynumcols,mynumrows);
		double[] myresultplusvoorstelling = {2,3,4,5,6,7,8,9,10};
		Matrices plusmatrix = Matrices.plus(myandere,mymatrix);
		assertArrayEquals(myresultplusvoorstelling,plusmatrix.getMatrixrowmajor());
	}
	@Test
	void testrepresnetationexposure( ) {
		double[] arr = mymatrix.getMatrixrowmajor();
		arr[0] = 999;
		assertEquals(1,mymatrix.getElementat(0,0));
		//Deze test is niet 100% volledig
				
	}
}
