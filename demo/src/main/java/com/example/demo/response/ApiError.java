package com.example.demo.response;

import org.springframework.http.HttpStatus;

public class ApiError {
    private final HttpStatus httpStatus;
    private final String message;
    private final String apiName;

    private ApiError(ApiErrorBuilder apiErrorBuilder) {
        this.httpStatus = apiErrorBuilder.httpStatus;
        this.message = apiErrorBuilder.message;
        this.apiName = apiErrorBuilder.apiName;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public String getApiName() {
        return apiName;
    }

    public static ApiErrorBuilder builder() {
        return new ApiErrorBuilder();
    }

    public static class ApiErrorBuilder {
        private HttpStatus httpStatus;
        private String message;
        private String apiName;

        public ApiErrorBuilder setHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public ApiErrorBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiErrorBuilder setApiName(String apiName) {
            this.apiName = apiName;
            return this;
        }

        public ApiError build() {
            return new ApiError(this);
        }
    }
}
