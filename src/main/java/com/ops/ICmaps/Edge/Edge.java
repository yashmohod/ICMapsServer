package com.ops.ICmaps.Edge;

import com.ops.ICmaps.Node.Node;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "edges", indexes = {
        @Index(name = "idx_edges_from", columnList = "from_node_id"),
        @Index(name = "idx_edges_to", columnList = "to_node_id")
})
public class Edge {

    @Id
    private String key;

    // "One edge points to 2 nodes" === two @ManyToOne associations
    @ManyToOne(optional = false)
    @JoinColumn(name = "from_node_id", nullable = false, foreignKey = @ForeignKey(name = "fk_edge_from_node"))
    private Node fromNode;

    @ManyToOne(optional = false)
    @JoinColumn(name = "to_node_id", nullable = false, foreignKey = @ForeignKey(name = "fk_edge_to_node"))
    private Node toNode;

    // any metadata: distance in meters, cost, speed limit, etc.
    private double distanceMeters;

    protected Edge() {

    }

    public Edge(double distanceMeters, Node toNode, Node fromNode, String key) {
        this.distanceMeters = distanceMeters;
        this.toNode = toNode;
        this.fromNode = fromNode;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public Node getFromNode() {
        return fromNode;
    }

    public void setFromNode(Node fromNode) {
        this.fromNode = fromNode;
    }

    public Node getToNode() {
        return toNode;
    }

    public void setToNode(Node toNode) {
        this.toNode = toNode;
    }

    public double getDistanceMeters() {
        return distanceMeters;
    }

    public void setDistanceMeters(double distanceMeters) {
        this.distanceMeters = distanceMeters;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Double.compare(distanceMeters, edge.distanceMeters) == 0 && Objects.equals(key, edge.key) && Objects.equals(fromNode, edge.fromNode) && Objects.equals(toNode, edge.toNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, fromNode, toNode, distanceMeters);
    }
}
