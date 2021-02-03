package lab.restdocsgradlebuild.resources;


import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();


    @InjectMocks
    private HelloController helloController;

    @Mock
    private HelloService helloService;

    @Before
    public void setUp() throws Exception {
        // create a mock environment of helloController
        mockMvc = MockMvcBuilders.standaloneSetup(helloController)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();

    }

//    @Test
//    public void testDefaultMessage() throws Exception {
//
//        // When the method tested requires an dependency in this case helloService
//        // ** when helloService.hello() is called return string "hello"
//        Mockito.when(helloService.hello()).thenReturn("hello");
//
//        mockMvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("hello"));
//
//        // Mockito.when is called you should always have a verify to see [when] is called
//        Mockito.verify(helloService).hello();
//
//
//        // When Controller does not require any other services
////        mockMvc.perform(get("/hello"))
////                .andExpect(status().isOk())
////                .andExpect(content().string("Hello there =-D"));
//
//    }

    @Test
    public void testPostJson() throws  Exception{
        String json = "{\n" +
                "  \"title\" : \"Greetings\",\n" +
                "  \"value\" : \"Hello World\"\n" +
                "}";
        mockMvc.perform(post("/hello/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
                .andExpect(jsonPath("$.value", Matchers.is("Hello World")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)))
                .andDo(document("home-post"));

    }

    @Test
    public void testGetJson() throws  Exception{
        mockMvc.perform(get("/hello/json").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
                .andExpect(jsonPath("$.value", Matchers.is("Hello World")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)))
                .andDo(document("home-json"));

    }



    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/hello/string"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hello there"))
                )
                .andDo(document("home-string"));

    }
}