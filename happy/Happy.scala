object Happy {
  
  /*
   * Convert an integer into a string, make it a list of strings
   * instead of characters, and make each string back into an integer
   */
  def getDigits(n: Int) = n.toString map (_.toString) map (_.toInt)

  /*
   * Counts how many times each number occurs in the list, and returns
   * whether any of the counts is greater than 1 (which in this case is
   * 2 because we wouldn't be able to skip 2 and get to 3 accidentally)
   */
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
    for (n <- List(19, 23, 22)) { println("Is " + n + " happy? " + isHappy(n)) }
  }
}