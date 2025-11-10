package com.ops.ICmaps.Buildings;

import com.ops.ICmaps.Node.Node;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "node_building",
            joinColumns = @JoinColumn(name = "building_id"),
            inverseJoinColumns = @JoinColumn(name = "node_id"))
    Set<Node> nodes;

    protected Building() {
    }

    public Building(String name) {
        this.name = name;
    }

    public Building(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Node> getNodes() {
        return this.nodes;
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public void removeNode(Node node) {
        this.nodes.remove(node);
    }

}
