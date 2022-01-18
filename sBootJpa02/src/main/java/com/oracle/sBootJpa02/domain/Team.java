package com.oracle.sBootJpa02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@SequenceGenerator(
		name = "team_seq_generator",
		sequenceName = "team_seq_generator",   //  DB 시퀀스 이름
		initialValue = 1,
		allocationSize = 1
		)
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "team_seq_generator"	
			)
	private Long    team_id;
	@Column(name = "teamname")
	private String  name;
	
}
