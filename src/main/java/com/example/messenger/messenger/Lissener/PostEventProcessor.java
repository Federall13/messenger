package com.example.messenger.messenger.Lissener;

import org.springframework.context.ApplicationListener;

public class PostEventProcessor  implements ApplicationListener<PostEvent> {
    @Override
    public void onApplicationEvent(PostEvent postEvent) {
        System.out.println(postEvent.getEventTipe() + "POST EVENTY" + postEvent.getPost());
    }
}
