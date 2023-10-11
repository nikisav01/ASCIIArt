package exporters

trait Exporter[T] {
  /**
   * Exports item somewhere
   * @param item The item to export
   */
  def export(item: T): Unit
}
