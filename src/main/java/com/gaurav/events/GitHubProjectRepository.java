package com.gaurav.events;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface GitHubProjectRepository extends PagingAndSortingRepository<GitHubProject, Long> {

    GitHubProject findByReopName(String repoName);
}
