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
    private Double lat;
    private Double lng;


    @ManyToMany
    @JoinTable(
            name = "node_building",
            joinColumns = @JoinColumn(name = "building_id"),
            inverseJoinColumns = @JoinColumn(name = "node_id"))
    Set<Node> nodes;



}
