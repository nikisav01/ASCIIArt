package correctors.defaults

import correctors.Corrector

class IdentityCorrector[T] extends Corrector[T] {
  /**
   * Corrects an item
   *
   * @param item The item to correct
   * @return The corrected item
   */
  override def correct(item: T): T = item
}
