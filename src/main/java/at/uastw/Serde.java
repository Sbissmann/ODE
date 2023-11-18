package at.uastw;

/**
 * Diese Klasse sollten Sie nicht verändern.
 */
public interface Serde {
    String serializeLibrary(Library library);

    Library deserializeLibrary(String libraryJson);
}
