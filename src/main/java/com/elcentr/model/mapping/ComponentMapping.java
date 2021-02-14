package com.elcentr.model.mapping;

import com.elcentr.model.Component;
import com.elcentr.model.Enclosure;
import com.elcentr.model.dto.ComponentDTO;

public class ComponentMapping {

    public static Component toModel(ComponentDTO componentDTO) {
        return Component.builder()
                .enclosure(Enclosure.builder()
                        .name(componentDTO.getEnclosureName())
                        .build())
                .amountEnclosure(componentDTO.getAmountEnclosure())
                .build();
    }

    public static ComponentDTO toDTO(Component component) {
        return ComponentDTO.builder()
                .amountEnclosure(component.getAmountEnclosure())
                .enclosureName(component.getEnclosure().getName())
                .build();
    }
}
