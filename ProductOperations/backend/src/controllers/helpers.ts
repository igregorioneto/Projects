import { HttpResponse, HttpStatusCode } from "./protocols";

export const ok = <T>(body: any): HttpResponse<T> => ({
    status: HttpStatusCode.CREATED,
    body
});

export const created = <T>(body: any): HttpResponse<T> => ({
    status: HttpStatusCode.CREATED,
    body
});

export const badRequest = (message: string): HttpResponse<string> => ({
    status: HttpStatusCode.BAD_REQUEST,
    body: message,
});

export const serverError = (): HttpResponse<string> => ({
    status: HttpStatusCode.SERVER_ERROR,
    body: "Error server..."
});