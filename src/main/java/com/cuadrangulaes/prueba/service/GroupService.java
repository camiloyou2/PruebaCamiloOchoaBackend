
package com.cuadrangulaes.prueba.service;

import java.util.List;

import com.cuadrangulaes.prueba.dto.GroupDto;
import com.cuadrangulaes.prueba.dto.MatchDto;

public interface GroupService {
    

	String performDraw();
    List<GroupDto> getAll();
}

