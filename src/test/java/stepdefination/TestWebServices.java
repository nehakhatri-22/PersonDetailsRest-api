package stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.*;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;


public class TestWebServices {

private String addURI;
HttpHeaders headers= new HttpHeaders();
RestTemplate restTemplate;
 String id;
    ResponseEntity response;
    @Given("Setup a POST employee service API")
    public void setup_a_post_employee_service_api() {
    addURI="http://localhost:8080/api/persons";
    System.out.println("ADD URL :"+addURI);
    }
    @Given("Setup a PUT employee service API")
    public void setup_a_put_employee_service_api() {
        addURI="http://localhost:8080/api/persons/"+1;
        System.out.println("ADD URL FOR PUT :"+addURI);
    }

    @Given("Setup a GET employee service API")
    public void setup_a_get_employee_service_api() {
        addURI="http://localhost:8080/api/persons/"+1;
        System.out.println("ADD URL FOR PUT :"+addURI);
    }

    @Given("Setup a DELETE employee service API")
    public void setup_a_delete_employee_service_api() {
        addURI="http://localhost:8080/api/persons/"+1;
        System.out.println("ADD URL FOR PUT :"+addURI);
    }
    @When("setup of header")
    public void setup_of_header() {
        headers.add("Accept","application/json");
        headers.add("Content-Type","application/json");

    }
    @When("send a POST HTTP request")
    public void send_a_post_http_request() {

            Double name_id = Math.random();
            String emp_name = "zozo_"+name_id;//Just to avoid Duplicate Name entry
            String jsonBody="{\"firstName\":\""+emp_name+"\",\"lastName\":\"K\",\"age\":\"23\",\"favouriteColor\":\"Black\"}";
            System.out.println("\n\n" + jsonBody);
            HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
            //POST Method to Add New Employee
            restTemplate = new RestTemplate ();
            response = restTemplate.postForEntity(addURI, entity, String.class);
            id=response.getHeaders().get("id").get(0);
            System.out.println("ID Is"+id);
        System.out.println("Response :"+response.getBody());
        }

    @When("send a GET HTTP request")
    public void send_a_get_http_request() {



        //Get Method to Add New Employee
        restTemplate = new RestTemplate ();
        response = restTemplate.getForEntity(addURI, String.class);

        if(response.getHeaders()!=null && response.getHeaders().get("id")!=null){
        id=response.getHeaders().get("id").toString();
        }
        System.out.println("Response :"+response.getBody());
    }

    @Then("i recieve a valid response")
    public void i_recieve_a_valid_response() {
        Assert.isTrue(response.getStatusCode()== HttpStatus.OK);
        System.out.println("Employee is Added successfully employeeId:"+response.getHeaders().get("id"));
    }

    @When("send a PUT HTTP request")
    public void send_a_put_http_request() {

        Double name_id = Math.random();
        String emp_name = "zozo_"+name_id;//Just to avoid Duplicate Name entry
        String jsonBody="{\"firstName\":\""+emp_name+"\",\"lastName\":\"K\",\"age\":\"23\",\"favouriteColor\":\"White\"}";
        System.out.println("\n\n" + jsonBody);
        HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
        //POST Method to Add New Employee
        restTemplate = new RestTemplate ();
      response=restTemplate.exchange(addURI, HttpMethod.PUT,entity,String.class);
    }
    @When("send a DELETE HTTP request")
    public void send_a_delete_http_request() {

        Double name_id = Math.random();
        String emp_name = "zozo_"+name_id;//Just to avoid Duplicate Name entry
        String jsonBody="{\"firstName\":\""+emp_name+"\",\"lastName\":\"K\",\"age\":\"23\",\"favouriteColor\":\"White\"}";
        System.out.println("\n\n" + jsonBody);
        HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
        //DELETE Method to Add Remove person
        restTemplate = new RestTemplate ();
        response=restTemplate.exchange(addURI, HttpMethod.DELETE,entity,String.class);
    }
}
