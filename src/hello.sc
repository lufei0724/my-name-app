case class StudentId(id: Int)
case class StaffId(id: Int)
case class Score(s: Double)

trait Printer[A] {
  def getString(a: A): String
}

object Printer {
  implicit val studentPrinter: Printer[StudentId] = new Printer[StudentId] {
    def getString(a: StudentId): String = s"StudentId: ${a.id}"
  }

  implicit val staffPrinter: Printer[StaffId] = new Printer[StaffId] {
    def getString(a: StaffId): String = s"StaffId: ${a.id}"
  }
}

def show[A](a: A)(implicit printer: Printer[A]): String = printer.getString(a)
//import Printer._
val studentId = StudentId(25)
show(studentId)
val staffId = StaffId(30)
show(staffId)
