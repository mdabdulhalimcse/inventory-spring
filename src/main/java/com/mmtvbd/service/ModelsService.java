package com.mmtvbd.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mmtvbd.entity.Models;

import java.util.List;

public interface ModelsService {
     String modelsUpdate(ObjectNode objectNode);
    String modelsSave(ObjectNode objectNode,Models models);
}
