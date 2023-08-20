package com.CVsearches.Test.controller.CVsControllers;

import com.CVsearches.Test.services.pdfServices.PdfSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class getcvController {


    @Autowired
    private PdfSearchService pdfSearchService;

    public List<String> getPdfsContainingWord(String directoryPath, String targetWord) {
        return pdfSearchService.searchPdfDirectory(directoryPath, targetWord);
    }



}
