package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.listing.Listing;
import seedu.address.model.offer.Offer;
import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<Listing> PREDICATE_SHOW_ALL_LISTINGS = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<Offer> PREDICATE_SHOW_ALL_OFFERS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Gets the person with the given name {@code name}.
     * @param name name of the person
     * @return person with given name
     */
    Person getPerson(Name name);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /**
     * Returns true if a listing with the same identity as {@code listing} exists in the address book.
     */
    boolean hasListing(Listing listing);

    /**
     * Deletes the given listing.
     * The listing must exist in the address book.
     */
    void deleteListing(Listing target);

    /**
     * Adds the given listing.
     * {@code listing} must not already exist in the address book.
     */
    void addListing(Listing listing);

    /**
     * Gets the listing with the given id {@code id}.
     * @param id id of the listing
     * @return listing with given id
     */
    Listing getListing(String id);

    /**
     * Replaces the given listing {@code target} with {@code editedListing}.
     * {@code target} must exist in the address book.
     * The listing identity of {@code editedListing} must not be the same
     * as another existing listing in the address book.
     */
    void setListing(Listing listing, Listing editedListing);

    /** Returns an unmodifiable view of the filtered listings list */
    ObservableList<Listing> getFilteredListingList();

    /**
     * Updates the filter of the filtered listings list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredListingList(Predicate<Listing> predicate);

    /**
     * Returns true if an offer with the same identity as {@code offer} exists in the address book.
     */
    boolean hasOffer(Offer offer);

    /**
     * Deletes the given offer.
     * The offer must exist in the address book.
     */
    void deleteOffer(Offer target);

    /**
     * Adds the given offer.
     * {@code offer} must not already exist in the address book.
     */
    void addOffer(Offer offer);

    /**
     * Gets the offer from the given name {@code name} and listing address {@code address}.
     * @param name name of the person in offer
     * @param address listing address of offer
     * @return offer with given name and listing address
     */
    public Offer getOffer(Name name, Address address);

    /**
     * Replaces the given offer {@code target} with {@code editedOffer}.
     * {@code target} must exist in the address book.
     * The offer identity of {@code editedOffer} must not be the same as another existing offer in the address book.
     */
    void setOffer(Offer target, Offer editedOffer);

    /** Returns an unmodifiable view of the filtered offer list */
    ObservableList<Offer> getFilteredOfferList();

    /**
     * Updates the filter of the filtered offer list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredOfferList(Predicate<Offer> predicate);

}
