package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form, making sure it doesn't contain any html tags or javascript
    String name = Jsoup.clean(request.getParameter("name"), Safelist.none());
    String email = Jsoup.clean(request.getParameter("email"), Safelist.none());
    String reason = Jsoup.clean(request.getParameter("reason"), Safelist.none());
    String message = Jsoup.clean(request.getParameter("message"), Safelist.none());

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Communication");
    FullEntity communicationEntity = 
        Entity.newBuilder(keyFactory.newKey())
            .set("name", name)
            .set("email", email)
            .set("reason", reason)
            .set("message", message)
            .build();
    datastore.put(communicationEntity);

    response.sendRedirect("/#about");

    // Print the value so you can see it in the server logs.
    System.out.println("name: " + name);
    System.out.println("email: " + email);
    System.out.println("reason: " + reason);
    System.out.println("message: " + message);

    // Write the value to the response so the user can see it.
    //response.sendRedirect("https://google.com");
    response.getWriter().println("name: " + name);
    response.getWriter().println("email: " + email);
    response.getWriter().println("reason: " + reason);
    response.getWriter().println("message: " + message);
  }
}