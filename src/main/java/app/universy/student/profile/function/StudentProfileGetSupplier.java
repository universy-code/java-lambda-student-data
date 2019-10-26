package app.universy.student.profile.function;

import app.universy.lambda.apigw.context.Contextualized;
import app.universy.lambda.apigw.handler.APIHandler;
import app.universy.lambda.apigw.handler.APIMethod;
import app.universy.student.profile.cognito.GetUser;
import com.amazonaws.services.cognitoidp.model.GetUserResult;
import com.amazonaws.services.cognitoidp.model.NotAuthorizedException;
import com.universy.cognito.actions.CognitoAction;
import app.universy.student.profile.function.exceptions.OperationNotAuthorizedException;
import app.universy.student.profile.function.extractor.AccessTokenExtractor;
import app.universy.student.profile.function.transformers.GetUserResultTransformer;
import app.universy.student.profile.model.Student;

import java.util.function.Supplier;

@APIHandler(method = APIMethod.GET)
public class StudentProfileGetSupplier extends Contextualized implements Supplier<Student> {

    private final CognitoAction<String, GetUserResult> getUserAction;

    public StudentProfileGetSupplier() {
        this(new GetUser());
    }

    public StudentProfileGetSupplier(CognitoAction<String, GetUserResult> getUserAction) {
        this.getUserAction = getUserAction;
    }

    @Override
    public Student get() {

        try {
            AccessTokenExtractor accessTokenExtractor = new AccessTokenExtractor();
            String accessTokenValue = accessTokenExtractor.getAccessTokenString(getApiContext());

            GetUserResult getUserResult = getUserAction.perform(accessTokenValue);

            GetUserResultTransformer getUserResultTransformer = new GetUserResultTransformer();
            return getUserResultTransformer.transform(getUserResult);
        } catch (NotAuthorizedException e) {
            throw new OperationNotAuthorizedException();
        }
    }
}



