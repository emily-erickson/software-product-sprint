package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Random;
import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/random-fact")
public class RandomFactServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> factsArray = new ArrayList<String>();
    factsArray.add("When I'm not at school, I love wearing homemade duct tape shoes. They are like barefoot shoes but way cheaper.");
    factsArray.add("I used to have a pet rabbit named Hershey.");
    factsArray.add("My favorite food is rolled oats.");

    Gson gson = new Gson();
    String json = gson.toJson(factsArray);

    response.setContentType("application/json;");
    response.getWriter().println(json);

    // Random rng = new Random();
    // int randomNum = rng.nextInt(3);
    // response.setContentType("text/html;");
    // if (randomNum == 0) {
    //     response.getWriter().println("When I'm not at school, I love wearing homemade duct tape shoes. They are like barefoot shoes but way cheaper.");  
    // } else if (randomNum == 1) {
    //     response.getWriter().println("I used to have a pet rabbit named Hershey.");  
    // } else {
    //     response.getWriter().println("My favorite food is rolled oats.");
    }
// response.setContentType("text/html;");
//     response.getWriter().println("<h1>Hi!</h1>");
  }


