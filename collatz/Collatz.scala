object Collatz {
  
  def collatz(n: Int, ls: List[Int]): List[Int] = {
    if (n == 1)          1 :: ls
    else if (n % 2 == 0) collatz(n / 2,     n :: ls)
    else                 collatz(n * 3 + 1, n :: ls)
  }

  def main(args: Array[String]): Unit = {
    println(collatz(args(0).toInt, List[Int]()).reverse)
  }
}