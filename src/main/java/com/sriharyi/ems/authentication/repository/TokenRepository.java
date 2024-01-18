package com.sriharyi.ems.authentication.repository;

import com.sriharyi.ems.authentication.modal.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
    @Query(value = """
      select t from tokens t inner join users u \s
      on t.user.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findActiveTokensByUserId(Integer id);



    Optional<Token> findByToken(String token);
}
