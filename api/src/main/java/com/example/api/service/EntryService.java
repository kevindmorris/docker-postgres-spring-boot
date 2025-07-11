package com.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.Entry;
import com.example.api.repository.EntryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    public Entry save(Entry entry) {
        return entryRepository.save(entry);
    }

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    public Entry findById(Long id) {
        return entryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entry not found with id: " + id));
    }

    public Entry update(Long id, Entry updatedEntry) {
        Entry existingEntry = entryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entry not found with id: " + id));

        existingEntry.setTitle(updatedEntry.getTitle());
        existingEntry.setContent(updatedEntry.getContent());

        return entryRepository.save(existingEntry);
    }

    public Entry updateTitle(Long id, String updatedTitle) {
        Entry existingEntry = entryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entry not found with id: " + id));

        existingEntry.setTitle(updatedTitle);

        return entryRepository.save(existingEntry);
    }

    public Entry updateContent(Long id, String updatedContent) {
        Entry existingEntry = entryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entry not found with id: " + id));

        existingEntry.setContent(updatedContent);

        return entryRepository.save(existingEntry);
    }

    public void deleteById(Long id) {
        if (!entryRepository.existsById(id)) {
            throw new EntityNotFoundException("Entry not found with id: " + id);
        }

        entryRepository.deleteById(id);
    }

}