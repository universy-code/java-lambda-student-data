package app.universy.student.profile.cognito;

import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.model.GetUserRequest;
import com.amazonaws.services.cognitoidp.model.GetUserResult;
import com.universy.cognito.CognitoIdentityProviderFactory;
import com.universy.cognito.actions.CognitoAction;

public class GetUser implements CognitoAction<String, GetUserResult> {

    private final AWSCognitoIdentityProvider identityProvider;

    public GetUser() {
        this(CognitoIdentityProviderFactory.createIdentityProvider());
    }

    public GetUser(AWSCognitoIdentityProvider identityProvider) {
        this.identityProvider = identityProvider;
    }

    @Override
    public GetUserResult perform(String token) {
        GetUserRequest getUserRequest = createGetUserRequest(token);
        return identityProvider.getUser(getUserRequest);
    }

    private GetUserRequest createGetUserRequest(String token) {
        return new GetUserRequest()
                .withAccessToken(token);
    }
}
