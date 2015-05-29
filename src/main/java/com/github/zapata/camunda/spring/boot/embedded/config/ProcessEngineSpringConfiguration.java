package com.github.zapata.camunda.spring.boot.embedded.config;

import java.io.IOException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.camunda.bpm.engine.AuthorizationService;
import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.spring.ProcessEngineFactoryBean;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ProcessEngineSpringConfiguration {

	@Inject
	private DataSource dataSource;

	@Inject
	private PlatformTransactionManager transactionManager;

	@Inject
	private ResourcePatternResolver resourceResolver;

	@Bean
	public ProcessEngineConfigurationImpl processEngineConfiguration() {
		SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
		config.setDataSource(dataSource);
		config.setTransactionManager(transactionManager);
		config.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		config.setJobExecutorActivate(false);
		try {
			config.setDeploymentResources(resourceResolver
					.getResources("classpath*:*.bpmn"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return config;
	}

	@Bean(destroyMethod = "destroy")
	public ProcessEngineFactoryBean processEngineFactory() {
		ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
		processEngineFactoryBean
				.setProcessEngineConfiguration(processEngineConfiguration());
		return processEngineFactoryBean;
	}

	public ProcessEngine processEngine() {
		try {
			return processEngineFactory().getObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Bean
	public RuntimeService runtimeService() {
		return processEngine().getRuntimeService();
	}

	@Bean
	public AuthorizationService authorizationService() {
		return processEngine().getAuthorizationService();
	}

	@Bean
	public FormService formService() {
		return processEngine().getFormService();
	}

	@Bean
	public HistoryService historyService() {
		return processEngine().getHistoryService();
	}

	@Bean
	public IdentityService identityService() {
		return processEngine().getIdentityService();
	}

	@Bean
	public ManagementService managementService() {
		return processEngine().getManagementService();
	}

	@Bean
	public RepositoryService repositoryService() {
		return processEngine().getRepositoryService();
	}

	@Bean
	public TaskService taskService() {
		return processEngine().getTaskService();
	}

}
