package com.form105.rm.base.model.user;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author heiko
 */
@Entity(name = "SystemUser")
public class User implements Serializable {

  @Id
  private Integer id;
  private String name;
  private String sirName;
  private String eMail;
}