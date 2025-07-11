package com.example.api.dto;

import java.time.Instant;

import com.example.api.model.Entry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntryDto {

    private Long id;
    private String title;
    private String content;
    private Instant createdOn;
    private Instant lastUpdate;

    public static EntryDto toDto(Entry entry) {
        return EntryDto.builder()
                .id(entry.getId())
                .title(entry.getTitle())
                .content(entry.getContent())
                .createdOn(entry.getCreatedOn())
                .lastUpdate(entry.getLastUpdate())
                .build();
    }

    public static Entry toEntity(EntryDto dto) {
        return Entry.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .createdOn(dto.getCreatedOn())
                .lastUpdate(dto.getLastUpdate())
                .build();
    }

}