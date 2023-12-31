package com.Handball.Analyzer.controller.webfront;

import com.Handball.Analyzer.model.Settings;
import com.Handball.Analyzer.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/webfront/v1/settings")
public class SettingsController {
    @Autowired
    SettingsRepository settingsRepository;

    @PutMapping("/{settingsId}/language")
    public ResponseEntity<?> setLanguage(@PathVariable UUID settingsId, @RequestBody String language){
        try {
            Settings settings = settingsRepository.findById(settingsId).orElseThrow();
            settings.setLanguage(language);
            settingsRepository.save(settings);
            return ResponseEntity.ok(settings);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/{settingsId}/lightmode")
    public ResponseEntity<?> setColorMode(@PathVariable UUID settingsId, @RequestBody String colorMode){
        try {
            Settings settings = settingsRepository.findById(settingsId).orElseThrow();
            settings.setColor_mode(colorMode);
            settingsRepository.save(settings);
            return ResponseEntity.ok(settings);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/{settingsId}/theme")
    public ResponseEntity<?> setTheme(@PathVariable UUID settingsId, @RequestBody String theme){
        try {
            Settings settings = settingsRepository.findById(settingsId).orElseThrow();
            settings.setTheme(theme);
            settingsRepository.save(settings);
            return ResponseEntity.ok(settings);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
