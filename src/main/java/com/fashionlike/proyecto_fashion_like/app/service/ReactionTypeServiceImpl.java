package com.fashionlike.proyecto_fashion_like.app.service;

import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.ReactionTypeRepository;
import com.fashionlike.proyecto_fashion_like.domain.port.service.ReactionTypeService;
import com.fashionlike.proyecto_fashion_like.domain.validators.reactions.ReactionTypeValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ReactionTypeServiceImpl implements ReactionTypeService {

    private final ReactionTypeRepository reactionTypeRepository;

    private final ReactionTypeValidator validator;


    @Override
    public ReactionType getById(Integer id) {


        return reactionTypeRepository.findById(id)
                .orElse(null)
                ;
    }

    @Override
    public List<ReactionType> getAll() {
        return reactionTypeRepository.findAll();
    }

    @Override
    public Integer create(ReactionType reactionType) {
        validator.validate(reactionType);
        return reactionTypeRepository.save(reactionType);
    }

    @Override
    public void update(Integer id, ReactionType reactionType) {
        ReactionType reactionTypeToEdit = this.getById(id);

        if (reactionTypeToEdit == null) {
            create(reactionType);
        } else {
            validator.validate(reactionType);

            reactionTypeToEdit.setEmoji(reactionType.getEmoji());
            reactionTypeToEdit.setName(reactionType.getName());

            reactionTypeRepository.save(reactionTypeToEdit);
        }
    }

    @Override
    public Boolean deleteById(Integer id) {
        reactionTypeRepository.deleteById(id);
        return true;
    }
}
