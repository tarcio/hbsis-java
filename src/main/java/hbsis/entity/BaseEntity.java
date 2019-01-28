package hbsis.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
