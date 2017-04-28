package com.mycompany.mavenproject1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet(value="/helloWorld", name="helloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setHeader("Content-Type", "application/json");
//      resp.getWriter().print("{\"message\": \"hello, world!\"}");
       
        OpenWeatherMap owm = new OpenWeatherMap("");

        // getting current weather data for the "London" city
        CurrentWeather cwd = owm.currentWeatherByCityName("Bochum");
       
        //json Object
        JSONObject json = new JSONObject();
        
        json.put("City", cwd.getCityName());
        json.put("Temperature", cwd.getMainInstance().getMaxTemperature()+ "/" + cwd.getMainInstance().getMinTemperature() + "\'F");
      
        resp.getWriter().print(json);
        
        
//      resp.getWriter().println("City: " + cwd.getCityName());
//      resp.getWriter().println("Temperature: " + cwd.getMainInstance().getMaxTemperature()
//                            + "/" + cwd.getMainInstance().getMinTemperature() + "\'F");        
    }
}
