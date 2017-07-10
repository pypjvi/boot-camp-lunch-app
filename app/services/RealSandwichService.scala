package services

import com.google.inject.ImplementedBy

import scala.concurrent.Future
import models.Sandwich
import uk.gov.hmrc.play.http.HeaderCarrier
import uk.gov.hmrc.play.http.ws.WSGet

//default execution context https://www.playframework.com/documentation/2.5.x/ScalaAsync

import play.api.libs.concurrent.Execution.Implicits.defaultContext

/**
  * Created by john on 07/06/17.
  */
class RealSandwichService extends SandwichService {

  val http = new WSGet {
    override val hooks = NoneRequired
  }

  override def sandwiches: Future[List[Sandwich]] = {
    implicit val hc = HeaderCarrier()
    http.GET[List[Sandwich]]("http://localhost:3000/sandwiches")
  }
}

@ImplementedBy(classOf[RealSandwichService])
trait SandwichService {
  def sandwiches() : Future[List[Sandwich]]
}