package com.project.custommovie.dto;


import com.project.custommovie.entity.MemberEntity;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {

    private Long id;
    private String memberid;
    private String memberpassword;
    private String memberpasswordCheck;
    private String memberemail;
    private int memberbirthday;
    private String membernickname;
    private String membermbti;



    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberid(memberEntity.getMemberid());
        memberDTO.setMemberpassword(memberEntity.getMemberpassword());
        memberDTO.setMemberpasswordCheck(memberEntity.getMemberpasswordCheck());
        memberDTO.setMemberemail(memberEntity.getMemberemail());
        memberDTO.setMemberbirthday(memberEntity.getMemberbirthday());
        memberDTO.setMembernickname(memberEntity.getMembernickname());
        memberDTO.setMembermbti(memberEntity.getMembermbti());
        return memberDTO;
    }


}
