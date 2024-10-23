package com.example.seminar4.card.service;

import com.example.seminar4.card.dto.CardRequest;
import com.example.seminar4.card.entity.Card;
import com.example.seminar4.card.repository.CardRepository;
import com.example.seminar4.user.entity.User;
import com.example.seminar4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    public void CreateCard(CardRequest.CardCreateRequest req){
        Optional<User> u = userRepository.findById(req.getUserId());
        User user = u.get();

        Card card = Card.builder()
                .id(null)
                .name(req.getName())
                .user(user)
                .build();
        card.assignUser(user);
        cardRepository.save(card);
        userRepository.save(user);

    }
}
