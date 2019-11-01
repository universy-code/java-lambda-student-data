package app.universy.student.profile.function;

import app.universy.lambda.apigw.context.Contextualized;
import app.universy.lambda.apigw.handler.APIHandler;
import app.universy.lambda.apigw.handler.APIMethod;
import app.universy.student.profile.cognito.UpdateUserAttributes;
import app.universy.student.profile.function.exceptions.OperationNotAuthorizedException;
import app.universy.student.profile.function.extractor.AccessTokenExtractor;
import app.universy.student.profile.model.Student;
import app.universy.student.profile.model.UpdateAttributesParameters;
import com.amazonaws.services.cognitoidp.model.NotAuthorizedException;
import com.amazonaws.services.cognitoidp.model.UpdateUserAttributesResult;
import com.universy.cognito.actions.CognitoAction;

import java.util.function.Consumer;

@APIHandler(method = APIMethod.POST)
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
