package com.family.family_members_api.family;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;
import java.util.logging.Logger;

import static java.lang.String.format;

@ShellComponent
public class SSHCommand {

    private final SendRequestsService sendRequestsService = new SendRequestsService(new RestTemplateBuilder());
    Logger log = Logger.getLogger(SSHCommand.class.getName());

    @ShellMethod(value = "make a get request with params")
    public String makeGetRequest(@ShellOption(value = "-s") String endpoint) {
        return sendRequestsService.getPostsPlainJSON(endpoint);
    }

    @ShellMethod(value = "make a get request with params")
    public List makeGetRequestList(@ShellOption(value = "-s") String endpoint) {
        FluxFromIterable.main(sendRequestsService.getListResponse(endpoint));
        return sendRequestsService.getListResponse(endpoint);
    }

}