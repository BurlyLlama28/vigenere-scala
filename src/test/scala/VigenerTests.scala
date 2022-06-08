import org.scalatest._
import org.scalatest.matchers.should.Matchers
import Vigenere.{key_length, vigenere}

class VigenerTests extends FlatSpec with Matchers {

  it should ("prolong key to the phrase's length") in {
    key_length("key", 7) shouldBe "keykeyk"
  }

  it should ("not prolong key to the phrase's length") in {
    key_length("key", 2) shouldBe "key"
  }

  it should ("encrypt phrase") in {
    vigenere("INTELLIJ", "IDEA", 1) shouldBe "QQXETOMJ"
  }

  it should ("decrypt phrase") in {
    vigenere("INTELLIJ", "IDEA", 2) shouldBe "AKPEDIEJ"
  }

}
