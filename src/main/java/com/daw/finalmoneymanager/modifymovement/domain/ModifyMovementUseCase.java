package com.daw.finalmoneymanager.modifymovement.domain;

import com.daw.finalmoneymanager.shared.domain.Movement;
import com.daw.finalmoneymanager.shared.domain.MovementRepository;
import com.daw.finalmoneymanager.shared.storagefiles.domain.interfaces.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ModifyMovementUseCase {

    private final MovementRepository movementRepository;
    private final StorageService storageService;

    public ModifyMovementUseCase(MovementRepository movementRepository, StorageService storageService) {
        this.movementRepository = movementRepository;
        this.storageService = storageService;
    }

    public void execute(Movement movement, MultipartFile image) {

        if (image != null && !image.isEmpty()) {
            storageService.store(image);
            movement.setImageName(image.getOriginalFilename());
        }
        movementRepository.save(movement);
    }
}