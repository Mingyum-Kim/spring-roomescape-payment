package roomescape.reservation.controller.dto.response;

public record PaymentErrorResponse(
        String code,
        String message
) {
}
