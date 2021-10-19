object ZipWordTask {
  def zipIt(prefixSeq: Seq[String], wordSeq: Seq[String], suffixSeq: Seq[String]): Seq[String] = {
//    prefixSeq.zip(suffixSeq).map{case(x,y) => x+y}
    def zip[X,Y,Z](xs: Seq[X], ys: Seq[Y], zs: Seq[Z]): Seq[(X,Y,Z)] = {
      for (((x, y), z) <- xs zip ys zip zs) yield (x, y, z)
    }
    zip(prefixSeq, wordSeq, suffixSeq).map{case(x,y,z) => x+y+z}
  }
}