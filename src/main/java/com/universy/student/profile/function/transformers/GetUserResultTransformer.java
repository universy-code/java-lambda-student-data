package com.universy.student.profile.function.transformers;

import com.amazonaws.services.cognitoidp.model.AttributeType;
import com.amazonaws.services.cognitoidp.model.GetUserResult;
import com.universy.student.profile.cognito.Attributes;
import com.universy.student.profile.function.transformers.exceptions.MissingAttributesException;
import com.universy.student.profile.model.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GetUserResultTransformer {

    public Student transform(GetUserResult getUserResult) {
        Map<String, String> attributes = getUserResult.getUserAttributes()
                .stream()
                .collect(Collectors.toMap(
                        AttributeType::getName,
                        AttributeType::getValue
                ));

        String username = getUserResult.getUsername();

        String givenName = Optional.ofNullable(attributes.get(Attributes.GIVEN_NAME_ATTRIBUTE))
                .orElseThrow(MissingAttributesException::new);

        String familyName = Optional.ofNullable(attributes.get(Attributes.FAMILY_NAME_ATTRIBUTE))
                .orElseThrow(MissingAttributesException::new);

        String email = Optional.ofNullable(attributes.get(Attributes.EMAIL_ATTRIBUTE))
                .orElseThrow(MissingAttributesException::new);

        return new Student(username, givenName, familyName, email);
    }

}
