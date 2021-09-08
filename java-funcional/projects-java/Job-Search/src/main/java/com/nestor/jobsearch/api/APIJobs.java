package com.nestor.jobsearch.api;

import com.nestor.jobsearch.JobPosition;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

/**
 * Esta interfaz sera usada por Feign para hacer las peticiones a la API de github.
 */

public interface APIJobs {
    @RequestLine("GET /positions.json")
    List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap);

}
