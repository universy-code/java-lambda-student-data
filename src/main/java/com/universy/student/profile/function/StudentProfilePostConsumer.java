package com.universy.student.profile.function;

import com.amazonaws.services.cognitoidp.model.NotAuthorizedException;
import com.amazonaws.services.cognitoidp.model.UpdateUserAttributesResult;
import com.universy.cognito.actions.CognitoAction;
import com.universy.lambda.api.handlers.context.Contextualized;
import com.universy.student.profile.cognito.UpdateUserAttributes;
import com.universy.student.profile.function.exceptions.OperationNotAuthorizedException;
import com.universy.student.profile.function.extractor.AccessTokenExtractor;
import com.universy.student.profile.model.Student;
import com.universy.student.profile.model.UpdateAttributesParameters;

import java.util.function.Consumer;

public class StudentProfilePostConsumer extends Contextualized implements Consumer<Student> {

    private final CognitoAction<UpdateAttributesParameters, UpdateUserAttributesResult> updateUserAttributes;

    public StudentProfilePostConsumer() {
        this(new UpdateUserAttributes());
    }

    public StudentProfilePostConsumer(CognitoAction<UpdateAttributesParameters, UpdateUserAttributesResult> updateUserAttributes) {
        this.updateUserAttributes = updateUserAttributes;
    }

    @Override
    public void accept(Student student) {

        try {
            UpdateAttributesParameters parameters = transformWithToken(student);
            updateUserAttributes.perform(parameters);

        } catch (NotAuthorizedException e) {
            throw new OperationNotAuthorizedException();
        }
    }

    private UpdateAttributesParameters transformWithToken(Student student) {
        AccessTokenExtractor accessTokenExtractor = new AccessTokenExtractor();
        String accessTokenValue = accessTokenExtractor.getAccessTokenString(getApiContext());
        return new UpdateAttributesParameters(
                accessTokenValue,
                student.getGivenName(),
                student.getFamilyName(),
                student.getEmail()
        );
    }
}
