package generators

trait Generator[T] {
  def generate(): T
}
