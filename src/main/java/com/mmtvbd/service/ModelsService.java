package com.mmtvbd.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mmtvbd.entity.Models;

import java.util.List;

public interface ModelsService {
    List<Models> modelsUpdate(ObjectNode objectNode);
    List<Models> modelsSave(ObjectNode objectNode,Models models);
}
