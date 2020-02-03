package uk.caci.wiremock.extension;

import com.github.tomakehurst.wiremock.extension.requestfilter.RequestFilterAction;
import com.github.tomakehurst.wiremock.extension.requestfilter.RequestWrapper;
import com.github.tomakehurst.wiremock.extension.requestfilter.StubRequestFilter;
import com.github.tomakehurst.wiremock.http.Body;
import com.github.tomakehurst.wiremock.http.Request;

/**
 * Scalable only accepts requests of the format
 *
 * request=<actual request json>
 *
 * This filter is used to strip out the 'request=' so that we can perform
 * the usual json matching on the request body.
 *
 */
public class ScalableOrderAPIRequestModifyingFilter extends StubRequestFilter {

    @Override
    public RequestFilterAction filter(Request request) {
        Request wrappedRequest = RequestWrapper.create().transformBody(body -> {
            String original = body.asString();
            String newBody = original.replace("request=", "");
            return new Body(newBody);
        }).wrap(request);

        return RequestFilterAction.continueWith(wrappedRequest);
    }

    @Override
    public String getName() {
        return "scalable-order-api-request-modifier";
    }

}
