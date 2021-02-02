package com.ivoronline.springboot_relationships_onetoone_jointable.controllers;

import com.ivoronline.springboot_relationships_onetoone_jointable.entities.Author;
import com.ivoronline.springboot_relationships_onetoone_jointable.entities.Address;
import com.ivoronline.springboot_relationships_onetoone_jointable.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

  @Autowired
  AuthorRepository  authorRepository;

  @ResponseBody
  @RequestMapping("/addAuthor")
  public String addAuthor() {

    //CREATE ADDRESS ENTITY
    Address address = new Address();
                  address.city   = "London";
                  address.street = "Piccadilly";

    //CREATE AUTHOR ENTITY
    Author author = new Author();
                  author.name    = "John";
                  author.age     = 20;
                  author.address = address;

    //STORE AUTHOR/ADDRESS ENTITY INTO DB
    authorRepository.save(author);

    //RETURN SOMETHING TO BROWSER
    return "Author/Address was stored into DB";

  }

}
