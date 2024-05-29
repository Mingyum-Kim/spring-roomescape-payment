package roomescape.reservation.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import roomescape.member.domain.Member;
import roomescape.reservation.domain.Reservation;
import roomescape.reservation.domain.ReservationTime;
import roomescape.reservation.domain.Status;
import roomescape.reservation.domain.Theme;

public record ReservationRequest(
        @NotNull Long memberId,
        @NotNull LocalDate date,
        @NotNull Long themeId,
        @NotNull Long timeId
) {
    public static ReservationRequest of(ReservationPaymentSaveRequest detail, Long memberId) {
        return new ReservationRequest(
                memberId,
                detail.date(),
                detail.themeId(),
                detail.timeId()
        );
    }

    public static ReservationRequest from(ReservationPaymentRequest request) {
        return new ReservationRequest(
                request.memberId(),
                request.date(),
                request.themeId(),
                request.timeId()
        );
    }

    public Reservation toReservation(Member member, Theme theme, ReservationTime reservationTime) {
        return new Reservation(member, date, theme, reservationTime, Status.SUCCESS);
    }
}