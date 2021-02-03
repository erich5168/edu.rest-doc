package lab.restdocsgradlebuild.resources;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
    public String hello(){
        return "Hello there =-D";
    }
}