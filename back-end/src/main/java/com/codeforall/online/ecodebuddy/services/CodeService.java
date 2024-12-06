package com.codeforall.online.ecodebuddy.services;

import com.codeforall.online.ecodebuddy.exceptions.CodeNotFoundException;
import com.codeforall.online.ecodebuddy.model.Code;

/**
 * Common interface for code services, provides methods to manage its properties
 */
public interface CodeService {

    /**
     * Get the code with the given id
     * @param codeId the customer id
     * @return the code
     * @throws CodeNotFoundException
     */
    Code get (int codeId) throws CodeNotFoundException;



}
