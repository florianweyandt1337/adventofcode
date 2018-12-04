package day3
import scala.collection.immutable
import scala.util.matching.Regex

case class ElfPatch(id: Int, startX: Int, startY: Int, sizeX: Int, sizeY: Int)

object Day3 {
  def createPatch(patch: ElfPatch): Seq[((Int, Int), Int)] = {
    val xCoords = patch.startX until patch.startX + patch.sizeX
    val yCoords = patch.startY until patch.startY + patch.sizeY
    for (x <- xCoords; y <- yCoords)
      yield ((x, y), patch.id)
  }

  def parseLine(line: String): ElfPatch = {
    val regex: Regex = "#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)".r
    val foo = regex.findAllMatchIn(line).next
    val id = foo.group(1).toInt
    val startX = foo.group(2).toInt
    val startY = foo.group(3).toInt
    val sizeX = foo.group(4).toInt
    val sizeY = foo.group(5).toInt
    ElfPatch(id, startX, startY, sizeX, sizeY)
  }
}