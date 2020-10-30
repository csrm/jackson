package com.example.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public interface MapView {
    String getId();
    @JsonSerialize(as = PointView.class)
    Point getPoint();
}
