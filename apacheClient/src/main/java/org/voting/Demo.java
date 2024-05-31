package org.voting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    public void simpleGetData() throws IOException {
        HttpGet getReq = new HttpGet("http://localhost:8080/student"); // opens a connection

        CloseableHttpResponse response = httpClient.execute(getReq); // get the response data in JSON format

        HttpEntity entity  = response.getEntity();// hold the response as ResponseEntity

//        System.out.println(EntityUtils.toString(entity)); // interpreting the data as string and returns it

//        we can check the http status code
//        System.out.println(response.getStatusLine().getStatusCode()); //return the status code for us. we can play around it.

//        getting the objects from the response(from json objects)
        ObjectMapper mapper = new ObjectMapper();
        List<Student> studentList = new ArrayList<>();
        studentList = mapper.readValue(EntityUtils.toString(entity), new TypeReference<List<Student>>() {});
        System.out.println(studentList.size()+" students found");
        studentList.forEach(System.out::println);


    }
    public void getParametrizedData(int id) throws IOException {
        String url = "http://localhost:8080/student/"+id;
        HttpGet req = new HttpGet(url);

        CloseableHttpResponse response = httpClient.execute(req);

        HttpEntity entity  = response.getEntity();

        ObjectMapper mapper = new ObjectMapper();
        Student student;
        student = mapper.readValue(EntityUtils.toString(entity), new TypeReference<Student>() {});
        System.out.println(student.toString());
    }
    public void postStudent() throws IOException {
        HttpPost req = new HttpPost("http://localhost:8080/saveStudent"); // opening connection
        Student student = new Student(12,"Baki Hanma","baki@gmail.com"); // creating student object
        ObjectMapper mapper = new ObjectMapper();
        StringEntity entity = new StringEntity(mapper.writeValueAsString(student), ContentType.APPLICATION_JSON); // converting  a pojo object to a json object
        req.setEntity(entity);//putting entity into the body
        CloseableHttpResponse response = httpClient.execute(req); // sending entity to server and receiving the response entity
        if(response.getStatusLine().getStatusCode()!=200){
            System.out.println("BAD CONNECTION!");

        }else{
            System.out.println("DATA SAVED!");
        }
    }
}
