package day3

import org.scalatest.{FeatureSpec, Matchers}

import scala.reflect.io.File

class Day3Test extends FeatureSpec with Matchers {

  feature("simple square inch generator") {
    scenario("should take coordinate and size and return ") {
      Day3.createPatch(ElfPatch(1, 1, 3, 1, 1)) shouldBe Seq(((1, 3), 1))
      Day3.createPatch(ElfPatch(1, 1, 3, 2, 1)) shouldBe Seq(((1, 3), 1), ((2, 3), 1))
      Day3.createPatch(ElfPatch(1, 1, 3, 3, 3)) shouldBe Seq(((1, 3), 1), ((1, 4), 1), ((1, 5), 1), ((2, 3), 1), ((2, 4), 1), ((2, 5), 1), ((3, 3), 1), ((3, 4), 1), ((3, 5), 1))
      Day3.createPatch(ElfPatch(1, 1, 3, 4, 4)).size shouldBe 16
    }
  }
  feature("parsing") {
    scenario("should read elf data") {
      File("src/test/resources/day3.input").lines().next shouldBe "#1 @ 108,350: 22x29"
    }
    scenario("should parse elf data"){
      val line = File("src/test/resources/day3.input").lines().next
      Day3.parseLine(line) shouldBe ElfPatch(1, 108, 350, 22, 29)
    }
  }
  feature("foo") {
    val iter = File("src/test/resources/day3.input").lines()
    val all: Iterator[Seq[((Int, Int), Int)]] = for (x <- iter) yield Day3.createPatch(Day3.parseLine(x))
  }

}