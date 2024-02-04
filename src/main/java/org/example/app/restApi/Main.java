package org.example.app.restApi;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        // GET /tasks/
        // GET /tasks/:id
        // POST /tasks/
        // POST /tasks/:id/check/
        port(8080);
    }
}
