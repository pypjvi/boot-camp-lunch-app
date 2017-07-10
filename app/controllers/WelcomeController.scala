package controllers

import javax.inject.Inject

import play.api.mvc.{Action, Controller}
import services.GreetingService

/**
  * Created by john on 06/06/17.
  */
class WelcomeController @Inject() (greeter: GreetingService) extends Controller{
  def welcome() = Action {
    val greeting = greeter.greeting
    Ok.apply(views.html.welcome(greeting))
  }
}
