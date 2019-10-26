package app.universy.student.profile.cognito;

import app.universy.student.profile.model.UpdateAttributesParameters;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.model.UpdateUserAttributesRequest;
import com.amazonaws.services.cognitoidp.model.UpdateUserAttributesResult;
import com.universy.cognito.CognitoIdentityProviderFactory;
import com.universy.cognito.actions.CognitoAction;
import app.universy.student.profile.builder.CognitoAttributeBuilder;

public class UpdateUserAttributes implements CognitoAction<UpdateAttributesParameters, UpdateUserAttributesResult> {

    private final AWSCognitoIdentityProvider identityProvider;

    public UpdateUserAttributes() {
        this(CognitoIdentityProviderFactory.createIdentityProvider());
    }

    public UpdateUserAttributes(AWSCognitoIdentityProvider identityProvider) {
        this.identityProvider = identityProvider;
    }

    @Override
    public UpdateUserAttributesResult perform(UpdateAttributesParameters params) {
        UpdateUserAttributesRequest updateUserAttributesRequest = createUpdateUserAttributesRequest(params);
        return identityProvider.updateUserAttributes(updateUserAttributesRequest);
    }

    private UpdateUserAttributesRequest createUpdateUserAttributesRequest(UpdateAttributesParameters params) {
        return new UpdateUserAttributesRequest()
                .withAccessToken(params.getAccessToken())
                .withUserAttributes(
                        new CognitoAttributeBuilder()
                                .withGivenName(params.getGivenName())
                                .withFamilyName(params.getFamilyName())
                                .build()
                );
    }


}
