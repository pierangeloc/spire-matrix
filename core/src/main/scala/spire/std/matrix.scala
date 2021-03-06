package spire.std

import spire.algebra.Eq
import spire.math.matrix.FiniteMatrix

import spire.implicits._

/** Implementing modules can use this for a naive equality implementation in the spire.math.matrix module */
trait MatrixInstance {

  /** Naive implementation of matrix equality. Checks element-by-element equivalence. */
  class FiniteMatrixEq[Mat[m <: Int, n <: Int, t] <: FiniteMatrix[m, n, t], M <: Int, N <: Int, T : Eq] extends Eq[Mat[M, N, T]] {
    def eqv(x : Mat[M, N, T], y : Mat[M, N, T]) : Boolean = 
      ( for ( i <- 0 until x.rows; j <- 0 until x.cols) yield x(i,j) === y(i,j) ) reduce (_ && _)
  }

  implicit def finiteMatrixEqInstance[Mat[m <: Int, n <: Int, t] <: FiniteMatrix[m, n, t], M <: Int, N <: Int, T : Eq] : Eq[Mat[M, N, T]] =
    new FiniteMatrixEq[Mat,M, N, T]
}
