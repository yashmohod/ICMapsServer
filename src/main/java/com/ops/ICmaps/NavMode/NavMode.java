package com.ops.ICmaps.NavMode;


import com.ops.ICmaps.Edge.Edge;
import com.ops.ICmaps.Node.Node;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "navmode")
public class NavMode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    @ManyToMany
    @JoinTable(
            name = "node_navmode",
            joinColumns = @JoinColumn(name = "navmode_id"),
            inverseJoinColumns = @JoinColumn(name = "node_id"))
    Set<Node> nodes;

    @ManyToMany
    @JoinTable(
            name = "edge_navmode",
            joinColumns = @JoinColumn(name = "navmode_id"),
            inverseJoinColumns = @JoinColumn(name = "edge_id"))
    Set<Edge> edges;



}
