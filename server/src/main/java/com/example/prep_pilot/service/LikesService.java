package com.example.prep_pilot.service;

import com.example.prep_pilot.entity.Likes;
import com.example.prep_pilot.entity.Posts;
import com.example.prep_pilot.entity.User;
import com.example.prep_pilot.exception.PostsNotFoundException;
import com.example.prep_pilot.repository.LikesRepository;
import com.example.prep_pilot.repository.PostsRepository;
import com.example.prep_pilot.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LikesService {

    private final LikesRepository likesRepository;
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    public LikesService(LikesRepository likesRepository, PostsRepository postsRepository, UserRepository userRepository){

        this.likesRepository = likesRepository;
        this.postsRepository = postsRepository;
        this.userRepository = userRepository;
    }

    public Long getLikesNum(Long postsId) {

        return likesRepository.countByPostsId(postsId);
    }

    @Transactional
    public Long pushLikes(String username, Long postsId) {

        User user = userRepository.findByUsername(username);
        Posts posts = postsRepository.findById(postsId).orElseThrow(() ->
                new PostsNotFoundException(postsId)
        );
        Optional<Likes> like = likesRepository.findByPostsAndUser(posts, user);

        if(like.isPresent())
            likesRepository.delete(like.get());
        else
            likesRepository.save(new Likes(null, posts, user, LocalDateTime.now()));

        return getLikesNum(postsId);
    }
}
