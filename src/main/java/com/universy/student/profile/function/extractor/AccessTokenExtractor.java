package com.universy.student.profile.function.extractor;

import com.universy.lambda.api.handlers.context.api.APIContext;
import com.universy.student.profile.function.extractor.exceptions.NoAccessTokenFoundException;

import java.util.Optional;

public class AccessTokenExtractor {

    public String getAccessTokenString(APIContext apiContext){
        return Optional.ofNullable(apiContext)
                .map(APIContext::getHeaders)
                .map(headers -> headers.get("access-token"))
                .orElseThrow(NoAccessTokenFoundException::new);
    }
}
