package matrices;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.IntStream;
/**
 * Deze klasse slaat een matrix op
 * @immutable
 */

public class Matrices {
	/**
	 * @invar | this.numrow > 0
	 * @invar | this.numcol >0
	 * @invar | this.matrix != null
	 * 
	 */
	
	private double[] matrix; // opgeslagen in row major order
	private int numcol;
	private int numrow;
	
	/**
	 * Geeft heet aantal kolommen van het matrix-object terug
	 * 
	 * @post | result == getMatrixarrayrows().length
	 * 
	 */
	
	public int getNumberrows() {
		return this.numrow;
		
	}
	/**
	 * Geeft heet aantal kolommen van het matrix-object terug
	 * @post | result == getMatrixarrayrows()[0].length
	 * 
	 */
	public int getNumberColumns() {
		return this.numcol;
	}
	/**
	 * Geeft heet aantal kolommen van het matrix-object terug
	 * @post | result == getMatrixarrayrows()[row][col]
	 * 
	 */
	public double getElementat(int row, int col) {
		return this.matrix[this.numcol*row+col];
	}
	/**
	 * Geeft de hele matrix terug in row major order
	 * @creates | result
	 * @post | result != null
	 * @post | IntStream.range(0,getNumberrows()).allMatch(i->IntStream.range(0,getNumberColumns()).allMatch(k->result[i*getNumberColumns()+k]==getMatrixarrayrows()[i][k]))
	 * 
	 */
	public double[] getMatrixrowmajor() {
		return this.matrix.clone();
	}
	/**
	 * Geeft de hele matrix terug in column major order
	 * @creates | result
	 * @post | result != null
	 * @post | IntStream.range(0,getNumberColumns()).allMatch(i->IntStream.range(0,getNumberrows()).allMatch(k->result[i*getNumberrows()+k]==getMatrixarrayrows()[i][k]))
	 */
	public double[] getMatrixcolmajor() {
		double[] colmajor = new double[this.matrix.length];
		for(int i=0;i<this.numrow;i++)
			for(int k=0;k<this.numcol;k++)
				colmajor[this.numrow*k+i] = this.matrix[this.numcol*i+k];
		return colmajor;
		
	}
	/**
	 * Geeft de matrix terug in onder de vorm van een array van rijen
	 * @creates | result
	 * @post | result != null
	 */
	public double[][] getMatrixarrayrows() {
		double[][] arrayrows = new double[this.numrow][];
		double[] row = new double[this.numcol];
		for(int i=0;i<this.numrow;i++) {
			for(int k=0;k<this.numcol;k++) {
				row[k] = this.matrix[this.numcol*i+k];
			arrayrows[i] = row;
			}}
		return arrayrows;
	}
	
	/**
	 * Deze methode laat toe om een matrix aan te maken
	 * @throws IllegalArgumentException | voorstelling == null
	 * @throws IllegalArgumentException | numcol*numrow != voorstelling.length
	 * @post | getMatrixrowmajor().equals(voorstelling)
	 * @post | getNumberColumns() == numcol
	 * @post | getNumberrows() == numrow
	 */
	public Matrices(double[] voorstelling, int numcol, int numrow) {
		if(voorstelling == null)
			throw new IllegalArgumentException();
		if(numcol*numrow != voorstelling.length)
			throw new IllegalArgumentException();
		this.matrix = voorstelling.clone();
		this.numcol = numcol;
		this.numrow = numrow;
	}
	
	/**
	 * Deze methode laat toe om elke ementen van een matrix te vermenigvuldigen met een gegeven scalair getal
	 * @creates | result
	 * @post | IntStream.range(0,getNumberrows()).allMatch(i->old(getMatrixrowmajor().clone())[i]*factor == getMatrixrowmajor()[i])
	 * @post | getNumberrows() == old(getNumberrows())
	 * @post | getNumberColumns() == old(getNumberColumns())
	 */
	public Matrices scaled(int factor) {
		double[] nieuwevoorstelling = this.matrix.clone();
		for(int i=0;i<matrix.length;i++)
			matrix[i] = factor*nieuwevoorstelling[i];
		Matrices nieuwematrix = new Matrices(nieuwevoorstelling,this.numcol,this.numrow);
		return nieuwematrix;
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
		double[] voorstelling1 = mat1.getMatrixrowmajor();
		double[] voorstelling2 = mat2.getMatrixrowmajor();
		double[] somvoorstelling = new double[voorstelling1.length];
		for(int i=0;i<voorstelling1.length;i++)
			somvoorstelling[i] = voorstelling1[i] + voorstelling2[i]; 
		Matrices nieuwematrix = new Matrices(somvoorstelling,mat1.getNumberColumns(),mat1.getNumberrows());
		return nieuwematrix;
			
		
	}
	
}

