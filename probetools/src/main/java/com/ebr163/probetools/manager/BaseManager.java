package com.ebr163.probetools.manager;

import android.content.Context;

import com.ebr163.probetools.Router;

import fi.iki.elonen.NanoHTTPD;

import static fi.iki.elonen.NanoHTTPD.newFixedLengthResponse;

/**
 * Created by Ergashev on 02.11.16.
 */

public abstract class BaseManager {

    private Router router;
    protected Context context;

    Router getRouter() {
        return router;
    }

    public BaseManager setRouter(Router router) {
        this.router = router;
        return this;
    }

    NanoHTTPD.Response responseStringAsJson(String response) {
        if (response == null) {
            response = "null";
        } else if (response.length() == 0) {
            response = "\"\"";
        }
        return newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "application/json; charset=UTF-8", response);
    }
}
