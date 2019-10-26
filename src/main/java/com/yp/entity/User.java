package com.yp.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
public class User  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String username;

	private String password;

	private String salt;

	private String name;

	private java.util.Date created;

	private java.util.Date updated;

}
