![image](https://user-images.githubusercontent.com/58394648/162635207-ea54a7d5-4c56-4cd3-b7ae-e2c440321613.png)

# BegineerMongoDB

# Spring Quickstart Guide

## Step 1: Start a new Spring Boot project
#### Use start.spring.io to create a “web” project. In the “Dependencies” dialog search for and add the “web” dependency as shown in the screenshot. Hit the “Generate” button, download the zip, and unpack it into a folder on your computer.

![image](https://user-images.githubusercontent.com/58394648/162635442-65d35252-18fe-4cf0-bee4-82efa08241ad.png)

#### Projects created by start.spring.io contain Spring Boot, a framework that makes Spring ready to work inside your app, but without much code or configuration required. Spring Boot is the quickest and most popular way to start Spring projects.

## Step 2: Add your code
#### Open up the project in your IDE and locate the DemoApplication.java file in the src/main/java/com/example/demo folder. Now change the contents of the file by adding the extra method and annotations shown in the code below. You can copy and paste the code or just type it.

#### package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

public static void main(String[] args) {
SpringApplication.run(DemoApplication.class, args);
}

@GetMapping("/hello")
public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
return String.format("Hello %s!", name);
}
}

#### This is all the code required to create a simple “Hello World” web service in Spring Boot.

#### The hello() method we’ve added is designed to take a String parameter called name, and then combine this parameter with the word "Hello" in the code. This means that if you set your name to “Amy” in the request, the response would be “Hello Amy”.

#### The @RestController annotation tells Spring that this code describes an endpoint that should be made available over the web. The @GetMapping(“/hello”) tells Spring to use our hello() method to answer requests that get sent to the http://localhost:8080/hello address. Finally, the @RequestParam is telling Spring to expect a name value in the request, but if it’s not there, it will use the word “World” by default.

