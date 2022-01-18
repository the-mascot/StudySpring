package com.oracle.sBootApi01.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
@Entity
@SequenceGenerator(name = "member_seq_gen",
					sequenceName = "member_seq_generator", // 매필할 DB시퀸스 이름
					initialValue = 1,
					allocationSize = 1
				)
@Table(name = "member5" )
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "member_seq_gen")
	@Column(name = "member_id")
	private Long   id;
	@Column(name = "username", length = 100)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team	team;
	
	// Team ID
	@Transient
	private Long teamid;
	
	// 임시저장, Table Column X
	@Transient
	private String teamname;
}
