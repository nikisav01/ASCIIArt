package asciiArtApp.models.tables.nonlinear

import org.scalatest.FunSuite

import scala.util.Random

class MyNonLinearTableTest extends FunSuite {
  private val table = MyNonLinearTable()

  test("Converting grey value > 255 or < 0") {
    val rand = Random
    for (i <- 0 until 10) {
      assertThrows[IllegalArgumentException](table.convert(rand.between(256, Int.MaxValue)))
      assertThrows[IllegalArgumentException](table.convert(rand.between(Int.MinValue, -1)))
    }
  }

  test("Converting to ' '") {
    for (i <- 231 until 255) {
      assert(table.convert(i) == ' ')
    }
  }

  test("Converting to ':'") {
    for (i <- 200 until 229) {
      assert(table.convert(i) == ':')
    }
  }

  test("Converting to '*'") {
    for (i <- 150 until 199) {
      assert(table.convert(i) == '*')
    }
  }

  test("Converting to '@'") {
    for (i <- 0 until 149) {
      assert(table.convert(i) == '@')
    }
  }
}
