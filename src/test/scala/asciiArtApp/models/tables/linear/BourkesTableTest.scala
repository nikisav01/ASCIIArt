package asciiArtApp.models.tables.linear

import org.scalatest.FunSuite

import scala.util.Random

class BourkesTableTest extends FunSuite {

  private val table = BourkesTable() // " .:-=+*#%@"

  test("Converting grey value > 255 or < 0") {
    val rand = Random
    for (i <- 0 until 10) {
      assertThrows[IllegalArgumentException](table.convert(rand.between(256, Int.MaxValue)))
      assertThrows[IllegalArgumentException](table.convert(rand.between(Int.MinValue, -1)))
    }
  }

  test("Converting to ' '") {
    for (i <- 231 until 256) {
      assert(table.convert(i) == ' ')
    }
  }

  test("Converting to ':'") {
    for (i <- 180 until 204) {
      assert(table.convert(i) == ':')
    }
  }

  test("Converting to '-'") {
    for (i <- 154 until 179) {
      assert(table.convert(i) == '-')
    }
  }

  test("Converting to '='") {
    for (i <- 128 until 154) {
      assert(table.convert(i) == '=')
    }
  }

  test("Converting to '+'") {
    for (i <- 103 until 127) {
      assert(table.convert(i) == '+')
    }
  }

  test("Converting to '*'") {
    for (i <- 77 until 102) {
      assert(table.convert(i) == '*')
    }
  }

  test("Converting to '#'") {
    for (i <- 52 until 76) {
      assert(table.convert(i) == '#')
    }
  }

  test("Converting to '%'") {
    for (i <- 26 until 51) {
      assert(table.convert(i) == '%')
    }
  }

  test("Converting to '@'") {
    for (i <- 0 until 25) {
      assert(table.convert(i) == '@')
    }
  }
}
