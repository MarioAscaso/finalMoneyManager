package com.daw.finalmoneymanager.newmovement.domain;

import com.daw.finalmoneymanager.newmovement.application.NewMovementRequest;
import com.daw.finalmoneymanager.shared.domain.Movement;
import com.daw.finalmoneymanager.shared.domain.MovementRepository;
import com.daw.finalmoneymanager.shared.storagefiles.domain.interfaces.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NewMovementUseCase {

    private final MovementRepository movementRepository;
    private final StorageService storageService;

    public NewMovementUseCase(MovementRepository movementRepository, StorageService storageService) {
        this.movementRepository = movementRepository;
        this.storageService = storageService;
    }

    public void execute(NewMovementRequest request) {

        String filename = null;

        MultipartFile file = request.getImage();
        if (file != null && !file.isEmpty()) {
            storageService.store(file);
            filename = file.getOriginalFilename();
        }

        Movement movement = new Movement(
                request.getConcept(),
                request.getAmount(),
                request.getDate(),
                request.getType(),
                filename
        );

        movementRepository.save(movement);
    }
}