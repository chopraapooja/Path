package com.path;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by poojar on 3/7/2015.
 */
public class PathsManagerTest {
    PathsManager mgr = new PathsManager();

    @Test
    public void isDirectPathBetween_Bangalore_and_Singapore_should_be_true(){
        boolean isDirectPath = mgr.isDirectPathBetween("Bangalore", "Singapore");
        assertTrue(isDirectPath);
    }

    @Test
    public void isDirectPathBetween_Bangalore_and_Tokyo_should_give_false(){
        boolean isDirectPath = mgr.isDirectPathBetween("Bangalore", "Tokyo");
        assertFalse(isDirectPath);
    }

    @Test
    public void isDirectPathBetween_Bangalore_and_GUMNAM_should_give_false(){
        boolean isDirectPath = mgr.isDirectPathBetween("Bangalore", "GUMNAM");
        assertFalse(isDirectPath);
    }

    @Test
    public void isDirectPathBetween_GUMNAMCity1_and_GUMNAMCity2_should_give_false(){
        boolean isDirectPath = mgr.isDirectPathBetween("GUMNAMCity1", "GUMNAMCity2");
        assertFalse(isDirectPath);
    }

    @Test
    public void doExistsAsSource_Bangalore_should_give_true() {
        boolean isAvailable = mgr.doExistsAsSource("Bangalore");
        assertTrue(isAvailable);
    }

    @Test
    public void doExistsAsSource_GUMNAM_should_give_false() {
        boolean isAvailable = mgr.doExistsAsSource("GUMNAM");
        assertFalse(isAvailable);
    }

    @Test
    public void doExistsAsDestination_Singapore_should_give_true() {
        assertTrue(mgr.doExistsAsDestination("Singapore"));
    }

    @Test
    public void doExistsAsDestination_GUMNAM_should_give_false() {
        assertFalse(mgr.doExistsAsDestination("GUMNAM"));
    }

    @Test
    public void isThereAnyPathBetween_Bangalore_Tokyo_should_give_TRUE() {
        assertTrue(mgr.isThereAnyPathBetween("Bangalore", "Tokyo"));
    }

    @Test
    public void isThereAnyPathBetween_Tokyo_Bangalore_should_give_TRUE() {
        assertTrue(mgr.isThereAnyPathBetween("Tokyo", "Bangalore"));
    }

    @Test
    public void isThereAnyPathBetween_Tokyo_Chennai_should_give_FALSE() {
        assertFalse(mgr.isThereAnyPathBetween("Patiala", "Singapore"));
    }

}


























