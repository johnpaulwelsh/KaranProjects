def shift(n: Int, amt: Int) = if (n == 32) n else if ((n + amt) < 65) 91 - (65 % (n + amt)) else if ((n + amt) > 90) 64 + ((n + amt) % 90) else n + amt
def encode(s: String, amt: Int) = s.toList map ((c: Char) => shift(c.toInt, amt)) map (_.toChar) mkString
def decode(s: String, amt: Int) = encode(s, -amt)
def solve(s: String, amt: Int, builder: String): String = if (amt < 0) builder else solve(s, amt - 1, builder + "Solve " + amt + ": " + decode(s, amt % 26) + "\n")
println("Encode: " + encode(args(0).toUpperCase, args(1).toInt) + "\nDecode: " + decode(args(0).toUpperCase, args(1).toInt) + "\n" + solve(args(0).toUpperCase, 26, ""))