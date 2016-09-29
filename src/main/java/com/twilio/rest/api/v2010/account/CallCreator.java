/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.type.Endpoint;

import java.net.URI;
import java.util.List;

public class CallCreator extends Creator<Call> {
    private String accountSid;
    private final com.twilio.type.Endpoint to;
    private final com.twilio.type.PhoneNumber from;
    private URI url;
    private String applicationSid;
    private HttpMethod method;
    private URI fallbackUrl;
    private HttpMethod fallbackMethod;
    private URI statusCallback;
    private List<String> statusCallbackEvent;
    private HttpMethod statusCallbackMethod;
    private String sendDigits;
    private String ifMachine;
    private Integer timeout;
    private Boolean record;
    private String recordingChannels;
    private String recordingStatusCallback;
    private HttpMethod recordingStatusCallbackMethod;
    private String sipAuthUsername;
    private String sipAuthPassword;

    /**
     * Construct a new CallCreator.
     * 
     * @param to Phone number, SIP address or client identifier to call
     * @param from Twilio number from which to originate the call
     * @param url Url from which to fetch TwiML
     */
    public CallCreator(final com.twilio.type.Endpoint to, 
                       final com.twilio.type.PhoneNumber from, 
                       final URI url) {
        this.to = to;
        this.from = from;
        this.url = url;
    }

    /**
     * Construct a new CallCreator.
     * 
     * @param accountSid The account_sid
     * @param to Phone number, SIP address or client identifier to call
     * @param from Twilio number from which to originate the call
     * @param url Url from which to fetch TwiML
     */
    public CallCreator(final String accountSid, 
                       final com.twilio.type.Endpoint to, 
                       final com.twilio.type.PhoneNumber from, 
                       final URI url) {
        this.accountSid = accountSid;
        this.to = to;
        this.from = from;
        this.url = url;
    }

    /**
     * Construct a new CallCreator.
     * 
     * @param to Phone number, SIP address or client identifier to call
     * @param from Twilio number from which to originate the call
     * @param applicationSid ApplicationSid that configures from where to fetch
     *                       TwiML
     */
    public CallCreator(final com.twilio.type.Endpoint to, 
                       final com.twilio.type.PhoneNumber from, 
                       final String applicationSid) {
        this.to = to;
        this.from = from;
        this.applicationSid = applicationSid;
    }

    /**
     * Construct a new CallCreator.
     * 
     * @param accountSid The account_sid
     * @param to Phone number, SIP address or client identifier to call
     * @param from Twilio number from which to originate the call
     * @param applicationSid ApplicationSid that configures from where to fetch
     *                       TwiML
     */
    public CallCreator(final String accountSid, 
                       final com.twilio.type.Endpoint to, 
                       final com.twilio.type.PhoneNumber from, 
                       final String applicationSid) {
        this.accountSid = accountSid;
        this.to = to;
        this.from = from;
        this.applicationSid = applicationSid;
    }

    /**
     * The HTTP method Twilio should use when requesting the URL. Defaults to
     * `POST`. If an `ApplicationSid` was provided, this parameter is ignored..
     * 
     * @param method HTTP method to use to fetch TwiML
     * @return this
     */
    public CallCreator setMethod(final HttpMethod method) {
        this.method = method;
        return this;
    }

    /**
     * A URL that Twilio will request if an error occurs requesting or executing the
     * TwiML at `Url`. If an `ApplicationSid` was provided, this parameter is
     * ignored..
     * 
     * @param fallbackUrl Fallback URL in case of error
     * @return this
     */
    public CallCreator setFallbackUrl(final URI fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
        return this;
    }

    /**
     * A URL that Twilio will request if an error occurs requesting or executing the
     * TwiML at `Url`. If an `ApplicationSid` was provided, this parameter is
     * ignored..
     * 
     * @param fallbackUrl Fallback URL in case of error
     * @return this
     */
    public CallCreator setFallbackUrl(final String fallbackUrl) {
        return setFallbackUrl(Promoter.uriFromString(fallbackUrl));
    }

    /**
     * The HTTP method that Twilio should use to request the `FallbackUrl`. Must be
     * either `GET` or `POST`. Defaults to `POST`. If an `ApplicationSid` was
     * provided, this parameter is ignored..
     * 
     * @param fallbackMethod HTTP Method to use with FallbackUrl
     * @return this
     */
    public CallCreator setFallbackMethod(final HttpMethod fallbackMethod) {
        this.fallbackMethod = fallbackMethod;
        return this;
    }

    /**
     * A URL that Twilio will request when the call ends to notify your app. If an
     * `ApplicationSid` was provided, this parameter is ignored..
     * 
     * @param statusCallback Status Callback URL
     * @return this
     */
    public CallCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * A URL that Twilio will request when the call ends to notify your app. If an
     * `ApplicationSid` was provided, this parameter is ignored..
     * 
     * @param statusCallback Status Callback URL
     * @return this
     */
    public CallCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The status_callback_event.
     * 
     * @param statusCallbackEvent The status_callback_event
     * @return this
     */
    public CallCreator setStatusCallbackEvent(final List<String> statusCallbackEvent) {
        this.statusCallbackEvent = statusCallbackEvent;
        return this;
    }

    /**
     * The status_callback_event.
     * 
     * @param statusCallbackEvent The status_callback_event
     * @return this
     */
    public CallCreator setStatusCallbackEvent(final String statusCallbackEvent) {
        return setStatusCallbackEvent(Promoter.listOfOne(statusCallbackEvent));
    }

    /**
     * The HTTP method that Twilio should use to request the `StatusCallback`.
     * Defaults to `POST`. If an `ApplicationSid` was provided, this parameter is
     * ignored..
     * 
     * @param statusCallbackMethod HTTP Method to use with StatusCallback
     * @return this
     */
    public CallCreator setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * A string of keys to dial after connecting to the number. Valid digits in the
     * string include: any digit (`0`-`9`), '`#`', '`*`' and '`w`' (to insert a half
     * second pause). For example, if you connected to a company phone number, and
     * wanted to pause for one second, dial extension 1234 and then the pound key,
     * use `ww1234#`..
     * 
     * @param sendDigits Digits to send
     * @return this
     */
    public CallCreator setSendDigits(final String sendDigits) {
        this.sendDigits = sendDigits;
        return this;
    }

    /**
     * Tell Twilio to try and determine if a machine (like voicemail) or a human has
     * answered the call. Possible value are `Continue` and `Hangup`..
     * 
     * @param ifMachine Action to take if a machine has answered the call
     * @return this
     */
    public CallCreator setIfMachine(final String ifMachine) {
        this.ifMachine = ifMachine;
        return this;
    }

    /**
     * The integer number of seconds that Twilio should allow the phone to ring
     * before assuming there is no answer. Default is `60` seconds, the maximum is
     * `999` seconds. Note, you could set this to a low value, such as `15`, to
     * hangup before reaching an answering machine or voicemail..
     * 
     * @param timeout Number of seconds to wait for an answer
     * @return this
     */
    public CallCreator setTimeout(final Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * Set this parameter to true to record the entirety of a phone call. The
     * RecordingUrl will be sent to the StatusCallback URL. Defaults to false..
     * 
     * @param record Whether or not to record the Call
     * @return this
     */
    public CallCreator setRecord(final Boolean record) {
        this.record = record;
        return this;
    }

    /**
     * The recording_channels.
     * 
     * @param recordingChannels The recording_channels
     * @return this
     */
    public CallCreator setRecordingChannels(final String recordingChannels) {
        this.recordingChannels = recordingChannels;
        return this;
    }

    /**
     * The recording_status_callback.
     * 
     * @param recordingStatusCallback The recording_status_callback
     * @return this
     */
    public CallCreator setRecordingStatusCallback(final String recordingStatusCallback) {
        this.recordingStatusCallback = recordingStatusCallback;
        return this;
    }

    /**
     * The recording_status_callback_method.
     * 
     * @param recordingStatusCallbackMethod The recording_status_callback_method
     * @return this
     */
    public CallCreator setRecordingStatusCallbackMethod(final HttpMethod recordingStatusCallbackMethod) {
        this.recordingStatusCallbackMethod = recordingStatusCallbackMethod;
        return this;
    }

    /**
     * The sip_auth_username.
     * 
     * @param sipAuthUsername The sip_auth_username
     * @return this
     */
    public CallCreator setSipAuthUsername(final String sipAuthUsername) {
        this.sipAuthUsername = sipAuthUsername;
        return this;
    }

    /**
     * The sip_auth_password.
     * 
     * @param sipAuthPassword The sip_auth_password
     * @return this
     */
    public CallCreator setSipAuthPassword(final String sipAuthPassword) {
        this.sipAuthPassword = sipAuthPassword;
        return this;
    }

    /**
     * The fully qualified URL that should be consulted when the call connects. Just
     * like when you set a URL on a phone number for handling inbound calls..
     * 
     * @param url Url from which to fetch TwiML
     * @return this
     */
    public CallCreator setUrl(final URI url) {
        this.url = url;
        return this;
    }

    /**
     * The fully qualified URL that should be consulted when the call connects. Just
     * like when you set a URL on a phone number for handling inbound calls..
     * 
     * @param url Url from which to fetch TwiML
     * @return this
     */
    public CallCreator setUrl(final String url) {
        return setUrl(Promoter.uriFromString(url));
    }

    /**
     * The 34 character sid of the application Twilio should use to handle this
     * phone call. If this parameter is present, Twilio will ignore all of the voice
     * URLs passed and use the URLs set on the application..
     * 
     * @param applicationSid ApplicationSid that configures from where to fetch
     *                       TwiML
     * @return this
     */
    public CallCreator setApplicationSid(final String applicationSid) {
        this.applicationSid = applicationSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Call
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Call create(final TwilioRestClient client) {
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.accountSid + "/Calls.json",
            client.getRegion()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Call creation failed: Unable to connect to server");
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
        
        return Call.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (to != null) {
            request.addPostParam("To", to.getEndpoint());
        }
        
        if (from != null) {
            request.addPostParam("From", from.toString());
        }
        
        if (url != null) {
            request.addPostParam("Url", url.toString());
        }
        
        if (applicationSid != null) {
            request.addPostParam("ApplicationSid", applicationSid);
        }
        
        if (method != null) {
            request.addPostParam("Method", method.toString());
        }
        
        if (fallbackUrl != null) {
            request.addPostParam("FallbackUrl", fallbackUrl.toString());
        }
        
        if (fallbackMethod != null) {
            request.addPostParam("FallbackMethod", fallbackMethod.toString());
        }
        
        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }
        
        if (statusCallbackEvent != null) {
            for (String prop : statusCallbackEvent) {
                request.addPostParam("StatusCallbackEvent", prop);
            }
        }
        
        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());
        }
        
        if (sendDigits != null) {
            request.addPostParam("SendDigits", sendDigits);
        }
        
        if (ifMachine != null) {
            request.addPostParam("IfMachine", ifMachine);
        }
        
        if (timeout != null) {
            request.addPostParam("Timeout", timeout.toString());
        }
        
        if (record != null) {
            request.addPostParam("Record", record.toString());
        }
        
        if (recordingChannels != null) {
            request.addPostParam("RecordingChannels", recordingChannels);
        }
        
        if (recordingStatusCallback != null) {
            request.addPostParam("RecordingStatusCallback", recordingStatusCallback);
        }
        
        if (recordingStatusCallbackMethod != null) {
            request.addPostParam("RecordingStatusCallbackMethod", recordingStatusCallbackMethod.toString());
        }
        
        if (sipAuthUsername != null) {
            request.addPostParam("SipAuthUsername", sipAuthUsername);
        }
        
        if (sipAuthPassword != null) {
            request.addPostParam("SipAuthPassword", sipAuthPassword);
        }
    }
}