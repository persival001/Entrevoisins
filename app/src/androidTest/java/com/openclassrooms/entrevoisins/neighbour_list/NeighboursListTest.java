package com.openclassrooms.entrevoisins.neighbour_list;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;

import android.content.Intent;
import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ViewNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;


/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static final int ITEMS_COUNT = 12;

    public static void pressBack() {
        onView(isRoot()).perform(ViewActions.pressBack());
    }

    @Rule
    public ActivityScenarioRule<ListNeighbourActivity> mActivityRule =
            new ActivityScenarioRule<>(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        ActivityScenario<ListNeighbourActivity> activity = mActivityRule.getScenario();
        assertThat(activity, notNullValue());
        NeighbourApiService apiService = DI.getNewInstanceApiService();
    }

    /**
     * test verifying that when you click on an item in the list, the screen of
     * details is well underway
     */
    @Test
    public void myNeighboursList_clickItem_viewNeighbour() {
        onView(allOf(withId(R.id.list_neighbours), hasMinimumChildCount(11)))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.avatarImageView)).check(matches(isDisplayed()));
    }

    /**
     * test verifying that when the delete button is clicked, the list of users
     * has one less user
     *
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        onView(allOf(withId(R.id.list_neighbours), hasMinimumChildCount(11)))
                .check(withItemCount(ITEMS_COUNT));
        onView(allOf(withId(R.id.list_neighbours), hasMinimumChildCount(11)))
                .perform(actionOnItemAtPosition(1, new DeleteViewAction()));
        onView(allOf(withId(R.id.list_neighbours), hasMinimumChildCount(11)))
                .check(withItemCount(ITEMS_COUNT - 1));
    }


    /**
     * test verifying that the Favorites tab only shows neighbors marked as favorites.
     *
     */
    @Test
    public void myNeighboursList_favoriteTab_showsFavoritesNeighbours() {
        onView(allOf(withId(R.id.list_neighbours), hasMinimumChildCount(11)))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.favoriteFloatingActionButton)).perform(click());
        pressBack();
        onView(withId(R.id.list_favorites_neighbours))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     *
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {

        onView(allOf(withId(R.id.list_neighbours), hasMinimumChildCount(11)))
                .check(matches(hasMinimumChildCount(1)));

    }

}