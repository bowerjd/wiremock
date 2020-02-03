package com.github.tomakehurst.wiremock.extension.responsetemplating.helpers;

import java.io.IOException;

import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.helper.EachHelper;

/**
 * A custom helper to take a json path and iterate through each of the json elements of that path.
 * Essentially this combines the JsonPath helper from standard wiremock to get the json
 * and then uses the standard Each helper to iterate through the elements
 */
public class HandlebarsForEachJsonHelper extends HandlebarsHelper<String> {

    @Override
    public Object apply(final String jsonString, final Options options) throws IOException {
        HandlebarsJsonPathHelper jsonHelper = new HandlebarsJsonPathHelper();
        Object jsonObject = jsonHelper.apply(jsonString, options);
        EachHelper eachHelper = new EachHelper();
        return eachHelper.apply(jsonObject, options);
    }
}