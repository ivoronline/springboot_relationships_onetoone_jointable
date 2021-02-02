package com.ivoronline.springboot_relationships_onetoone_jointable.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  public String  name;
  public Integer age;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinTable(name = "AUTHOR_ADDRESS",
    joinColumns        = { @JoinColumn(name = "AUTHOR_ID" , referencedColumnName = "id") },
    inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "id") }
  )
  public Address address;

}









