package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user deletes a Neighbour
 */

public class DeleteFavoriteNeighbourEvent {

    /**
     * Neighbour to delete
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     */
    public DeleteFavoriteNeighbourEvent(Neighbour neighbour) {

        this.neighbour = neighbour;
    }
}
