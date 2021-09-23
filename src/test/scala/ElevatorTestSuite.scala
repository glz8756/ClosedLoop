
import Elevator.elevatorList
import Utils.{findPath, loadData}
import model.Elevators.ElevatorState
import org.scalatest.funsuite.AnyFunSuite


class ElevatorTestSuite extends AnyFunSuite {

  val elevatorStr =
    """xx.x.x.x.xxx
      |xx.x.x.x.xxx
      |xx.x.x.x.xxx
      |xx.xBx.x.xxx
      |xx.x.xCx.xxx
      |xxAx.x.xDxxx
      |
      |xx.x.x.x.xxx
      |xx.x.x.x.xxx
      |xx.x.x.x.xxx
      |xx.xBx.x.xxx
      |xxAx.xCxDxxx
      |xx.x.x.x.xxx
      |
      |xx.x.x.x.xxx
      |xx.x.x.x.xxx
      |xx.x.x.x.xxx
      |xxAxBx.xDxxx
      |xx.x.xCx.xxx
      |xx.x.x.x.xxx
      |
      |xx.x.x.x.xxx
      |xx.x.x.x.xxx
      |xx.xBx.xDxxx
      |xxAx.x.x.xxx
      |xx.x.xCx.xxx
      |xx.x.x.x.xxx
      |
      |xx.x.x.x.xxx
      |xx.x.x.xDxxx
      |xx.xBx.x.xxx
      |xxAx.x.x.xxx
      |xx.x.xCx.xxx
      |xx.x.x.x.xxx
      |""".stripMargin

  val esplitedStr = elevatorStr.split("\n").toList

  val elevatorList = loadData(esplitedStr)

  val sortede = elevatorList.sortBy(e => (e.elevator, e.time))

  test("loadData method returns List of ElevatorStates and first element after the sort by elevator and time should be ElevatorState(A,1,1)") {
    assert(sortede(0) == ElevatorState("A", 1, 1))
  }

  test("loadData method returns List of ElevatorStates and number of elevators should 20") {
    assert(elevatorList.length == 20)
  }

  test("findPath method should return  ") {
    val result = findPath(elevatorList, "A", 5, 5)
    assert(result == "ADDDD")
  }

}
