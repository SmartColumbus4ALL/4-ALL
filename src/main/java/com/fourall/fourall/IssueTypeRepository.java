package com.fourall.fourall;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface IssueTypeRepository extends CrudRepository<IssueType, Long> {
	Iterable<IssueType> findAllByIssueCategory(String issueCategory);

	Iterable<IssueType> findAllByIssueEnvironment(String issueEnviroment);

	// Collection<? extends IssueType>
	// findAllByIssueEnvironmentAndIssueCategory(String issueEnvironment,
	// String issueCategory);

	Collection<? extends IssueType> findAllByIssueEnvironmentAndIssueCategoryAllIgnoreCase(String issueEnvironment,
			String issueCategory);
}
