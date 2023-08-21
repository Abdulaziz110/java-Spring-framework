package com.CVsearches.Test.services.pdfServices;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class PdfSearchService {
    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();
    private static final int CHUNK_SIZE = 100000;  // Number of characters per chunk
    public List<String> searchPdfDirectory(String directoryPath, String targetWord) {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directoryPath + " is not a directory.");
        }
        File[] pdfFiles = directory.listFiles(file -> file.getName().toLowerCase().endsWith(".pdf"));
        if (pdfFiles == null) {
            return new ArrayList<>();
        }
        List<String> pdfsWithWord = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (File pdfFile : pdfFiles) {
            executorService.submit(() -> {
                if (searchWordInPdf(pdfFile, targetWord)) {
                    pdfsWithWord.add(pdfFile.getName());
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pdfsWithWord;
    }
    private boolean searchWordInPdf(File pdfFile, String targetWord) {
        try (PDDocument document = PDDocument.load(pdfFile)) {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            int numPages = document.getNumberOfPages();
            StringBuilder chunkText = new StringBuilder();
            for (int pageNum = 1; pageNum <= numPages; pageNum++) {
                pdfTextStripper.setStartPage(pageNum);
                pdfTextStripper.setEndPage(pageNum);
                String pageText = pdfTextStripper.getText(document);
                chunkText.append(pageText);
                if (chunkText.length() >= CHUNK_SIZE || pageNum == numPages) {
                    if (chunkText.toString().toLowerCase().contains(targetWord.toLowerCase())) {
                        return true;
                    }
                    chunkText.setLength(0);
                }
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}
