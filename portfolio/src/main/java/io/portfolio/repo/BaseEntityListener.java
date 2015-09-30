package io.portfolio.repo;

import javax.persistence.PrePersist;

public class BaseEntityListener {

	@PrePersist
	public void prePersist(BaseEntity baseEntity){
		baseEntity.createdTimestamp = System.currentTimeMillis();
	}
}
