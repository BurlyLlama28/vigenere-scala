import scala.io.StdIn.{readLine, readInt}

import Vigenere.vigenere

object Main extends App {
  println("1 - encrypt phrase, 2 - decrypt phrase")
  readInt() match {
    case 1 => print(vigenere(readLine("Enter encrypt-phrase: ").toUpperCase,
      readLine("Enter key: ").toUpperCase.filterNot(_.isWhitespace), 1))
    case 2 => print(vigenere(readLine("Enter decrypt-phrase: ").toUpperCase,
      readLine("Enter key: ").toUpperCase.filterNot(_.isWhitespace), 2))
    case _ => System.exit(0)
  }

}