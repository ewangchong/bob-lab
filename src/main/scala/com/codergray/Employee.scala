package com.codergray

class Employee (var name : String , var salary : Int) {
  var dept = 0

  def printEmployee() = {
    println(name + " makes $" + salary)
  }
}


object Main {
  def main(args: Array[String]): Unit = {
    var emily = new Employee("Emily", 10000)
    println(emily.name)
    println(emily.salary)
    emily.salary = 20000
    println(emily.salary.toString())
    println(emily.dept)
    emily.dept = 10

    emily.printEmployee()
  }
}