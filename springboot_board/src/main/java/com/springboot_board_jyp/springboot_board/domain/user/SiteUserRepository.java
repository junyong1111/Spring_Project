package com.springboot_board_jyp.springboot_board.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long>{
    
}
