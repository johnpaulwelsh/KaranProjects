import scala.math._

object Limit {

  def calculateLimit(f: Double => Double, x: Double, precisions: Double*): List[Double] = {
    precisions.toList map ((h: Double) => (f(x + h) - f(x)) / h)
  }

  def main(args: Array[String]): Unit = {
    val limits = calculateLimit(
      (x: Double) => (pow(x, 2) + 2*x + 1),
      3,
      0.001, 0.0001, 0.00001
    )
    limits.foreach(println)
    println("Do they look close enough to an actual answer to you? Good.")
  }
}