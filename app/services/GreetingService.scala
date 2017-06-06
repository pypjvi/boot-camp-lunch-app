package services

import com.google.inject.ImplementedBy

/**
  * Created by john on 06/06/17.
  */
class RealGreetingService extends GreetingService {
  def greeting: String = "Alright"
}

@ImplementedBy(classOf[RealGreetingService])
trait GreetingService {
  def greeting: String
}