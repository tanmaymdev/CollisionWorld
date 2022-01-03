package edu.rice.comp504.controller;

import com.google.gson.Gson;
import edu.rice.comp504.adapter.DispatchAdapter;

import java.awt.*;

import static spark.Spark.*;


/**
 * The paint world controller creates the adapter(s) that communicate with the view.
 * The controller responds to requests from the view after contacting the adapter(s).
 */
public class BallWorldController {

    /**
     * The main entry point into the program.
     * @param args  The program arguments normally specified on the cmd line
     */
    public static void main(String[] args) {
        staticFiles.location("/public");
        port(getHerokuAssignedPort());
        Gson gson = new Gson();
        DispatchAdapter dis = new DispatchAdapter();

        post("/load", (request, response) -> {
            System.out.println((request.queryMap().value("colStrategy")));
            return gson.toJson(DispatchAdapter.loadBall((request.queryMap().value("type")),(request.queryMap().value("strategy")),(request.queryMap().value("colStrategy")),(request.queryMap().value("switchable")),(request.queryMap().value("removable"))));
        });

        post("/switch", (request, response) -> {
            System.out.println("Post Call for Switch");
            return gson.toJson(DispatchAdapter.switchStrategy());
        });

        get("/update", (request, response) -> {
            return gson.toJson(DispatchAdapter.updateBallWorld());
        });

        get("/ballworld", (request, response) -> {
            DispatchAdapter.removeAll();
            response.redirect("/");
            return null;
        });

        post("/canvas/dims", (request, response) -> {

            System.out.println(request.queryMap().value("width"));
            System.out.println(request.queryMap().value("height"));
            DispatchAdapter.setCanvasDims(new Point(Integer.parseInt(request.queryMap().value("width")),Integer.parseInt(request.queryMap().value("height"))));
            return gson.toJson(DispatchAdapter.getCanvasDims());
        });

        get("/remove/:id", (request, response) -> {
            return gson.toJson(DispatchAdapter.removeSome());
        });

        get("/clear", (request, response) -> {

            return gson.toJson(DispatchAdapter.removeAll());
        });

        get("/:",(request, response) -> {

            response.status(400);
            return "Bad request Please Go to Home by /ballWorld ";
        });

    }

    /**
     * Get the heroku assigned port number.
     * @return The port number
     */
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
