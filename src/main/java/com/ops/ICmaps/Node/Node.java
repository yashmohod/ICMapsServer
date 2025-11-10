package com.ops.ICmaps.Node;

import com.ops.ICmaps.Edge.Edge;
import com.ops.ICmaps.NavMode.NavMode;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "nodes", indexes = {
    @Index(name = "idx_nodes_lat_lng", columnList = "lat,lng")
})
public class Node {

    @Id
    private String id;
    private Double lat;
    private Double lng;

    @ManyToMany
    @JoinTable(
            name = "person_friends", // Name of the join table
            joinColumns = @JoinColumn(name = "person_id"), // Foreign key for this entity
            inverseJoinColumns = @JoinColumn(name = "friend_id") // Foreign key for the related entity (also Person)
    )
    private Set<Node> neighbours = new HashSet<>();

    @ManyToMany(mappedBy = "nodes")
    Set<NavMode> navModes;

    @ManyToMany(mappedBy = "nodes")
    Set<NavMode> buildings;

    protected Node() {
    }

    public Node(String id, Double lng, Double lat) {
        this.lng = lng;
        this.lat = lat;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return Objects.equals(id, node.id) && Objects.equals(lat, node.lat) && Objects.equals(lng, node.lng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lat, lng);
    }
}
