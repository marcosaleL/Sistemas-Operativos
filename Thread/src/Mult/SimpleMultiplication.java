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
public class SimpleMultiplication implements IMultiplication {

	@Override
	public IMatrix multiply(IMatrix a, IMatrix b) {
		if (a.getColumns()!=b.getRows())
			throw new RuntimeException("La cantidad de columnas de la matriz a tiene que ser igual a la cantidad de filas de la matriz b");
		IMatrix res = a.createMatrix(a.getRows(), b.getColumns());
		//Por cada fila de A
		for (int i=0;i<a.getRows();i++){
			//Por cada columna de B
			for (int j=0;j<b.getColumns();j++){
				//Realiza la multiplicaci�n para la posici�n i j
				for (int k=0;k<b.getRows();k++)
					res.set(i, j, res.get(i, j)+
							a.get(i, k)*b.get(k, j));
			}
		}
		return res;
	}

}