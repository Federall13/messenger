package com.example.messenger.messenger.Lissener;

import com.example.messenger.messenger.model.Post;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

public class PostEvent extends ApplicationEvent {
    @Getter
    private String eventTipe;
    @Getter
    private Post post;


//    public PostEvent(Object source) {
//        super(source);
//    }

    public PostEvent(Object source, String eventTipe, Post post) {
        super(source);
        this.eventTipe = eventTipe;
        this.post = post;
    }


}
