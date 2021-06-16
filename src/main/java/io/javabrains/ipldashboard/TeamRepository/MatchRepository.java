package io.javabrains.ipldashboard.TeamRepository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import io.javabrains.ipldashboard.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long>{


    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teanName2,Pageable pageable);

    default List<Match> findLatestMatchesByTeam(String teamName, int count){
       return this.getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}
