# Elevator



**Priorities:**

   1. Correctness
   2. Implementation time
   3. Elegance of code
   4. Anything else you think we might care about in a coding test. 

The following diagram is an elevator state ñ the state of an elevator system at a given point in time:

```
  xx.x.x.x.xxx
  xx.x.x.x.xxx
  xx.x.x.x.xxx
  xx.xBx.x.xxx
  xx.x.xCx.xxx
  xxAx.x.xDxxx
```

Dots represent an elevator shaft. Letters (specifically A-Z) represent an elevator ñ for example, elevator A is on the 1st floor (1-indexed), and the following elevator state has 6 floors.

**Goal:** Take as input a series of elevator states from a file, representing successive states of the elevator 

system from t = {1,2,3, ...} Each elevator state will be separated by an empty line. Valid elevators are specified by the characters A-Z.

Write a command line program that takes a command-line like:

**Elevator &lt;filename&gt; &lt;starting elevator&gt; &lt;final destination&gt;**

Where **&lt;final destination&gt;** is specified as **&lt;floor&gt;-&lt;time&gt;**, e.g. 3-2, indicating that the final destination is the 3rd floor at time t=2.

At t=1, you begin in the elevator specified by <starting elevator>, e.g. "A".

In a given time period, you can board an elevator or stay on the elevator you are on. In any time period, you can only board any elevator on the same floor as the elevator that you are currently on (including t=1).

The goal is to find a series of legal actions that lead to you being at the final destination ñ the right floor at the right time.

The set of actions should be written to stdout as a series of actions in a single string. An action is defined as the elevator you board (or stay on) at time t, eg:

**AABDD**

Indicates that you were on (or switched to) A at t=1, stayed on A at t=2, switched to B at t=3, and switched to D at t=4, and stayed on D at t=5.

If there is a solution, the solution string is the *only* thing that should be printed to stdout.

If there is no solution, print something appropriate to stderr, and **nothing** to stdout.


