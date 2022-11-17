package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     *
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     *
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     *
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Add a favorite neighbour with Id
     *
     */
    void addFavoriteNeighbour(long mId);

    /**
     * Delete a favorite neighbour with Id
     *
     */
    void deleteFavoriteNeighbour(long mId);

    /**
     * Get only my favorites neighbour in this list
     *
     */
    List<Neighbour> getFavoritesNeighbours();

    // Delete a favorite neighbour
    void deleteFavoriteNeighbourToList(Neighbour neighbour);
}
