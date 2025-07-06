package com.rentvideo.RentalVideoSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rentvideo.RentalVideoSystem.model.Video;
import com.rentvideo.RentalVideoSystem.repository.VideoRepository;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }

    public ResponseEntity<Video> createVideo(Video video) {
        return ResponseEntity.ok(videoRepository.save(video));
    }

    public void deleteVideo(Long id) {
        if (!videoRepository.existsById(id)) {
            throw new RuntimeException("Video not found");
        }
        videoRepository.deleteById(id);
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video updateVideo(Long id, Video updatedVideo) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        video.setTitle(updatedVideo.getTitle());
        video.setDirector(updatedVideo.getDirector());
        video.setGenre(updatedVideo.getGenre());
        video.setAvailability(updatedVideo.getAvailability());

        return videoRepository.save(video);

    }

}
