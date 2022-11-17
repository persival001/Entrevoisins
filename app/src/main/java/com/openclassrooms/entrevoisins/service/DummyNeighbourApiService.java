package com.openclassrooms.entrevoisins.service;

import android.widget.Toast;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.FavoritesFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

    private final List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private final List<Neighbour> favoritesNeighbours = new ArrayList<>();

    // Return list of neighbours
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    // Delete a neighbour
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    // Add a neighbour
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    // Create an empty list and add favorite neighbours
    @Override
    public List<Neighbour> getFavoritesNeighbours() {
        favoritesNeighbours.clear();
        for (Neighbour neighbour : neighbours) {
            if (neighbour.getIsFavorite()) {
                favoritesNeighbours.add(neighbour);
            }
        }
        return favoritesNeighbours;
    }

    // Add a favorite neighbour to list
    @Override
    public void addFavoriteNeighbour(long mId) {
        for (Neighbour neighbour : neighbours) {
            if (neighbour.getId() == mId) {
                neighbour.setIsFavorite(true);
            }
        }
    }

    // Delete a favorite neighbour
    @Override
    public void deleteFavoriteNeighbour(long mId) {
        for (Neighbour neighbour : neighbours) {
            if (neighbour.getId() == mId) {
                neighbour.setIsFavorite(false);
            }
        }
    }

    // Delete favorite neighbour of list
    @Override
    public void deleteFavoriteNeighbourToList(Neighbour neighbour) {
        favoritesNeighbours.remove(neighbour);
        neighbour.setIsFavorite(false);
    }
}