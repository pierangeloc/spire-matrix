package math 

trait matrix {

  /**
    * An immutable 2-D Matrix.
    * @tparam T The type of the matrix elements.
    * @tparam M Number of rows (may be abstract).
    * @tparam N Number of columns (may be abstract).
    */
  trait Matrix[T,M,N] {
    /** Number of rows in the matrix */
    def rows : M

    /** Number of columns in the matrix */
    def cols : N
  }

  /** A matrix with known dimensions, supporting safe indexing */
  trait FiniteMatrix[T,M <: Int, N <: Int] extends Matrix[T,M,N] with ((Int,Int) => T) {
    def rows : M

    def cols : N

    /** The number of elements in the matrix, m x n */
    def size : Int /* M x N */ = rows * cols

    /** The element at position i,j. */
    def apply(row : Int, col : Int) : T

    /** Refer to [[math.show]] for a more flexible display type-classes */
    override def toString : String = {
      if (size > 40) s"<$rows × $cols matrix>" 
      else Seq.tabulate(rows,cols)(apply).toString
    }
  }

  /** A `ColumnVector` is just a type alias for a `M` x 1 matrix. */
  type ColumnVector[T,M <: Int] = FiniteMatrix[T,M,1]

  /** A `ColumnVector` is just a type alias for a `M` x `M` matrix. */
  type SquareMatrix[T, M <: Int] = FiniteMatrix[T,M,M]

  /* trait Transpose[Mat[t,m <: Int, n <: Int] <: FiniteMatrix[t,m,n] , T, M <: Int, N <: Int] extends FiniteMatrix[T,N,M] { self : Mat[T,M,N] =>
    def apply(row : Int, col : Int) : T = self(col,row)
  } */
}
