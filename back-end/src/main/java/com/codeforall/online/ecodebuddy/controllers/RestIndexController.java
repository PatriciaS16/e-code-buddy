package com.codeforall.online.ecodebuddy.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for providing basic API information
 */
@CrossOrigin(origins ="*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RestIndexController {

    /**
     * Handles HTTP GET requests to the root endpoint of the API.
     * @return an {@link ApiVersion} object containing the name and version of the API
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    protected ApiVersion showVersion(){
        ApiVersion version = new ApiVersion();
        version.setName("E-Code Buddy");
        version.setVersion("v0.0.1");

        return version;
    }

    /**
     * A simple class representing the version information of the API
     */
    private static class ApiVersion {
        private String name;
        private String version;

        /**
         * Get the name of the API
         * @return the name of the API
         */
        public String getName() {
            return name;
        }

        /**
         * Set the name of the API
         * @param name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Get the version of the API
         * @return the version of the API
         */
        public String getVersion() {
            return version;
        }

        /**
         * Set the version of the API
         * @param version to set
         */
        public void setVersion(String version) {
            this.version = version;
        }
    }
}
