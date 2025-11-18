package com.daw.finalmoneymanager.shared.storagefiles.infrastructure.controller;

import com.daw.finalmoneymanager.shared.storagefiles.domain.interfaces.StorageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FilesController {

    private final StorageService storageService;

    public FilesController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        storageService.store(file);
        return "redirect:/";

    }

}
