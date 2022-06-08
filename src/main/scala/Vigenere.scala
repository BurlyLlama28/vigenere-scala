object Vigenere {

  val alphabet = (0 to 25).zip('A' to 'Z').toMap

  def prolong_key(index: Int = 0, key_to_prolong: String,
                  to_append: Int, start_key: String): String = key_to_prolong match {
    case key_to_prolong if (index == to_append) => key_to_prolong
    case _ => {
      val newKey = key_to_prolong.appended(start_key.charAt(index % start_key.length))
      prolong_key(index + 1, newKey, to_append, start_key)
    }
  }

  def key_length(key: String, phrase_length: Int): String = key match {
    case key if (key.length > phrase_length) => key
    case _ => prolong_key(key_to_prolong = key, to_append = phrase_length - key.length, start_key = key)
  }

  def encrypt_phrase(key: String, phrase: String): String = {
    phrase
      .zipWithIndex
      .map{
        case (letter, index) => alphabet((letter + key(index)) % 26)
      }.mkString("") + "\n"
  }

  def decrypt_phrase(key: String, phrase: String): String = {
    phrase
      .zipWithIndex
      .map{
        case (letter, index) => alphabet((letter - key(index) + 26) % 26)
      }.mkString("") + "\n"
  }

  def vigenere(phrase: String, key: String, operation: Int): String = operation match {
    case 1 => encrypt_phrase(key_length(key, phrase.length), phrase)
    case 2 => decrypt_phrase(key_length(key, phrase.length), phrase)
  }

}
