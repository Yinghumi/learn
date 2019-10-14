package edu.hubu.learn.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hugher")
@Data
public class Hugher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hughername;

    private String content;

    private String role;


    @Column(name="avatar_url")
    private String avatar;
    
	public void setAvatar(String string) {
	}
    
}
