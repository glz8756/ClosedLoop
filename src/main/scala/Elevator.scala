import Utils._

import java.io.FileNotFoundException
import scala.io.Source
import scala.util.Try

object Elevator extends App {

  if (args.length < 3) {
    println("insufficient arguments")
    System.exit(1);

  }
  val filename = args(0)
  val startElevator = args(1)
  val destination = args(2).split("-").toList

  val data = ReadFileFromResource.resourceInto(filename)
  val linesStr = data match {
    case Right(lines) => lines
    case Left(msg) => throw new FileNotFoundException(filename)
  }
  val splitedStr = linesStr.split("\n").toList
  val elevatorList = loadData(splitedStr)
  val result = findPath(elevatorList, startElevator, destination(0).toInt, destination(1).toInt)
  if (result.isEmpty) System.err.println("nothing")  else  println(result)

}
