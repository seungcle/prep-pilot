package com.example.prep_pilot.service;

import com.example.prep_pilot.dto.ViewsDto;
import com.example.prep_pilot.entity.Posts;
import com.example.prep_pilot.entity.User;
import com.example.prep_pilot.entity.Views;
import com.example.prep_pilot.exception.PostsNotFoundException;
import com.example.prep_pilot.repository.PostsRepository;
import com.example.prep_pilot.repository.UserRepository;
import com.example.prep_pilot.repository.ViewsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ViewsService {

    private final ViewsRepository viewsRepository;
    private final UserRepository userRepository;
    private final PostsRepository postsRepository;

    public ViewsService(ViewsRepository viewsRepository, UserRepository userRepository, PostsRepository postsRepository){

        this.viewsRepository = viewsRepository;
        this.userRepository = userRepository;
        this.postsRepository = postsRepository;
    }

    @Transactional
    public ViewsDto getMyViews(String username, Long postsId) {

        User user = userRepository.findByUsername(username);
        Posts posts = postsRepository.findById(postsId).orElseThrow(() ->
                new PostsNotFoundException(postsId)
        );
        Optional<Views> v = viewsRepository.findByPostsIdAndUserUsername(postsId, username);

        if(v.isPresent()) {
            return null;
        }
        else {
            Views views = viewsRepository.save(new Views(null, posts, user, LocalDateTime.now()));
            return ViewsDto.toDto(views);
        }
    }
}
