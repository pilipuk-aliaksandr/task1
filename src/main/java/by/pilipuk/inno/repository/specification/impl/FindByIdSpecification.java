package by.pilipuk.inno.repository.specification.impl;

import by.pilipuk.inno.entity.CustomArray;
import by.pilipuk.inno.repository.specification.Specification;

public class FindByIdSpecification implements Specification {
    private Long id;

    public FindByIdSpecification(Long id) {
        this.id = id;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        return customArray.getId().equals(id);
    }
}
