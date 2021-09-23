import model.Elevators.ElevatorState

import scala.annotation.tailrec

object Utils {

  def transform(s: String): String = {
    s.replace(".", "").replace("x", "")
  }

  def loadData(input: List[String]): List[ElevatorState] = {
    val numberOfFloor = input.indices.find(i => input(i) == "").getOrElse(0)
    @tailrec
    def loadDataTailrec(remaining: List[String], curTime: Int, curFloor: Int, result: List[ElevatorState]): List[ElevatorState] = {
      if (remaining.isEmpty) result.reverse
      else if (remaining.head == "") {
        loadDataTailrec(remaining.tail, curTime + 1, numberOfFloor, result)
      }
      else {
        val transformStr = transform(remaining.head)
        val elist = transformStr.map { s => ElevatorState(s.toString, curFloor, curTime) }.toList
        loadDataTailrec(remaining.tail, curTime, curFloor - 1, result ++ elist)
      }
    }
    loadDataTailrec(input, 1, numberOfFloor, List())
  }

  def findPath(elist: List[ElevatorState], start: String, endFloor: Int, endTime: Int): String = {
    val curFloor = elist.find { e => e.elevator == start && e.time == 1 }.getOrElse(ElevatorState("", 0, 0)).floor
    @tailrec
    def findPathTailrec(remaining: List[(ElevatorState, List[String])]): String = {
      if (remaining.isEmpty)  ""
      else {
        val (curElevator, curPath) = remaining.head
        if (curElevator.time == endTime && curElevator.floor == endFloor) curPath.reverse.mkString
        else {
          val nextFloorElevator = elist.find(e=> e.time == curElevator.time + 1 && e.elevator == curElevator.elevator).getOrElse(ElevatorState("", 0, 0))
          val allElevatorOnCurFloor = elist.filter(e => e.time == nextFloorElevator.time && e.floor == nextFloorElevator.floor)
          val tuple = allElevatorOnCurFloor.map { e => (e, e.elevator :: curPath) }
          findPathTailrec(remaining.tail ++ tuple)
        }
      }
    }
    findPathTailrec(List((ElevatorState(start, curFloor, 1), List(start))))
  }
}
