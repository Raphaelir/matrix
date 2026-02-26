package matrices;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.IntStream;
/**
 * Deze klasse slaat een matrix op
 * @invar |getNumberrows() > 0
 * @invar | getNumberColumns() >0
 * @invar | getMatrixrowmajor() != null
 * @invar | getMatrixarrayrows() != null
 */

public class Matrices {
	/**
	 * 
	 * 
	 */
	
	private int[] matrix; // opgeslagen in row major order
	private int numcol;
	private int numrow;
	
	/**
	 * Geeft heet aantal kolommen van het matrix-object terug
	 * 
	 * @post | result == getMatrixarrayrows().length
	 * 
	 */
	
	public int getNumberrows() {
		fail("Not yet implemented");
		
	}
	/**
	 * Geeft heet aantal kolommen van het matrix-object terug
	 * @post | result == getMatrixarrayrows()[1].length
	 * 
	 */
	public int getNumberColumns() {
		fail("Not yet implemented");
	}
	/**
	 * Geeft heet aantal kolommen van het matrix-object terug
	 * @post | result == getMatrixarrayrows()[row][col]
	 * 
	 */
	public int getElementat(int row, int col) {
		fail("Not yet implemented");
	}
	/**
	 * Geeft de hele matrix terug in row major order
	 * @creates | result
	 * @post | result != null
	 * @post | IntStream.range(0,getNumberrows()).allMatch(i->IntStream.range(0,getNumberColumns()).allMatch(k->result[i*getNumberColumns()+k]==getMatrixarrayrows()[i][k]))
	 * 
	 */
	public int[] getMatrixrowmajor() {
		fail("Not yet implemented");
	}
	/**
	 * Geeft de hele matrix terug in column major order
	 * @creates | result
	 * @post | result != null
	 * @post | IntStream.range(0,getNumberColumns()).allMatch(i->IntStream.range(0,getNumberrows()).allMatch(k->result[i*getNumberrows()+k]==getMatrixarrayrows()[i][k]))
	 */
	public int[] getMatrixcolmajor() {
		fail("Not yet implemented");
	}
	/**
	 * Geeft de matrix terug in onder de vorm van een array van rijen
	 * @creates | result
	 * @post | result != null
	 * @post | result.length == getNumberrows()
	 * @post | result[0].length == getNumberColumns()
	 */
	public int[][] getMatrixarrayrows() {
		fail("Not yet implemented");
	}
	
	/**
	 * Deze methode laat toe om een matrix aan te maken
	 * @throws IllegalArgumentException | voorstelling == null
	 * @post | getMatrixrowmajor() == voorstelling
	 * @post | getNumberColumns() == numcol
	 * @post | getNumberrows() == numrow
	 */
	public Matrices(int[] voorstelling, int numcol, int numrow) {
		fail("Not yet implemented");
	}
	
	/**
	 * Deze methode laat toe om elke ementen van een matrix te vermenigvuldigen met een gegeven scalair getal
	 * @mutates | this
	 * @post | IntStream.range(0,getNumberrows()).allMatch(i->old(getMatrixrowmajor().clone())[i]*factor == getMatrixrowmajor()[i])
	 * @post | getNumberrows() == old(getNumberrows())
	 * @post | getNumberColumns() == old(getNumberColumns())
	 */
	public void scaled(int factor) {
		fail("Not yet implemented");
	}
	/**
	 * Deze methode telt twee matrices op en geeft het resultaat terug.
	 * @pre | mat1 != null
	 * @pre | mat2 != null
	 * @pre | mat1.getNumberColumns() == mat2.getNumberColumns()
	 * @pre | mat1.getNumberrows() == mat2.getNumberrows()
	 * @creates | result
	 * @post | IntStream.range(0,mat1.getNumberColumns()*mat1.getNumberrows()).allMatch(i->result.getMatrixrowmajor()[i]==mat1.getMatrixrowmajor()[i]+mat2.getMatrixrowmajor()[i])
	 * @post | result.getNumberColumns() == mat1.getNumberColumns()
	 * @post | result.getNumberrows() == mat1.getNumberrows()
	 */
	public static Matrices plus(Matrices mat1, Matrices mat2) {
		
		fail("Not yet implemented");
	}
	
}

