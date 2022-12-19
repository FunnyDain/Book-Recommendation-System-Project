package com.project.custommovie.entity;

//metadata는 따로 다루기

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
    @CreationTimestamp     //생성되었을때, 시간 정보를 만들어주는
    @Column(updatable = false)      //수정시에는 관여는 안하겠다는
    private LocalDateTime createdTime;

    @UpdateTimestamp        //업데이트되었을때, 시간 정보를 만들어주는
    @Column(insertable = false)     //insert때는 관여를 안 하겠다는
    private LocalDateTime updateTime;


}
