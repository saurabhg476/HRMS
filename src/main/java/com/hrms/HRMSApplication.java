package com.hrms;

import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

public class HRMSApplication extends Application<HRMSConfiguration> {

    private GuiceBundle<HRMSConfiguration> guiceBundle;

    public static void main(final String[] args) throws Exception {
        new HRMSApplication().run(args);
    }

    @Override
    public String getName() {
        return "HRMS";
    }

    @Override
    public void initialize(final Bootstrap<HRMSConfiguration> bootstrap) {
        guiceBundle = GuiceBundle.<HRMSConfiguration>newBuilder()
                .addModule(new HRMSModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(HRMSConfiguration.class)
                .build();
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(final HRMSConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(MultiPartFeature.class);
    }

}
