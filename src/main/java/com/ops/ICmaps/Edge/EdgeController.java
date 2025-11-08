package com.ops.ICmaps.Edge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.util.Map;

@RestController
@RequestMapping("api/v1/edge")
public class EdgeController {

    private final EdgeRepository repository;
    private final ObjectMapper objectMapper;
    public EdgeController(EdgeRepository repository, ObjectMapper objectMapper){
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/add_update")
    public ObjectNode AddUpdateEdge(@RequestBody Map<String, String> params){
        ObjectNode objectNode = objectMapper.createObjectNode();
//        String respMessage = repository.findById()
//                .map(curEdge->{
//
//
//                    return "";
//                }).orElseGet(()->{
//
//                    return "";
//                });
        objectNode.put("message", "");
        return objectNode;
    }

}
