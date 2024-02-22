package com.example.tdd_study.mail.domain.repository;

import com.example.tdd_study.mail.domain.entity.MailSendHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailSendHistoryRepository extends JpaRepository<MailSendHistory, Long> {
}
