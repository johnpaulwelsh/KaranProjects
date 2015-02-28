// One-line version
println((1 to 100) map (_.toString) map ((s: String) => if (s.toInt % 3 == 0 && s.toInt % 5 == 0) "FizzBuzz" else if (s.toInt % 3 == 0) "Fizz" else if (s.toInt % 5 == 0) "Buzz" else s))

// Readable version
/*
println(
  (1 to 100) map
  (_.toString) map (
    (s: String) =>
    if (s.toInt % 3 == 0 && s.toInt % 5 == 0) "FizzBuzz"
    else if (s.toInt % 3 == 0) "Fizz"
    else if (s.toInt % 5 == 0) "Buzz"
    else s
  )
)
*/