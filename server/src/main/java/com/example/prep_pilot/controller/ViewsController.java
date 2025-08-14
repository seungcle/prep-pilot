package com.example.prep_pilot.controller;

import com.example.prep_pilot.dto.CustomUserDetails;
import com.example.prep_pilot.dto.ViewsDto;
import com.example.prep_pilot.service.ViewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class ViewsController {

    private final ViewsService viewsService;

    public ViewsController(ViewsService viewsService){

        this.viewsService = viewsService;
    }

    //
    @PostMapping("/{postsId}/views")
    public ResponseEntity<ViewsDto> getViews(@AuthenticationPrincipal CustomUserDetails userDetails,
                                             @PathVariable Long postsId){

        String username = userDetails.getUsername();
        ViewsDto viewsDto = viewsService.getMyViews(username, postsId);

        return ResponseEntity.status(HttpStatus.OK).body(viewsDto);
    }
}
