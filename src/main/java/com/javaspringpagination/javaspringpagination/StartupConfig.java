package com.javaspringpagination.javaspringpagination;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class StartupConfig implements CommandLineRunner {
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 20; i++) {
            Book book = new Book();
            book.setName("Kitap " + i);
            book.setCreatedAt(generateRandomDate()); // Rastgele bir oluşturulma tarihi atanıyor
            bookRepository.save(book);
        }
    }
    public Date generateRandomDate() {
        long offset = TimeUnit.DAYS.toMillis(new Random().nextInt(30)); // 30 gün içinde rastgele bir zaman dilimi
        return new Date(System.currentTimeMillis() - offset);
    }
}
