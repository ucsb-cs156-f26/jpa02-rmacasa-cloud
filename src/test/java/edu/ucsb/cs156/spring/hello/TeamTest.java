package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
        assert (team.getName().equals("test-team"));
    }

    @Test
    public void default_constructor_sets_empty_name_and_members() {
        Team t = new Team();
        assertEquals("", t.getName());
        assertTrue(t.getMembers().isEmpty());
    }

    @Test
    public void setName_changes_name() {
        team.setName("new-name");
        assertEquals("new-name", team.getName());
    }

    @Test
    public void setMembers_changes_members() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Alice");
        team.setMembers(list);
        assertEquals(list, team.getMembers());
    }

    @Test
    public void addMember_adds_member() {
        team.addMember("Alice");
        assertEquals(1, team.getMembers().size());
        assertTrue(team.getMembers().contains("Alice"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
        team.addMember("Alice");
        assertEquals("Team(name=test-team, members=[Alice])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_different_class() {
        assertFalse(team.equals("test-team"));
    }

    @Test
    public void equals_returns_false_for_null() {
        assertFalse(team.equals(null));
    }

    @Test
    public void equals_returns_true_for_same_name_and_members() {
        Team other = new Team("test-team");
        team.addMember("Alice");
        other.addMember("Alice");
        assertEquals(team, other);
    }

    @Test
    public void equals_returns_false_for_different_name_same_members() {
        Team other = new Team("other-team");
        team.addMember("Alice");
        other.addMember("Alice");
        assertNotEquals(team, other);
    }

    @Test
    public void equals_returns_false_for_same_name_different_members() {
        Team other = new Team("test-team");
        team.addMember("Alice");
        other.addMember("Bob");
        assertNotEquals(team, other);
    }

    @Test
    public void equal_teams_have_equal_hashCodes() {
        Team other = new Team("test-team");
        team.addMember("a");
        other.addMember("a");
        assertEquals(team.hashCode(), other.hashCode());
    }

    @Test
    public void hashCode_returns_expected_value() {
        team.addMember("a");
        assertEquals(-1226298696, team.hashCode());
    }
}