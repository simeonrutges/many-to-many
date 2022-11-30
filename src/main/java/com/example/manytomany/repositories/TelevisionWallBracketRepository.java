package com.example.manytomany.repositories;

import com.example.manytomany.models.TelevisionWallBracket;
import com.example.manytomany.models.TelevisionWallBracketKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TelevisionWallBracketRepository extends JpaRepository<TelevisionWallBracket, TelevisionWallBracketKey> {
    Collection<TelevisionWallBracket> findAllByTelevisionId(Long televisionId);
    Collection<TelevisionWallBracket> findAllByWallBracketId(Long wallBracketId);
}
