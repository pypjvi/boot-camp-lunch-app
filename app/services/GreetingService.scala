package services

import java.util.Calendar

import com.google.inject.ImplementedBy

/**
  * Created by john on 06/06/17.
  */
class RealGreetingService extends GreetingService {
  def greeting: String = {
    val now = Calendar.getInstance()
    val currentHour = now.get(Calendar.HOUR_OF_DAY)
    if (currentHour < 12)
      "Good morning!"
    else
      "Good afternoon!"
  }
}

@ImplementedBy(classOf[RealGreetingService])
trait GreetingService {
  def greeting: String
}