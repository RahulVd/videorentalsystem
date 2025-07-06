package com.rentvideo.RentalVideoSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentvideo.RentalVideoSystem.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
