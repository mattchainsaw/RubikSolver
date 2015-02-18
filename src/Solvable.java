/**
 * Interface for different algorithms that solve an instance of Cube.
 * @author Matthew Meyer
 */
interface Solvable {
  /**
   * A single solve method with a mixed Cube argument
   * @param cube An instance of a Cube
   * @return A string of steps to do to get the cube to the solved state.
   */
  public String solve(Cube cube);
}
