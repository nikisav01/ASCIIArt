package asciiArtApp.models.tables

/**
 * Interface for conversion tables
 */
trait Table[T, R] {
  /**
   * Converts item from T to R
   * @param item The item to convert
   * @return
   */
  def convert(item: T): R
}
