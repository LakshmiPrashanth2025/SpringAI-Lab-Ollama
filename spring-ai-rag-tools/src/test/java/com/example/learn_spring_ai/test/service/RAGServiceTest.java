package com.example.learn_spring_ai.test.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.learn_spring_ai.service.RAGService;

@SpringBootTest
public class RAGServiceTest {

    @Autowired
    private RAGService ragService;

    @Test
    public void testIngest() {
        ragService.ingestVectorStore();
    }

    @Test
    public void testAskAI() {
        String res = ragService.askAI("Cant view the live class, what to do?");
        System.out.println(res);
    }

    @Test
    public void testAskAIWithAdvisor() {
        String res = ragService.askAIWithAdvisors("What are your views on ModiJi?", "rohit456");
        System.out.println(res);
    }


}
