package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by john on 06/06/17.
  */
class WelcomeController extends Controller {

  def welcome() = Action {
    Ok
  }

}
