package com.springtask.springtask.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(nullable = false ,unique = true)
private  String email;
@Column(nullable = false)
private String password;

@Column(nullable = false)
private String gender;




}
