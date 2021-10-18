import java.util.concurrent.RecursiveTask

object ImageFilteringTask {
  def filterImage(filter: Array[Array[Int]] => (Int, Int) => Int, windowSize: Int)(imageData: Array[Array[Int]]): Array[Array[Int]] = ???

}