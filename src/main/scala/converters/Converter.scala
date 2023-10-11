package converters

/**
 * Interface for converting an object of type T to an object of type P
 * @tparam T input type
 * @tparam R return type
 */
trait Converter[T, R] {
  /**
   * Converts the item with type T to type R
   * @param item The item to convert
   * @return
   */
  def convert(item: T): R
}
