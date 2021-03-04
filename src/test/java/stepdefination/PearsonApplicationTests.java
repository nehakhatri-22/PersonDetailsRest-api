///*
//package com.example.pearson;
//
//import com.api.example.Person;
//import com.api.example.PersonController;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest(classes = PersonController.class )
//class PearsonApplicationTests {
//
//@Autowired
//PersonController personController;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private StudentService studentService;
//
//    Course mockCourse = new Course("Course1", "Spring", "10Steps",
//            Arrays.asList("Learn Maven", "Import Project", "First Example",
//                    "Second Example"));
//
//    String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
//
//
//@Test
//public void createStudentCourse() throws Exception {
//    Person PERSON = new Person();
//    // studentService.addCourse to respond back with mockCourse
//    Mockito.when(
//            personController.createperson(
//                    Mockito.any(Person.class))).thenReturn(mockCourse);
//
//    // Send course as body to /api/persons/
//    RequestBuilder requestBuilder = MockMvcRequestBuilders
//            .post("/api/persons/")
//            .accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
//            .contentType(MediaType.APPLICATION_JSON);
//
//    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//    MockHttpServletResponse response = result.getResponse();
//
//    assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//    assertEquals("http://localhost/students/Student1/courses/1",
//            response.getHeader(HttpHeaders.LOCATION));
//
//}
//}
//*/
