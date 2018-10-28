package SpringBootScalaDemo

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.TestContextManager
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.{jsonPath, status}

@RunWith(classOf[JUnitRunner])
@WebMvcTest(Array(classOf[GreetingController]))
class GreetingControllerTest extends FunSuite {

  @Autowired
  var mvc: MockMvc = _

  new TestContextManager(this.getClass).prepareTestInstance(this)

  test("no param greetings should return default message") {

    mvc
      .perform(get("/greeting"))
      .andDo(print())
      .andExpect(status().isOk)
      .andExpect(jsonPath("$.content").value("Hello, World!"))
  }

  test("param greetins should return tailored message") {

    mvc
      .perform(get("/greeting").param("name", "Universe"))
      .andDo(print())
      .andExpect(status().isOk)
      .andExpect(jsonPath("$.content").value("Hello, Universe"))
  }

}
