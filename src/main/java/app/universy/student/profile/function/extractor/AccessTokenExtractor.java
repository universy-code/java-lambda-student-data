package app.universy.student.profile.function.extractor;

import app.universy.lambda.apigw.context.api.APIContext;
import app.universy.student.profile.function.extractor.exceptions.NoAccessTokenFoundException;

import java.util.Optional;

public class AccessTokenExtractor {

    public String getAccessTokenString(APIContext apiContext){
        return Optional.ofNullable(apiContext)
                .map(APIContext::getHeaders)
                .map(headers -> headers.get("access-token"))
                .orElseThrow(NoAccessTokenFoundException::new);
    }
}
