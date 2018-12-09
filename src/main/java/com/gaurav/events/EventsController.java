package com.gaurav.events;

import com.gaurav.github.GitHubClient;
import com.gaurav.github.RepositoryEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventsController {

    private final GitHubProjectRepository repository;

    private final GitHubClient gitHubClient;

    public EventsController(GitHubProjectRepository repository, GitHubClient gitHubClient) {
        this.repository = repository;
        this.gitHubClient = gitHubClient;
    }

    @GetMapping("/events/{repoName}")
    @ResponseBody
    public RepositoryEvent[] fetchEvents(@PathVariable String repoName) {
        GitHubProject project = this.repository.findByReopName(repoName);
        return this.gitHubClient.fetchEvents(project.getOrgName(), project.getReopName()).getBody();
    }
}
