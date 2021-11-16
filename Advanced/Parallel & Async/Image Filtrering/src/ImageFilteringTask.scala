import java.util.concurrent.RecursiveTask

object ImageFilteringTask {
  def filterImage(filter: Array[Array[Int]] => (Int, Int) => Int, windowSize: Int)(imageData: Array[Array[Int]]): Array[Array[Int]] = {
    FilteringProcess(filter(imageData), windowSize, 0, imageData(0).length, 0, imageData.length)()
  }

  case class FilteringProcess(filter: (Int, Int) => Int, window: Int, cStart: Int, cEnd: Int, rStart: Int, rEnd: Int) extends RecursiveTask[Array[Array[Int]]] {
    def apply(): Array[Array[Int]] = {
      val rCnt = rEnd - rStart
      val cCnt = cEnd - cStart

      if(cCnt <= window && rCnt <= window) {
        Array.tabulate[Int](rCnt, cCnt)((r, c) => filter(rStart + r, cStart + c))
      } else if (rCnt > window) {
        val part = rCnt / 2
        val asyncSub = FilteringProcess(filter, window, cStart, cEnd, rStart + part, rEnd).fork()
        Array.concat((FilteringProcess(filter, window, cStart, cEnd, rStart, rStart + part))(),
          asyncSub.join())
      } else {
        val part = cCnt / 2
        val asyncSub = FilteringProcess(filter, window, cStart + part, cEnd, rStart, rEnd).fork()
        val part1Res = FilteringProcess(filter, window, cStart, cStart + part, rStart, rEnd)()
        val part2Res = asyncSub.join()

        for(i <- 0 until rCnt)
          part1Res.update(i, Array.concat(part1Res(i), part2Res(i)))

        part1Res
      }
    }
    override def compute(): Array[Array[Int]] = apply()
  }

}