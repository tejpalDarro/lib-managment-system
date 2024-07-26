package com.phenol.services.mapper;

import com.phenol.bookservice.Entity.Books;
import com.phenol.bookservice.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookMapper {


    public BookDTO toDto(Books save) {
        BookDTO dto = new BookDTO();
        dto.setBookId(save.getBookId());
        dto.setAuthorName(save.getAuthorName());
        dto.setTitle(save.getTitle());
        dto.setPublicationDate(save.getPublicationDate());
        return dto;
    }

    public static BookDTO Dto(Books save) {
        BookDTO dto = new BookDTO();
        dto.setBookId(save.getBookId());
        dto.setAuthorName(save.getAuthorName());
        dto.setTitle(save.getTitle());
        dto.setPublicationDate(save.getPublicationDate());
        return dto;
    }

    public List<BookDTO> toListDto(List<Books> all) {
       return all.stream().map(BookMapper::Dto).toList();
    }
}
