package seedu.address.model.offer;

import seedu.address.model.person.Address;
import seedu.address.model.person.Name;

/**
 * Offer Class represents a client's offer for a listing, containing an offer price.
 */
public class Offer {

    /**
     * Name of client making the offer.
     */
    private final Name client;
    /**
     * Address of the listing the offer is for.
     */
    private final Address listing;
    /**
     * Price client is offering for the listing.
     */
    private final Price offerPrice;

    /**
     * Constructor for offer object.
     *
     * @param client Name
     * @param listing Address
     * @param offerPrice Price
     */
    public Offer(Name client, Address listing, Price offerPrice) {
        this.client = client;
        this.listing = listing;
        this.offerPrice = offerPrice;
    }

    /**
     * Getter for client.
     * @return Person
     */
    public Name getClient() {
        return client;
    }

    /**
     * Getter for listing.
     * @return Listing
     */
    public Address getListing() {
        return listing;
    }

    /**
     * Getter for offer price.
     * @return int
     */
    public Price getOfferPrice() {
        return offerPrice;
    }

    /**
     * Returns true if both offers have the same identity and data fields.
     * This defines a stronger notion of equality between two offers.
     */
    public boolean isSameOffer(Offer other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Offer)) {
            return false;
        }
        Offer otherOffer = (Offer) other;
        return otherOffer.getClient().equals(getClient())
                && otherOffer.getListing().equals(getListing())
                && otherOffer.getOfferPrice().equals(getOfferPrice());
    }

    /**
     * String representation of offer.
     * @return String
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Listing address: ")
                .append(getListing())
                .append("; Client: ")
                .append(getClient())
                .append("; Offer Price: S$")
                .append(getOfferPrice());
        return builder.toString();
    }
}
