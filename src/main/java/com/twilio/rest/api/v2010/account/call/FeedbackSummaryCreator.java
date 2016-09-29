/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.call;

import com.twilio.base.Creator;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.LocalDate;

import java.net.URI;

public class FeedbackSummaryCreator extends Creator<FeedbackSummary> {
    private String accountSid;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private Boolean includeSubaccounts;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;

    /**
     * Construct a new FeedbackSummaryCreator.
     * 
     * @param startDate The start_date
     * @param endDate The end_date
     */
    public FeedbackSummaryCreator(final LocalDate startDate, 
                                  final LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Construct a new FeedbackSummaryCreator.
     * 
     * @param accountSid The account_sid
     * @param startDate The start_date
     * @param endDate The end_date
     */
    public FeedbackSummaryCreator(final String accountSid, 
                                  final LocalDate startDate, 
                                  final LocalDate endDate) {
        this.accountSid = accountSid;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * The include_subaccounts.
     * 
     * @param includeSubaccounts The include_subaccounts
     * @return this
     */
    public FeedbackSummaryCreator setIncludeSubaccounts(final Boolean includeSubaccounts) {
        this.includeSubaccounts = includeSubaccounts;
        return this;
    }

    /**
     * The status_callback.
     * 
     * @param statusCallback The status_callback
     * @return this
     */
    public FeedbackSummaryCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * The status_callback.
     * 
     * @param statusCallback The status_callback
     * @return this
     */
    public FeedbackSummaryCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The status_callback_method.
     * 
     * @param statusCallbackMethod The status_callback_method
     * @return this
     */
    public FeedbackSummaryCreator setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created FeedbackSummary
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public FeedbackSummary create(final TwilioRestClient client) {
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.accountSid + "/Calls/FeedbackSummary.json",
            client.getRegion()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("FeedbackSummary creation failed: Unable to connect to server");
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

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (startDate != null) {
            request.addPostParam("StartDate", DateConverter.dateStringFromLocalDate(startDate));
        }
        
        if (endDate != null) {
            request.addPostParam("EndDate", DateConverter.dateStringFromLocalDate(endDate));
        }
        
        if (includeSubaccounts != null) {
            request.addPostParam("IncludeSubaccounts", includeSubaccounts.toString());
        }
        
        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }
        
        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());
        }
    }
}