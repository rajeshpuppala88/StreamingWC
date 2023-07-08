package java.techies.spark.examples

import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession

object StreamingWC extends Serializable{
  @transient lazy val logger: Logger = Logger.getLogger(getClass.getName)
  def main(args: Array[String]): Unit = {
      val spark = SparkSession.builder()
        .master("local[3]")
        .appName("Streaming word count")
        .getOrCreate()

    val linesDF = spark.readStream
      .format("socket")
      .option("host","localhost")
      .option("port", "9999")
      .load()
  linesDF.printSchema()
  }

}
