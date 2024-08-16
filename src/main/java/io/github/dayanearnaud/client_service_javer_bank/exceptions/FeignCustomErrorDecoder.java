package io.github.dayanearnaud.client_service_javer_bank.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FeignCustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus status = HttpStatus.resolve(response.status());

        if(status == HttpStatus.BAD_REQUEST) {
            return new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro de requisição: dados inválidos ou duplicados.");
        } else if (status == HttpStatus.NOT_FOUND) {
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Recurso não encontrado.");
        } else if (status == HttpStatus.INTERNAL_SERVER_ERROR) {
            return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.");
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }
}
