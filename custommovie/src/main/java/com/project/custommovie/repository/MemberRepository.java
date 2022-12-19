package com.project.custommovie.repository;

import com.project.custommovie.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //아이디로 회원 정보 조회(select * from user_member where member_id=?)
    Optional<MemberEntity> findByMemberid(String memberid);

}
