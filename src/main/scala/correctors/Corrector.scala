package correctors

trait Corrector[T] {
  /**
   * Corrects an item
   * @param item The item to correct
   * @return The corrected item
   */
  def correct(item: T): T
}
