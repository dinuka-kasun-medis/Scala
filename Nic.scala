package main.scala

import scala.util.control._

/**
  * Created by Dinuka on 4/8/2017.
  */
object Nic extends App{
  print("Please input your NIC :")
  var nicNo = scala.io.StdIn.readLine()

  val year = nicNo.substring(0,2).toInt+1900

  var monthdates=Array(31,29,31,30,31,30,31,31,30,31,30,31)

  var dayNo = nicNo.substring(2,5).toInt

  var gender = "Male"
  if (dayNo>500){
    dayNo-=500
    gender  = "Female"
  }

  def setMonth(day1:Int): String ={
    var month ,da =0
    var day=day1
    var i=0

    val loop = new Breaks;

    loop.breakable {
      for(i<- 0 until monthdates.length-1){
        if(day < monthdates(i)){
          month=i+1
          da=day
          loop.break
        }else{
          day =day-monthdates(i)
        }
      }
    }

    ("\nMonth : " + month + "\nDate : " + da+"\n");
  }

  println("Year :"+year+setMonth(dayNo)+"\nGende :"+gender)
}
/**
Please input your NIC :952640000V
Year :1995
Month : 9
Date : 20

Gende :Male
  **/