/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml;

import com.twilio.http.HttpMethod;
import com.twilio.twiml.messaging.Message;
import com.twilio.twiml.messaging.Redirect;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;

/**
 * Test class for {@link MessagingResponse}
 */
public class MessagingResponseTest {
    @Test
    public void testEmptyElement() {
        MessagingResponse elem = new MessagingResponse.Builder().build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Response/>",
            elem.toXml()
        );
    }

    @Test
    public void testEmptyElementUrl() {
        MessagingResponse elem = new MessagingResponse.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CResponse%2F%3E", elem.toUrl());
    }

    @Test
    public void testElementWithExtraAttributes() {
        MessagingResponse elem = new MessagingResponse.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Response a=\"b\" foo=\"bar\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithChildren() {
        MessagingResponse.Builder builder = new MessagingResponse.Builder();

        builder.message(new Message.Builder("body")
                    .to("to")
                    .from("from")
                    .action(URI.create("https://example.com"))
                    .method(HttpMethod.GET)
                    .statusCallback(URI.create("https://example.com"))
                    .build());

        builder.redirect(new Redirect.Builder(URI.create("https://example.com")).method(HttpMethod.GET).build());

        MessagingResponse elem = builder.build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Response>" +
                "<Message action=\"https://example.com\" from=\"from\" method=\"GET\" statusCallback=\"https://example.com\" to=\"to\">body</Message>" +
                "<Redirect method=\"GET\">https://example.com</Redirect>" +
            "</Response>",
            elem.toXml()
        );
    }
}