package com.e.model.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
@Slf4j
public class AiChatService {

	private final ChatModel chatModel;

	public Flux<String> generateMovieTxtVal(String q) {
        return chatModel.stream(q)
                .doOnNext(content -> {
                    System.out.println("Streaming chunk: " + content);
                    log.info("Streaming content: {}", content);
                })
                .doOnComplete(() -> System.out.println("Stream completed"))
                .doOnError(error -> System.err.println("Stream error: " + error.getMessage()));
    }

}
