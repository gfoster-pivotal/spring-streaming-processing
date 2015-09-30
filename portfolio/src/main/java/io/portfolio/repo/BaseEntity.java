package io.portfolio.repo;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
public class BaseEntity {
	protected long createdTimestamp;
}
