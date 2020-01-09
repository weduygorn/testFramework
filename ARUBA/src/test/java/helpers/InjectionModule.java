package helpers;


import com.google.inject.AbstractModule;

/**
 * Date: 7/24/2018
 * User: kondratiuk
 * Project: b2b-01
 */
public class InjectionModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(JsoupTransport.class);
    }
}
