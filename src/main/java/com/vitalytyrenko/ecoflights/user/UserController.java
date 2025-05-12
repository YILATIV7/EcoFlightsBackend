package com.vitalytyrenko.ecoflights.user;

import com.vitalytyrenko.ecoflights.auth.JwtService;
import com.vitalytyrenko.ecoflights.auth.UserRepository;
import com.vitalytyrenko.ecoflights.auth._models.Preference;
import com.vitalytyrenko.ecoflights.user._models.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @GetMapping("/me")
    public ResponseEntity<UserInfoResponse> getCurrentUser(@RequestHeader("Authorization") String tokenHeader) {
        String email = jwtService.extractEmailFromHeader(tokenHeader);

        return userRepository.findByEmail(email)
                .map(user -> {
                    String preference = user.getPreference() != null
                            ? user.getPreference().toString()
                            : "OPTIMAL";
                    return ResponseEntity.ok(new UserInfoResponse(user.getFullName(), user.getEmail(), preference));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/preference")
    public ResponseEntity<?> updatePreference(
            @RequestHeader("Authorization") String tokenHeader,
            @RequestBody Map<String, String> body
    ) {
        String email = jwtService.extractEmailFromHeader(tokenHeader);
        String pref = body.get("preference");

        return userRepository.findByEmail(email).map(user -> {
            user.setPreference(Preference.valueOf(pref.toUpperCase()));
            userRepository.save(user);
            return ResponseEntity.ok("Preference updated");
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"));
    }
}

