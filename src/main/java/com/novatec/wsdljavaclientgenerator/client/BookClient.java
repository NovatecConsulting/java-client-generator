package com.novatec.wsdljavaclientgenerator.client;

import com.novatec.wsdljavaclientgenerator.client.gen.GetBookRequest;
import com.novatec.wsdljavaclientgenerator.client.gen.GetBookResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class BookClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(BookClient.class);

    public GetBookResponse getBook(String book) {
        GetBookRequest request = new GetBookRequest();
        request.setName(book);
        logger.info("Requesting information for " + book);
        GetBookResponse response = (GetBookResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        return response;
    }

}