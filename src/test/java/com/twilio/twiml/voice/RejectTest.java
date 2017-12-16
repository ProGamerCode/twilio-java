/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link Reject}
 */
public class RejectTest {
    @Test
    public void testEmptyElement() {
        Reject elem = new Reject.Builder().build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Reject/>",
            elem.toXml()
        );
    }

    @Test
    public void testEmptyElementUrl() {
        Reject elem = new Reject.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CReject%2F%3E", elem.toUrl());
    }

    @Test
    public void testElementWithParams() {
        Reject elem = new Reject.Builder().reason(Reject.Reason.REJECTED).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Reject reason=\"rejected\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithExtraAttributes() {
        Reject elem = new Reject.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Reject a=\"b\" foo=\"bar\"/>",
            elem.toXml()
        );
    }
}