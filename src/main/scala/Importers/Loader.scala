package Importers

trait Loader[T] {
  /**
   * Loads item
   * @return Loaded item
   */
  def load(): T
}
