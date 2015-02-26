object Happy {

  def getDigits(n: Int) = n.toString map (_.toString) map (_.toInt)

  def hasDuplicates(xs: List[Int]) = {
    val countList = for (x <- xs) yield xs.count(_ == x)
    countList.contains(2)
  }

  def isHappy(n: Int): Boolean = {
    
    def calc(x: Int, pastSums: List[Int]): Boolean = {
      if (x == 1) true
      else if (hasDuplicates(pastSums)) false
      else {
        val squares = getDigits(x) map ((x: Int) => scala.math.pow(x, 2))
        val sum = squares.sum.toInt
        calc(sum, sum :: pastSums)
      }
    }

    calc(n, List[Int]())
  }

  def main(args: Array[String]): Unit = {
    val ns = List(19, 23, 22)
    for (n <- ns) {
      println("Is " + n + " happy? " + isHappy(n))
    }
  }
}