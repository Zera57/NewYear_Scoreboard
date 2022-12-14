package com.Zera57.Application.Player;

import com.Zera57.Application.Player.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByName(String name);

    @Transactional
    @Modifying
    @Query("update Player p set p.score = p.score + ?2 where p.name = ?1")
    void addPoint(String name, int points);

    @Transactional
    @Modifying
    @Query("update Player p set p.score = p.score - 1 where p.name = ?1")
    void removePoint(String name);
}
