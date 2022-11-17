package com.openclassrooms.entrevoisins.neighbour_view;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.matchesRegex;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import android.content.Intent;
import android.os.Bundle;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ViewNeighbourActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test class for view of one neighbour
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursViewTest {

    private Intent createIntent () {
        final Intent intent = new Intent(InstrumentationRegistry.getInstrumentation().getTargetContext(), ViewNeighbourActivity.class);
        intent.putExtra("neighbour", new Neighbour(0,"test", "avatarUrl","address", "phoneNumber", "aboutMe", false));
        return intent;
    }

    @Rule
    public final ActivityScenarioRule<ViewNeighbourActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(createIntent());

    /**
     * Check if the picture of avatar is displayed
     */
    @Test
    public void myAvatar_shouldBeDisplayed() {
        onView(withId(R.id.avatarImageView)).check(matches(isDisplayed()));
    }

    /**
     * test verifying that at the start of this new screen, the TextView indicating
     * the name of the user in question is correctly filled in
     */
    @Test
    public void textsViews_correctlyFilledIn() {
        onView(withId(R.id.firstNameTextView)).check(matches(withText("test")));
        onView(withId(R.id.firstNameTextView2)).check(matches(withText("test")));
        onView(withId(R.id.addressTextView)).check(matches(withText("address")));
        onView(withId(R.id.phoneNumberTextView)).check(matches(withText("phoneNumber")));
        onView(withId(R.id.emailTextView)).check(matches(withText(containsString("test"))));
        onView(withId(R.id.commentsTextView)).check(matches(withText("aboutMe")));
    }

    /**
     * When we click an favorite button, the button is clickable and displayed
     */
    @Test
    public void myFavoriteButton_isClickableAndDisplayed() {
        onView(withId(R.id.favoriteFloatingActionButton))
                .perform(ViewActions.click());
        onView(withId(R.id.favoriteFloatingActionButton)).check(matches(isDisplayed()));
    }
}