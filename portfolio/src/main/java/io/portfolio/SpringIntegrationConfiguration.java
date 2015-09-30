package io.portfolio;

import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.jpa.core.DefaultJpaOperations;
import org.springframework.integration.transformer.HeaderEnricher;
import org.springframework.integration.transformer.support.HeaderValueMessageProcessor;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.socket.messaging.StompSubProtocolHandler;

import io.portfolio.repo.Stock;
import io.portfolio.repo.StockRepository;

@Configuration
public class SpringIntegrationConfiguration {

	@Bean
	public HeaderEnricher headerEnricher() {
		return new HeaderEnricher(Collections.singletonMap(SimpMessageHeaderAccessor.SESSION_ID_HEADER, new HeaderValueMessageProcessor<String>() {

			@Override
			public String processMessage(Message<?> message) {
				return message.getPayload().toString();
			}

			@Override
			public Boolean isOverwrite() {
				return Boolean.TRUE;
			}
		}));
		// new
		// ExpressionEvaluatingHeaderValueMessageProcessor<Object>("payload",
		// null)));
	}

	@Bean
	public StompSubProtocolHandler stompSubProtocolHandler() {
		StompSubProtocolHandler handler = new StompSubProtocolHandler();
		return handler;
	}

	@Bean
	public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	@Bean
	public DefaultJpaOperations jpaOperations(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
		DefaultJpaOperations defaultJpaOperations = new DefaultJpaOperations();
		defaultJpaOperations.setEntityManager(entityManager);
		defaultJpaOperations.setEntityManagerFactory(entityManagerFactory);
		defaultJpaOperations.afterPropertiesSet();

		Stock stock = new Stock("test", 0);
		defaultJpaOperations.persist(stock);

		return defaultJpaOperations;
	}

	@Bean
	public Persister persister(StockRepository repository) {
		return new Persister(repository);
	}

	public static class Persister {
		private final StockRepository repository;

		public Persister(StockRepository repository) {
			this.repository = repository;
		}

		public Stock save(Stock stock) {
			return repository.save(stock);
		}
	}

}
