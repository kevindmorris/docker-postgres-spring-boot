package com.example.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.dto.EntryDto;
import com.example.api.model.Entry;
import com.example.api.service.EntryService;

@RestController
@RequestMapping("/entries")
@CrossOrigin(origins = "*")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @PostMapping
    public EntryDto createEntry(@RequestBody EntryDto entryDto) {
        Entry entry = EntryDto.toEntity(entryDto);
        Entry saved = entryService.save(entry);
        return EntryDto.toDto(saved);
    }

    @GetMapping
    public List<EntryDto> getAllEntries() {
        return entryService.findAll().stream()
                .map(EntryDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EntryDto getEntryById(@PathVariable Long id) {
        return EntryDto.toDto(entryService.findById(id));
    }

    @PutMapping("/{id}")
    public EntryDto updateEntry(@PathVariable Long id, @RequestBody EntryDto entryDto) {
        Entry updatedEntry = EntryDto.toEntity(entryDto);
        Entry result = entryService.update(id, updatedEntry);
        return EntryDto.toDto(result);
    }

    @PatchMapping("/{id}/title")
    public EntryDto updateEntryTitle(@PathVariable Long id, @RequestBody String updatedTitle) {
        Entry result = entryService.updateTitle(id, updatedTitle);
        return EntryDto.toDto(result);
    }

    @PatchMapping("/{id}/content")
    public EntryDto updateEntryContent(@PathVariable Long id, @RequestBody String updatedContent) {
        Entry result = entryService.updateContent(id, updatedContent);
        return EntryDto.toDto(result);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        entryService.deleteById(id);
    }

}