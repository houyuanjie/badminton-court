import scala.io.StdIn
import java.time.LocalDate
import java.time.LocalTime
import scala.util.matching.Regex

class BadmintonCourt:

  /**
   * 处理命令行输入
   *
   * @param str
   *   输入行
   * @return
   *   输出
   */
  def handle(str: String): String = ???

object BadmintonCourt:

  case class UserId(uid: String)
  case class Date(date: LocalDate)
  case class Period(from: LocalTime, to: LocalTime)
  case class Court(name: String)

  /**
   * 接受的命令种类
   */
  sealed trait Command

  case class Book(userId: UserId, date: Date, period: Period, court: Court)
      extends Command
  case class Cancel(userId: UserId, date: Date, period: Period, court: Court)
      extends Command
  case object Summary extends Command
  case object BadInput extends Command

  val bookPtn =
    """(\w+) (\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2})~(\d{2}):(\d{2}) (\w+)""".r
  val cancelPtn =
    """(\w+) (\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2})~(\d{2}):(\d{2}) (\w+) C""".r
  val summaryPtn = """\n""".r

  /**
   * 解析命令
   *
   * @param command
   *   输入
   * @return
   *   解析得到的命令
   */
  def parse(command: String): Command =
    command match
      case bookPtn(book)     => ???
      case cancelPtn(cancel) => ???
      case summaryPtn(_)     => Summary
      case _                 => BadInput

@main
def run(): Unit =
  val badmintonCourt = new BadmintonCourt

  while true do
    val input = StdIn.readLine()
    val output = badmintonCourt.handle(input)
    println(output)
