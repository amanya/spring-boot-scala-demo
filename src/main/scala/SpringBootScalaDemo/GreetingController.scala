package SpringBootScalaDemo

import java.util.concurrent.atomic.AtomicLong

import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, RestController}

@RestController
class GreetingController() {

  private val template = "Hello, %s"
  private val counter = new AtomicLong()

  @RequestMapping(Array("/greeting"))
  def greeting(@RequestParam(value = "name", required = false, defaultValue = "World!") name: String): Greeting = {
    Greeting(counter.incrementAndGet(), String.format(template, name))
  }
}
