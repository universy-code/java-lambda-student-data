package app.universy.student.profile;

import app.universy.lambda.apigw.handler.ProxyEventHandler;
import app.universy.lambda.apigw.handler.StreamAPIGatewayHandler;
import app.universy.lambda.apigw.handler.dispatcher.HandlerDispatcherBuilder;
import app.universy.student.profile.function.StudentProfileGetSupplier;
import app.universy.student.profile.function.StudentProfilePostConsumer;

public class Handler extends StreamAPIGatewayHandler {

    @Override
    protected ProxyEventHandler getProxyEventHandler() {
        return new HandlerDispatcherBuilder()
                .withHandlers(
                        new StudentProfileGetSupplier(),
                        new StudentProfilePostConsumer()
                ).build();
    }
}
