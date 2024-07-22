package org.example.githubclientasync.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.githubclientasync.dto.Repository;
import org.example.githubclientasync.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class GitHubApiService {
    @Value("${github.api.url}")
    private String githubApiUrl;
    @Value("${github.api.token}")
    private String githubApiToken;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GitHubApiService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    @Async("taskExecutor")
    public CompletableFuture<List<Repository>> getUserRepos(String username){
        System.out.println("getUserRepos 실행");
        return CompletableFuture.supplyAsync(()->{
            String url = githubApiUrl + "/users/"+username+"/repos";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization","Bearer "+githubApiToken);

            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            try {
                return objectMapper.readValue(response.getBody(), new TypeReference<List<Repository>>() {});
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

    }
    //getUserFollowers(String username)  --  /users/{username}/followers
    @Async("taskExecutor")
    public CompletableFuture<List<User>> getUserFollowers(String username){
        System.out.println("getUserFollowers 실행");
        return CompletableFuture.supplyAsync(()->{
            String url = githubApiUrl + "/users/" + username + "/followers";
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + githubApiToken);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            try {
                return objectMapper.readValue(response.getBody(), new TypeReference<List<User>>() {});
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    //getUserFollowing(String username)  -- /users/{username}/following
    @Async("taskExecutor")
    public CompletableFuture<List<User>> getUserFollowing(String username){
        System.out.println("getUserFollowing 실행");
        return CompletableFuture.supplyAsync(()->{
            String url = githubApiUrl + "/users/" + username + "/following";
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + githubApiToken);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            try {
                return objectMapper.readValue(response.getBody(), new TypeReference<List<User>>() {});
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
