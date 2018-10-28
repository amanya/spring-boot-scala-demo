package SpringBootScalaDemo

import scala.beans.BeanProperty

case class Greeting(@BeanProperty
                    var id: Long,

                    @BeanProperty
                    var content: String) {
}
