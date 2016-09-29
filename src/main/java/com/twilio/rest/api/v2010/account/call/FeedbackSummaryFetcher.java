/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.call;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class FeedbackSummaryFetcher extends Fetcher<FeedbackSummary> {
    private String accountSid;
    private final String sid;

    /**
     * Construct a new FeedbackSummaryFetcher.
     * 
     * @param sid The sid
     */
    public FeedbackSummaryFetcher(final String sid) {
        this.sid = sid;
    }

    /**
     * Construct a new FeedbackSummaryFetcher.
     * 
     * @param accountSid The account_sid
     * @param sid The sid
     */
    public FeedbackSummaryFetcher(final String accountSid, 
                                  final String sid) {
        this.accountSid = accountSid;
        this.sid = sid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched FeedbackSummary
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public FeedbackSummary fetch(final TwilioRestClient client) {
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.accountSid + "/Calls/FeedbackSummary/" + this.sid + ".json",
            client.getRegion()
        );
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("FeedbackSummary fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return FeedbackSummary.fromJson(response.getStream(), client.getObjectMapper());
    }
}