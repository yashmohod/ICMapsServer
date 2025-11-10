package com.ops.ICmaps.Node;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("api/v1/node")
public class NodeController {

    private final NodeRepository repository;
    private final ObjectMapper objectMapper;

    public NodeController(NodeRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/add_update")
    public ObjectNode AddUpdateNode(@RequestBody Node newNode) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        String respMessage = repository.findById(newNode.getId())
                .map(curNode -> {
                    curNode.setLat(newNode.getLat());
                    curNode.setLng(newNode.getLng());
                    repository.save(curNode);
                    return "Node Updated!";
                })
                .orElseGet(() -> {
                    repository.save(newNode);
                    return "Node Added!";
                });

        objectNode.put("message", respMessage);
        return objectNode;
    }

    @DeleteMapping("/delete/{id}")
    public ObjectNode DeleteNode(@PathVariable String id) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        System.out.println(id);
        try {
            repository.deleteById(id);
            objectNode.put("message", "Node Deleted!");
            return objectNode;
        } catch (Exception e) {
            objectNode.put("message", e.getMessage());
            return objectNode;
        }

    }

}
