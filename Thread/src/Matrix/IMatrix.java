package Matrix;

/** Este c�digo es distribuido como parte de un trabajo pr�ctico de
 *  la materia Sistemas Operativos I dictada por la de Ciencias Exactas de
 *  la Universidad nacional del centro de la provincia de Buenos Aires (UNICEN).
 *  El c�digo no debe usarse en ning�n otro proyecto debido a que contiene o 
 *  puede contener malas pr�cticas y errores introducidos intencionalmente con 
 *  fines did�cticos. As� mismo el c�digo carece de cualquier tipo de optimizaci�n
 *  primando la legibilidad del mismo.
 *  @author Dr. Juan Manuel Rodriguez
*/

public interface IMatrix {

	/**
	 * Obtiene el n�mero de filas
	 */
	public int getRows();
	
	/**
	 * Obtiene el n�mero de columnas
	 */
	public int getColumns();
	/**
	 * Asigna un valor a una posici�n de la matriz
	 * @param row
	 * @param col
	 * @param value
	 */
	public void set(int row, int col, double value);
	/**
	 * Retorna el valor de una posici�n de la matriz
	 * @param row
	 * @param col
	 * @return
	 */
	public double get(int row, int col);
	/**
	 * Crea una matriz del mismo tipo.
	 * @param rows cantidad de filas.
	 * @param cols cantidad de columnas.
	 * @return
	 */
	public IMatrix createMatrix(int rows, int cols);
}
