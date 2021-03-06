package com.gaurav.github;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GitHubClient {

    private static final String EVENT_ISSUE_URL = "https://api.github.com/repos/{owner}/{repo}/issues/events";

    private final RestTemplate restTemplate;

    public GitHubClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<RepositoryEvent[]> fetchEvents(String orgName, String repoName) {
        return this.restTemplate.getForEntity(EVENT_ISSUE_URL, RepositoryEvent[].class, orgName, repoName);
    }

}
