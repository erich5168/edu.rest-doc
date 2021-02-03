package lab.restdocsgradlebuild.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private HelloService helloService;

//    The follow will cause WebLayerTestDoc to fail for somereason....
//    TODO:: Investigate why this cause faile in test
//
//    public HelloController(HelloService helloService) {
//        this.helloService = helloService;
//    }
//
//    @GetMapping
//    public String getHello(){
//        return helloService.hello();
//    }

    @GetMapping("/string")
    public String getHelloString(){
        return "hello there";
    }


    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hello json() {
        return new Hello("Greetings", "Hello World");
    }

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Hello post(@RequestBody Hello hello) {
        return hello;
    }



    public static class Hello {

        private String title;
        private String value;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Hello(String title, String value) {
            this.title = title;
            this.value = value;
        }

        public Hello() {
        }

        @Override
        public String toString() {
            return "Hello{" +
                    "title='" + title + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
