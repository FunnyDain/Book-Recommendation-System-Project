package com.project.custommovie.entity;

import com.project.custommovie.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user_member")
public class MemberEntity {
    @Id //PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long id;

    @Column(unique = true)
    private String memberid;

    @Column
    private String memberpassword;

    @Column
    private String memberpasswordCheck;

    @Column
    private int memberbirthday;

    @Column(unique = true) // unique 제약 추가
    private String memberemail;

    @Column
    private String membernickname;

    @Column
    private String membermbti;



    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberid(memberDTO.getMemberid());
        memberEntity.setMemberpassword(memberDTO.getMemberpassword());
        memberEntity.setMemberpasswordCheck(memberDTO.getMemberpasswordCheck());
        memberEntity.setMemberbirthday(memberDTO.getMemberbirthday());
        memberEntity.setMemberemail(memberDTO.getMemberemail());
        memberEntity.setMembernickname((memberDTO.getMembernickname()));
        memberEntity.setMembermbti(memberDTO.getMembermbti());

        return memberEntity;

    }
}
