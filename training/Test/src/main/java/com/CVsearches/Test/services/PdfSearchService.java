package com.CVsearches.Test.services;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfSearchService {

    public List<String> getPdfsContainingWord(String directoryPath, String targetWord) {
        File directory = new File(directoryPath);

        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directoryPath + " is not a directory.");
        }

        File[] pdfFiles = directory.listFiles(file -> file.getName().endsWith(".pdf"));

        if (pdfFiles == null) {
            return new ArrayList<>();
        }

        List<String> pdfsWithWord = new ArrayList<>();
        for (File pdfFile : pdfFiles) {
            if (searchWordInPdf(pdfFile, targetWord)) {
                pdfsWithWord.add(pdfFile.getName());
            }
        }

        return pdfsWithWord;
    }

    private boolean searchWordInPdf(File pdfFile, String targetWord) {
        try (PDDocument document = PDDocument.load(pdfFile)) {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String pdfContent = pdfTextStripper.getText(document);

            return pdfContent.contains(targetWord);
        } catch (IOException e) {

            return false;
        }
    }
}
