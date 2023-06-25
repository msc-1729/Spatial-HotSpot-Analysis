package cse512

object HotzoneUtils {
/*
Method: ST_Contains
Input: pointString:String, queryRectangle:String
Output: Boolean (true or false)
*/
  def ST_Contains(queryRectangle: String, pointString: String ): Boolean = {
    var rect = new Array[String](4)
    rect = queryRectangle.split(",")
    var r1 = rect(0).trim.toDouble
    var rb1 = rect(1).trim.toDouble
    var r2 = rect(2).trim.toDouble
    var rb2 = rect(3).trim.toDouble

    var point = new Array[String](2)
    point = pointString.split(",")
    var pt1=point(0).trim.toDouble
    var pt2=point(1).trim.toDouble

    var length =0.0
    var height =0.0

    if (r1 < r2) {
      length = r1
      height = r2
    }

    else {
      length = r2
      height = r1
    }

    var lengthy = math.min(rb1, rb2)
    var heighty = math.max(rb1, rb2)

    if(pt2 > heighty || pt1 < length || pt1 > height || pt2 < lengthy)
      return false

    else
      return true
  }
}
