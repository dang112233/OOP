package hus.oop.lab11.iterator.pseudocode;

public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileId);
    ProfileIterator createCoworkersIterator(String profileId);
}
