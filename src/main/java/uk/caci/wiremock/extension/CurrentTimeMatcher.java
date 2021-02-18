package uk.caci.wiremock.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.matching.MatchResult;
import com.github.tomakehurst.wiremock.matching.RequestMatcherExtension;

public class CurrentTimeMatcher extends RequestMatcherExtension {

    @Override
    public String getName() {
        return "current-time";
    }

    @Override
    public MatchResult match(Request value, Parameters parameters) {
        String timeRegex = parameters.getString("matches");
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        return MatchResult.of(currentTime.matches(timeRegex));
    }

}
