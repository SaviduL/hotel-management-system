package com.hotelmanagement.repository;

import com.hotelmanagement.entity.UserLoginRecord;
import com.hotelmanagement.entity.UserLoginRecordId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRecordRepository extends JpaRepository<UserLoginRecord, UserLoginRecordId> {
}