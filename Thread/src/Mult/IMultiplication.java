package Mult;

import Matrix.IMatrix;
/** Este c�digo es distribuido como parte de un trabajo pr�ctico de
 *  la materia Sistemas Operativos I dictada por la de Ciencias Exactas de
 *  la Universidad nacional del centro de la provincia de Buenos Aires (UNICEN).
 *  El c�digo no debe usarse en ning�n otro proyecto debido a que contiene o 
 *  puede contener malas pr�cticas y errores introducidos intencionalmente con 
 *  fines did�cticos. As� mismo el c�digo carece de cualquier tipo de optimizaci�n
 *  primando la legibilidad del mismo.
 *  @author Dr. Juan Manuel Rodriguez
*/
public interface IMultiplication {
	/**
	 * Multiplica dos matrices
	 * @param a
	 * @param b
	 * @return
	 */
	public IMatrix multiply(IMatrix a,IMatrix b);
}